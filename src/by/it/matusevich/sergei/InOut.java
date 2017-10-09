package by.it.matusevich.sergei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InOut {

    public static String consoleRead () throws IOException{
        InputStreamReader istream = new InputStreamReader(System.in);
        BufferedReader line = new BufferedReader(istream);
        String out = line.readLine();
        return out;
    }
}
