import java.util.concurrent.BlockingQueue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionProducer implements Runnable {
    private final BlockingQueue<Transaction> queue;
    private final String producerName;

    private AtomicInteger finishedProducers;

    private final Random random = new Random();

    public TransactionProducer(BlockingQueue<Transaction> queue, String producerName, AtomicInteger finishedProducers) {
        this.queue = queue;
        this.producerName = producerName;
        this.finishedProducers = finishedProducers;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Transaction transaction = createTransaction(i);
                queue.put(transaction); // Bloque si la queue est pleine
                System.out.println(producerName + " produced: " + transaction);
                Thread.sleep(random.nextInt(1000)); // Simule un délai aléatoire
            }
            finishedProducers.addAndGet(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(producerName + " interrupted");
        }
    }

    private Transaction createTransaction(int index) {
        String id = producerName + "-" + index;
        double amount = 100 + random.nextDouble() * 900; // Entre 100 et 1000
        String type = random.nextBoolean() ? "DEBIT" : "CREDIT";
        return new Transaction(id, amount, type);
    }
}