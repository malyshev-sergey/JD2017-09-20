package by.it.mustaphin.jd02_01;

public class Market {

    void letIn() {
        for (int i = 0; i < 60; i++) {
            for (int k = (int) (Math.random() * 3); k > 0; k--) {
                new Buyer(i + " " + k);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
