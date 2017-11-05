package by.it.meshchenko.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class Expression {
    private String name;
    private String strValue;
    public LinkedHashMap<String, Var> tempEx;
    public ArrayList<String> tempOp;

    public Expression() {
        this.tempEx = new LinkedHashMap<String, Var>();
        this.tempOp = new ArrayList<String>();
    }
    public Expression(LinkedHashMap<String, Var> tempEx, ArrayList<String> tempOp) {
        this.tempEx = tempEx;
        this.tempOp = tempOp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public boolean isBrackets(String str){
        boolean res = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case '{': stack.push('{'); break;
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case '}':
                    if(!stack.isEmpty() && stack.pop().compareTo('{') == 0){ break; }
                    else{ return res;}
                case ')':
                    if(!stack.isEmpty() && stack.pop().compareTo('(') == 0){ break; }
                    else{ return res; }
                case ']':
                    if(!stack.isEmpty() && stack.pop().compareTo('[') == 0){ break; }
                    else{ return res; }
                default: break;
            }

        }
        if(stack.isEmpty()) res = true;
        return res;
    }
}
