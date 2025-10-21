import java.util.concurrent.BlockingQueue;

public class TransactionConsumer implements Runnable {
    private final BlockingQueue<Transaction> queue;
    private final String consumerName;

    public TransactionConsumer(BlockingQueue<Transaction> queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Transaction transaction = queue.take(); // Bloque si la queue est vide
                processTransaction(transaction);
                Thread.sleep(1500); // Simule un traitement long
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(consumerName + " interrupted");
        }
    }

    private void processTransaction(Transaction transaction) {
        System.out.println(consumerName + " processing: " + transaction);
        // Simule le traitement
    }
}