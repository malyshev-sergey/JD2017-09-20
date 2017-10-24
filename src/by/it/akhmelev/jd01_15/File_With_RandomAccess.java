package by.it.akhmelev.jd01_15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class File_With_RandomAccess {

    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
        String fileInTxt = src + "jd01_15/random.dat";
        //запись (все подряд)
        RandomAccessFile file = new RandomAccessFile(fileInTxt, "rw");
        String abc = "abcdefgh";
        // записываем строку переведенную в биты
        file.write(abc.getBytes());
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
