package by.it.shelkovich.jd1_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util {

    static String readLine(){
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isReader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (Exception e){e.printStackTrace();}

        return line;
    }
}
