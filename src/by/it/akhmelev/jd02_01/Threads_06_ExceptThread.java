package by.it.akhmelev.jd02_01;

public class Threads_06_ExceptThread extends Thread {
    static class ExceptThread extends Thread {
        public void run() {
            boolean flag = Math.random()<0.9;
            if (flag) {
                throw new RuntimeException();
            }
            System.out.println("end of ExceptThread");
        }
    }

    public static void main(String[ ] args) throws InterruptedException {
        new ExceptThread().start();
        Thread.sleep(1000);
        System.out.println("end of main");
    }
}