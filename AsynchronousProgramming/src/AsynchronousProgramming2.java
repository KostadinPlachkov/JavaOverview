// Synchronization

public class AsynchronousProgramming2 {
    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount();
        long money = 100000;
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < money; j++) {
                    bankAccount.deposit();
                }
            });
            threads[i].start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("Balance: " + bankAccount.getBalance());

    }
}

class BankAccount {
    private long balance;

    synchronized void deposit() {
        this.balance += (long) 1;
    }

    long getBalance() {
        return balance;
    }
}