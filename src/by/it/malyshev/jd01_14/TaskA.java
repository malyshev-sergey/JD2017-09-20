package by.it.malyshev.jd01_14;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {

        String src=System.getProperty("user.dir")+"/src/by/it/malyshev/";
        String filename = src+"jd01_14/integer.dat";
        File f=new File(filename);

        try {DataOutputStream a=new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                a.writeInt((int)(Math.random()*20-10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
