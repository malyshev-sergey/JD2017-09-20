package by.it.meshchenko.jd01_14;

import java.io.*;

public class TaskA {
    public static void example1() throws IOException{
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileName = src + "jd01_14/int.dat";
        File f = new File(fileName);

        // Пишем в файл
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new FileOutputStream(f));
            for(int i = 0; i < 20; i++){
                dos.writeInt((int)(Math.random() * 20 + 10));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файла нет: " + fileName);
        }
        finally {
            if (dos!=null) {dos.close();}
        }

        //Читаем из файла
        try(DataInputStream inp = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))){

            double sum = 0;
            double count = 0;
            int i = 0;
            while(inp.available() > 0){
                i = inp.readInt();
                sum = sum + i;
                count++;
            }
            System.out.println("Average = " + sum / count);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
