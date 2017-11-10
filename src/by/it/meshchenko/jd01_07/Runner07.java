package by.it.meshchenko.jd01_07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Runner07 {
    public static void main(String[] args) throws IOException{
        int a;
        // Инициализация статических и логических блоков при создании объектов:
            // static блок инициализируется только один раз,
            //      при первом создании объекта или при
            //      первом обращении к static методу;
            // логический блок инициализируется каждый раз,
            //      и только, при создании объекта класса
//            System.out.println("Example1.main();");
//            Example1.main();
//
//            System.out.println("Example1 new1 = new Example1();");
//            Example1 new1 = new Example1();
//            System.out.println("Example1 new2 = new Example1();");
//            Example1 new2 = new Example1(); // ''
            //System.out.println("Example1.main();");
            //Example1.main();


        //***************************

        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileInTxt = src + "jd01_07/random.dat";
        //запись (все подряд)
        RandomAccessFile file = new RandomAccessFile(fileInTxt, "rw");
        String abc = "abcdefgh";
        String s2 = "12345678";
        // записываем строку переведенную в биты
        file.seek(4);
        file.write(abc.getBytes());
        file.seek(12);
        file.write(s2.getBytes());
        file.skipBytes(4);
        file.setLength(8);
        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
        //переоткроем его только для чтения
        file = new RandomAccessFile(fileInTxt, "r");
        long n=file.length();
        StringBuilder sb=new StringBuilder();
        for (long position = n-1; position >=0 ; position--) {
            file.seek(position);
            sb.append((char)file.read());
        }
        file.close();
        System.out.println(sb);




    }
}
