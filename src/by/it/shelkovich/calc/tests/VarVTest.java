package by.it.shelkovich.calc.tests;

import by.it.shelkovich.calc.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class VarVTest {
    @Test
    public void add() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarD v2 = new VarD(15);
        Var v3 = v1.add(v2);
        assertEquals("{18.0,17.0}", v3.toString());
    }

    @Test
    public void mul() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarD v2 = new VarD(15);
        Var v3 = v1.mul(v2);
        assertEquals("{45.0,30.0}", v3.toString());
    }

    @Test
    public void sub() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarD v2 = new VarD(15);
        Var v3 = v1.sub(v2);
        assertEquals("{-12.0,-13.0}", v3.toString());
    }

    @Test
    public void div() throws Exception {
        VarV v1 = new VarV("{4,2}");
        VarD v2 = new VarD(4);
        Var v3 = v1.div(v2);
        assertEquals("{1.0,0.5}", v3.toString());
    }

    @Test
    public void add1() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarV v2 = new VarV("{4, 1.2}");
        Var v3 = v1.add(v2);
        assertEquals("{7.0,3.2}", v3.toString());
    }

    @Test
    public void mul1() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarV v2 = new VarV("{4, 1.2}");
        Var v3 = v1.mul(v2);
        assertEquals("{12.0,2.4}", v3.toString());
    }

    @Test
    public void sub1() throws Exception {
        VarV v1 = new VarV("{3,2}");
        VarV v2 = new VarV("{4, 1.2}");
        Var v3 = v1.sub(v2);
        assertEquals("{-1.0,0.8}", v3.toString());
    }

    @org.junit.Test
    public void string2String() throws Exception {
        String value = "{7.0,-1.8}";
        assertEquals(value, new VarV(value).toString());
    }

    @org.junit.Test
    public void parser() throws Exception {
        Parser parser = new Parser();
        String value = "{7.0,-1.8}";
        assertEquals(value, VarFactory.getInstance().getVar(value).toString());
    }

}