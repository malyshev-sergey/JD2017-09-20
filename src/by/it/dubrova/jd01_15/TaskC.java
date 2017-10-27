package by.it.dubrova.jd01_15;

import java.lang.*;
import java.io.*;


public class TaskC {
    public static String lineFromKeyboard() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        return b.readLine();
    }



    public static void main(String[] args) throws IOException {
        String line = null;
        Cmd.start();

        while (true) {
            line = lineFromKeyboard();
            if (line.equals("exit")) break;
            else
                Cmd.line(line);
        }

    }
}
