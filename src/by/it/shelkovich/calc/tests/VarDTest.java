package by.it.shelkovich.calc.tests;

import by.it.shelkovich.calc.Parser;
import by.it.shelkovich.calc.Var;
import by.it.shelkovich.calc.VarD;
import by.it.shelkovich.calc.VarFactory;

import static org.junit.Assert.*;

public class VarDTest {
    @org.junit.Test
    public void add() throws Exception {
        VarD v1 = new VarD(1.5);
        VarD v2 = new VarD(2.1);
        Var v3 = v1.add(v2);
        assertEquals("3.6", v3.toString());
    }

    @org.junit.Test
    public void mul() throws Exception {
        VarD v1 = new VarD(1.5);
        VarD v2 = new VarD(2);
        Var v3 = v1.mul(v2);
        assertEquals("3.0", v3.toString());
    }

    @org.junit.Test
    public void sub() throws Exception {
        VarD v1 = new VarD(1.5);
        VarD v2 = new VarD(2);
        Var v3 = v1.sub(v2);
        assertEquals("-0.5", v3.toString());
    }

    @org.junit.Test
    public void div() throws Exception {
        VarD v1 = new VarD(3);
        VarD v2 = new VarD(2);
        Var v3 = v1.div(v2);
        assertEquals("1.5", v3.toString());
    }

    @org.junit.Test
    public void string2String() throws Exception {
        String value = "15.6";
        assertEquals(value, new VarD(value).toString());
    }

    @org.junit.Test
    public void parser() throws Exception {
        Parser parser = new Parser();
        String value = "15.6";
        assertEquals(value, VarFactory.getInstance().getVar(value).toString());
    }

}