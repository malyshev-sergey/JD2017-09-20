package by.it.meshchenko.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static void printVar(HashMap<String, Var> map){
        Iterator<Map.Entry<String, Var>> itM = map.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, Var> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue().toString());
        }
    }
    public static void sortVar(HashMap<String, Var> map){
        HashMap<String, Var> l = new HashMap<>();
        l.putAll(map);
        printVar(l);
    }

    public static Var DefineTypeVariable(String str){
        Var res = null;
        Pattern pVarF = Pattern.compile(Patterns.exVal);
        Pattern pVarV = Pattern.compile(Patterns.exVec);
        Pattern pVarM = Pattern.compile(Patterns.exMat);
        Matcher mVarF = pVarF.matcher(str);
        Matcher mVarV = pVarV.matcher(str);
        Matcher mVarM = pVarM.matcher(str);
        if(mVarF.matches()){
            return res = new VarF(str);
        }
        else if(mVarV.matches()){
            return res = new VarV(str);
        }
        else if(mVarM.matches()){
            return res = new VarM(str);
        }
        return res;
    }
}
