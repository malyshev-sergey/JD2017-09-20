package by.it.meshchenko.calc;

import java.util.ArrayList;
import java.util.HashMap;

public class Expression {
    public HashMap<String, Var> tempEx;
    public ArrayList<String> tempOp;

    public Expression() {
        this.tempEx = new HashMap<String, Var>();
        this.tempOp = new ArrayList<String>();
    }
    public Expression(HashMap<String, Var> tempEx, ArrayList<String> tempOp) {
        this.tempEx = tempEx;
        this.tempOp = tempOp;
    }
}
