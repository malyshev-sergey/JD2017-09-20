package by.it.shelkovich.calc.tests;

import by.it.shelkovich.calc.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class VarMTest {
    @Test
    public void add() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarD v2 = new VarD(4);
        Var v3 = v1.add(v2);
        assertEquals("{{7.0,6.0},{10.0,12.0}}", v3.toString());
    }

    @Test
    public void mul() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarD v2 = new VarD(4);
        Var v3 = v1.mul(v2);
        assertEquals("{{12.0,8.0},{24.0,32.0}}", v3.toString());
    }

    @Test
    public void sub() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarD v2 = new VarD(4);
        Var v3 = v1.sub(v2);
        assertEquals("{{-1.0,-2.0},{2.0,4.0}}", v3.toString());
    }

    @Test
    public void div() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarD v2 = new VarD(4);
        Var v3 = v1.div(v2);
        assertEquals("{{0.75,0.5},{1.5,2.0}}", v3.toString());
    }

    @Test
    public void mul1() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarV v2 = new VarV("{3,2}");
        Var v3 = v1.mul(v2);
        assertEquals("{13.0,34.0}", v3.toString());
    }

    @Test
    public void add1() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarM v2 = new VarM("{{1,2},{3,4}}");
        Var v3 = v1.add(v2);
        assertEquals("{{4.0,4.0},{9.0,12.0}}", v3.toString());
    }

    @Test
    public void mul2() throws Exception {
        VarM v1 = new VarM("{{3,2},{6,8}}");
        VarM v2 = new VarM("{{1,2},{3,4}}");
        Var v3 = v1.mul(v2);
        assertEquals("{{9.0,14.0},{30.0,44.0}}", v3.toString());
    }
    @org.junit.Test
    public void string2String() throws Exception {
        String value = "{{7.0,-1.8},{13.0,21.0}}";
        VarM v1 = new VarM(value);
        assertEquals(value, v1.toString());
    }

    @org.junit.Test
    public void parser() throws Exception {
        Parser parser = new Parser();
        String value = "{{7.0,-1.8},{13.0,21.0}}";
        assertEquals(value, parser.getVarByString(value).toString());
    }

}