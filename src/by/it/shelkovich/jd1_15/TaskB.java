package by.it.shelkovich.jd1_15;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskB {
    static void run(){
        String pathStr = System.getProperty("user.dir") + "/src/by/it/shelkovich/jd1_15/";
        Path path = Paths.get(pathStr + "TaskB.java");

        //comment1;
        /* multiline comment */
        StringBuilder sb = null; //endline comment;
        /* multiline incapsulating //line comment*/

        try(BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            sb = new StringBuilder();
            String line;
            int lineN = 1;
            while ((line = br.readLine()) != null){
                sb.append(lineN).append(" ").append(line).append("\n");
                lineN++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(sb.toString());

        String multiLineCommentPattern = "(/\\*)([^/]|([/])(?!\\*))+(?<!\\\\)(\\*/)([\n]*)";
        String singleLineCommentPattern = "([/]{2,})(.*)[\n]";

        String result = sb.toString().replaceAll(multiLineCommentPattern, "\n").replaceAll(singleLineCommentPattern, "\n");
        System.out.println(result);

        path = Paths.get(pathStr + "TaskB.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString()))) {
            bw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
