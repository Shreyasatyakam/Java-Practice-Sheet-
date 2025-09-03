public class DeadlockDemo {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        // ❌ Deadlock example
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Locked lock1");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (lock2) {
                    System.out.println("Thread 1: Locked lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Locked lock2");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (lock1) {
                    System.out.println("Thread 2: Locked lock1");
                }
            }
        });

        t1.start();
        t2.start();

        // ✅ Solution: always lock in the SAME order
        Thread t3 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 3: Locked lock1 safely");

                synchronized (lock2) {
                    System.out.println("Thread 3: Locked lock2 safely");
                }
            }
        });

        Thread t4 = new Thread(() -> {
            synchronized (lock1) { // same order: lock1 -> lock2
                System.out.println("Thread 4: Locked lock1 safely");

                synchronized (lock2) {
                    System.out.println("Thread 4: Locked lock2 safely");
                }
            }
        });

        t3.start();
        t4.start();
    }
}
