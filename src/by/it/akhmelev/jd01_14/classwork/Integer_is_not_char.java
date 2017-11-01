package by.it.akhmelev.jd01_14.classwork;

import java.io.*;

public class Integer_is_not_char {
    public static void main(String[ ] args) throws IOException {
        String src=System.getProperty("user.dir")+"/src/by/it/akhmelev/";
        String filename = src+"jd01_14/totext.txt";
        File f=new File(filename);
        //=============================================================
        //пример записи значений типа int в двоичный файл
        DataOutputStream dos = null;
        try {
            dos=new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                    //код большой английской буквы A
                    int a=65+i;
                    //склеим буквы по 4 одинаковых в один Integer
                    int res=((a<<24)+(a<<16)+(a<<8)+a);
                    dos.writeInt(res);
                    }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        }
        finally {
            if (dos!=null) {dos.close();}
        }
        //=============================================================
        //пример чтения из файла
        try (DataInputStream inp=new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
            )
        {
            double sum=0;
            double count=0;
            while (inp.available()>0) {
                int i=inp.readInt();
                sum=sum+i;
                count++;
            }
            System.out.println("Average=" + sum / count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
