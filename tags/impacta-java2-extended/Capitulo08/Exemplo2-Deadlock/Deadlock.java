package deadlock;

public class Deadlock {

    private static Thread t1 = new Thread() {
        public void run() {
            try {
                System.out.println("Aguardando thread 2...");
                t2.join();
                System.out.println("Thread 1 executada com sucesso.");
            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrompida.");
            }
        }
    };

    private static Thread t2 = new Thread() {
        public void run() {
            try {
                System.out.println("Aguardando thread 1...");
                t1.join();
                System.out.println("Thread 2 executada com sucesso.");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrompida.");
            }
        }
    };

    public static void main(String[] args) {
        System.out.println("Executando aplicacao...");
        t1.start();
        t2.start();
    }
}
