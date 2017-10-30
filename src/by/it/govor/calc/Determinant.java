package by.it.govor.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.govor.calc.Patterns.exValVecMat;

public class Determinant  {
 private Map list = new HashMap<String,Var>();
    public Map<String,Var> variablePrint(){
    return list;
    }
    public void variableInput(String s){
    String[] pont = s.split("},\\{");



    }
    public void priority(String s){
        StringBuilder str = new StringBuilder(s);
        List<String> variable = new ArrayList<>();
        List<String> sign = new ArrayList<>();
       Pattern p = Pattern.compile(exValVecMat);
       Matcher m = p.matcher(str);
       while (m.find()){
           if (!m.group().equals("*")|| !m.group().equals("/") || !m.group().equals("+") || !m.group().equals("-")) {
               variable.add(m.group());
           } else {sign.add(m.group());}
       }
        }
    }

