package by.it.mustaphin.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private String value;
    Pattern patNumber = Pattern.compile("[.0-9]+");
    Pattern patVector = Pattern.compile("[{]");
    Pattern patMatrix = Pattern.compile("[{{]");

    public Parser(String value) {
        this.value = value;
    }

    void parse(String value) {
        Matcher matM = patMatrix.matcher(value);
        Matcher matV = patVector.matcher(value);
        if (matM.find()) {

        }else if(matV.find()){

        }
    }

}
