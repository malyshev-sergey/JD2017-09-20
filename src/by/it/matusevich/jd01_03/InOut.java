package by.it.matusevich.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sergei on 29.09.2017.
 */
public class InOut {

    static Double [] masDouble () throws IOException {
        try(BufferedReader stin = new BufferedReader(new InputStreamReader(System.in))) {
            String line = stin.readLine();
            String[] strMas = line.split(" ");
            Double[] masDouble = new Double[strMas.length];
            for(int j = 0; j < strMas.length; j++){
                masDouble[j] = Double.parseDouble(strMas[j]);
            }
            return masDouble;
        }

    }
}
