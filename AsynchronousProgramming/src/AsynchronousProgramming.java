import java.util.Scanner;

public class AsynchronousProgramming {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           while(true) {
               // Running
               if (Thread.currentThread().isInterrupted()) {
                   System.out.println("The thread is interrupted");
                   break;
               }
           }
        });
//        thread.setDaemon(true);  // The main thread wont wait for the upper thread.
//        thread.run();  // The thread will be started in the main thread.
        thread.start();
        System.out.println("Thread started");
        System.out.println("Enter \"stop\" to exit");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if ("stop".equals(scanner.next())) {
                thread.interrupt();
                break;
            }
            else
                System.out.println("Main thread is listening");
        }
        System.out.println("Main thread is done");


        try {
            thread.join();  // This is done by default from the main thread.
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

