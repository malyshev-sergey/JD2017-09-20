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
    public static void sortVar(Map<String, Var> map){
        LinkedHashMap<String, Var> l = new LinkedHashMap<>();
        l.putAll(sortByKey(map));

        Iterator<Map.Entry<String, Var>> itM = l.entrySet().iterator();
        while (itM.hasNext()){
            Map.Entry<String, Var> temp = itM.next();
            System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue().toString());
        }
    }

    public static Var calculate(Expression expres){
        Var res = null;
        Iterator<Map.Entry<String, Var>> itM = expres.tempEx.entrySet().iterator();
        int i = -1;
        while (itM.hasNext()){

            Map.Entry<String, Var> temp = itM.next();
            if(res == null){
                res = temp.getValue();
            }
            //System.out.printf("%-8s %-20s %n", temp.getKey(),temp.getValue().toString());
            //calcCore(res, temp.getValue(), expres, i);
            else {
                if(expres.tempOp.size() > 0){
                    if(expres.tempOp.get(i).compareTo("+") == 0){
                        res = res.add(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("/") == 0){
                        res = res.div(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("*") == 0){
                        res = res.mul(temp.getValue());
                    }
                    else if(expres.tempOp.get(i).compareTo("-") == 0){
                        res = res.sub(temp.getValue());
                    }
                    else{}
                }
                else {
                    res = res.add(temp.getValue());
                }
            }
            i++;
        }


        return res;
    }
    private static void calcCore(Var res, Var var, Expression expres, int i){
        if(res == null){
            res = var;
            //System.out.println("" + res.toString());
            //res.assign(var);
        }
        else {
            if(expres.tempOp.get(i) == "+"){
                res = res.add(var);
            }
            else if(expres.tempOp.get(i) == "/"){
                res = res.div(var);
            }
            else if(expres.tempOp.get(i) == "*"){
                res = res.mul(var);
            }
            else if(expres.tempOp.get(i) == "-"){
                res = res.sub(var);
            }
            else{}
        }
    }

    public static <K extends Comparable<? super K>, V > Map<K, V> sortByKey(Map<K, V> map )
    {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o1.getKey()).compareTo( o2.getKey() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
