package by.it.malyshev.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Удаление комментариев из кода
 * @author Sergey Malyshev
 */
public class TaskB {

    public static void main(String[] args) {


        String dir = /*путь к этому файлу*/System.getProperty("user.dir") + "/src/by/it/malyshev/jd01_15";
        String filename = "TaskB.java";
        File f = new File(dir, filename);

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new /*создаем поток для чтения*/BufferedReader(new FileReader(f))) {

            String str;
            while ((str = br.readLine()) != null) {/*читаем из файла*/
                sb.append(str);
                sb.append("\r\n");
            }

            //     какой-то строчный комментарий
            //     какой-то строчный комментарий
            //     какой-то строчный комментарий
/*

какой-то блочный комментарий
какой-то блочный комментарий
какой-то блочный комментарий
какой-то блочный комментарий
*/
        } catch (IOException e) {
            e.printStackTrace();
        }

// удаляем строчные комментарии
        Matcher m = Pattern.compile("\\/\\/.+").matcher(sb);
        while (m.find()) {
            delComment(m,sb);
            m.reset();
        }

        /*удаляем блочные комментарии*/
        m = Pattern.compile("/\\*(.|\\r\\n)+?\\*/").matcher(sb);
        while (m.find()) {
            delComment(m,sb);
            m.reset();
        }

        // печатаем в файл и консоль
        filename = System.getProperty("user.dir") + "/src/by/it/malyshev/jd01_15/TaskB.txt";
        try (PrintWriter prt1 = new PrintWriter(new FileWriter(filename));
             PrintWriter prt2 = new PrintWriter(System.out)) {
            int counter = 1;
            for (String line : sb.toString().split("\n")) {
                prt1.printf("%2d %s\n", (counter), line);
                prt2.printf("%2d %s\n", (counter++), line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }  // main


    private static void delComment(Matcher m, StringBuilder sb) {

        int counter = m.start() - 1;
        while (counter >= 0 && sb.charAt(counter) != '\n') {// проверяем, есть ли в строке что-то полезное
            if (sb.charAt(counter) == ' ') counter--;
            else {
                counter = m.start();
                break;
            }
        }
        if (counter < m.start()) sb.delete(counter, m.end() + 1);// удаляем всю строку
        else sb.delete(counter, m.end());// удаляем только комментарий
    }


} // TaskB
