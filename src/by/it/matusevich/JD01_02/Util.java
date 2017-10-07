package by.it.matusevich.JD01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sergei on 29.09.2017.
 */
class Util {

    static String getOneLine () throws IOException{
        try(BufferedReader stin = new BufferedReader(new InputStreamReader(System.in))) {
            return stin.readLine();
        }

    }

}
