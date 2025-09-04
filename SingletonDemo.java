class Singleton {
    // Volatile ensures visibility across threads
    private static volatile Singleton instance;

    // Private constructor prevents instantiation
    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    // Thread-safe Singleton with double-checked locking
    public static Singleton getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) {  // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton! Instance hash: " + this.hashCode());
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Multiple threads trying to get Singleton instance
        Runnable task = () -> {
            Singleton s = Singleton.getInstance();
            s.showMessage();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
