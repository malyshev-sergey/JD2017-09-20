package by.it.meshchenko.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Expression {
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
}
