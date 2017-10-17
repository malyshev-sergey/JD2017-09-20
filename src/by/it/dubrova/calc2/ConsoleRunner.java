package by.it.dubrova.calc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleRunner {
    public static void main(String[] args) {
        double num1 = 5;
        double num2 = 5;

        Var a = new VarD(num1);
        Var b = new VarD(num2);

        a = a.add(b); // 10
        Var z = new VarV();
        ((VarV)z).fromString("{1,1,2}");
        z = z.add(a);

        System.out.println(z);
    }
/*
    public static Var inputFromKeyboard() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String line = b.readLine();

        return Var;
    }
   */

}
