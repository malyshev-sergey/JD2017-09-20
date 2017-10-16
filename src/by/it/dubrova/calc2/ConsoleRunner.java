package by.it.dubrova.calc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {
    public static void main(String[] args) {
        double num1 = 12.5;
        double num2 = 5.5;

        Var a = new VarD(num1);
        Var b = new VarD(num2);

        a = a.add(b);
        VarV z = new VarV();
        z.fromString("{1,2,3,4}");


        System.out.println(z.value[3]);
    }
/*
    public static Var inputFromKeyboard() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String line = b.readLine();

        return Var;
    }
   */

}
