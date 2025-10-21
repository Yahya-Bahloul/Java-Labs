import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Queue partagée avec capacité limitée
        BlockingQueue<Transaction> queue = new LinkedBlockingQueue<>(10);
        AtomicInteger finishedProducers = new AtomicInteger(0);
        final int totalProducers = 2;


        // Créer 2 producers
        Thread producer1 = new Thread(new TransactionProducer(queue, "Producer-1", finishedProducers));
        Thread producer2 = new Thread(new TransactionProducer(queue, "Producer-2", finishedProducers));

        // Créer 2 consumers
        Thread consumer1 = new Thread(new TransactionConsumer(queue, "Consumer-1"));
        Thread consumer2 = new Thread(new TransactionConsumer(queue, "Consumer-2"));

        // Démarrer tous les threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        Thread.sleep(5000);
        consumer1.interrupt();
        consumer2.interrupt();

        System.out.println("Système de traitement de transactions démarré...");
    }
}