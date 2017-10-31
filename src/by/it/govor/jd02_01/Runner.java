package by.it.govor.jd02_01;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        int nubler =0;
        boolean b=false;
        List<Buyer> buyers = new ArrayList<>();
        Random randomBuyer = new Random();
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <randomBuyer.nextInt(3) ; j++) {
                if(NewRandom.random(0,1)==0){
                 b=true;
                }else{b=false;}
                Buyer buyer = new Buyer(nubler++,b);
                buyer.start();
                buyers.add(buyer);

            }

        }
        for (Buyer buyer : buyers)
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Обслуживание завершено!");

    }
    }
