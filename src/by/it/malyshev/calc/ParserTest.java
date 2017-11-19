package by.it.malyshev.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void testDaddD() throws Exception {
        Parser p = new Parser("4+4");
        String res = p.calc("4+4").toString();
        assertEquals("8.0", res);
    }

    @Test
    public void testDsubD() throws Exception {
        Parser p = new Parser("3--4");
        String res = p.calc("3--4").toString();
        assertEquals("7.0", res);
    }

    @Test
    public void testDmulD() throws Exception {
        Parser p = new Parser("-3*4");
        String res = p.calc("-3*4").toString();
        assertEquals("-12.0", res);
    }

    @Test
    public void testDdivD() throws Exception {
        Parser p = new Parser("-12/4");
        String res = p.calc("-12/4").toString();
        assertEquals("-3.0", res);
    }

    @Test
    public void testDaddV() throws Exception {
        Parser p = new Parser("2+{1,2,3}");
        String res = p.calc("2+{1,2,3}").toString();
        assertEquals("{3.0,4.0,5.0}", res);
    }

    @Test
    public void testDsubV() throws Exception {
        Parser p = new Parser("2-{1,2,3}");
        String res = p.calc("2-{1,2,3}").toString();
        assertEquals("{1.0,0.0,-1.0}", res);
    }

    @Test
    public void testDmulV() throws Exception {
        Parser p = new Parser("2*{1,2,3}");
        String res = p.calc("2*{1,2,3}").toString();
        assertEquals("{2.0,4.0,6.0}", res);
    }

    @Test
    public void testDaddM() throws Exception {
        Parser p = new Parser("2+{{1,2,3},{1,2,3}}");
        String res = p.calc("2+{{1,2,3},{1,2,3}}").toString();
        assertEquals("{{3.0,4.0,5.0},{3.0,4.0,5.0}}", res);
    }

    @Test
    public void testDsubM() throws Exception {
        Parser p = new Parser("2-{{1,2,3},{1,2,3}}");
        String res = p.calc("2-{{1,2,3},{1,2,3}}").toString();
        assertEquals("{{1.0,0.0,-1.0},{1.0,0.0,-1.0}}", res);
    }

    @Test
    public void testDmulM() throws Exception {
        Parser p = new Parser("2*{{1,2,3},{1,2,3}}");
        String res = p.calc("2*{{1,2,3},{1,2,3}}").toString();
        assertEquals("{{2.0,4.0,6.0},{2.0,4.0,6.0}}", res);
    }

    @Test
    public void testVaddD() throws Exception {
        Parser p = new Parser("{1,2,3}+2");
        String res = p.calc("{1,2,3}+2").toString();
        assertEquals("{3.0,4.0,5.0}", res);
    }

    @Test
    public void testVsubD() throws Exception {
        Parser p = new Parser("{1,2,3}-2");
        String res = p.calc("{1,2,3}-2").toString();
        assertEquals("{-1.0,0.0,1.0}", res);
    }

    @Test
    public void testVmulD() throws Exception {
        Parser p = new Parser("{1,2,3}*2");
        String res = p.calc("{1,2,3}*2").toString();
        assertEquals("{2.0,4.0,6.0}", res);
    }

    @Test
    public void testVdivD() throws Exception {
        Parser p = new Parser("{1,2,3}/2");
        String res = p.calc("{1,2,3}/2").toString();
        assertEquals("{0.5,1.0,1.5}", res);
    }

    @Test
    public void testVaddV() throws Exception {
        Parser p = new Parser("{1,2,3}+{1,2,3}");
        String res = p.calc("{1,2,3}+{1,2,3}").toString();
        assertEquals("{2.0,4.0,6.0}", res);
    }

    @Test
    public void testVsubV() throws Exception {
        Parser p = new Parser("{1,2,3}-{1,2,3}");
        String res = p.calc("{1,2,3}-{1,2,3}").toString();
        assertEquals("{0.0,0.0,0.0}", res);
    }

    @Test
    public void testVmulV() throws Exception {
        Parser p = new Parser("{1,4,9}*{1,2,3}");
        String res = p.calc("{1,4,9}*{1,2,3}").toString();
        assertEquals("20.0", res);
    }

    @Test
    public void testVmulM() throws Exception {
        Parser p = new Parser("{1,2,3}*{{1,2},{1,2},{1,2}}");
        String res = p.calc("{1,2,3}*{{1,2},{1,2},{1,2}}").toString();
        assertEquals("{6.0,12.0}", res);
    }

    @Test
    public void testMaddD() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}+2");
        String res = p.calc("{{1,2,3},{1,2,3}}+2").toString();
        assertEquals("{{3.0,4.0,5.0},{3.0,4.0,5.0}}", res);
    }

    @Test
    public void testMsubD() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}-2");
        String res = p.calc("{{1,2,3},{1,2,3}}-2").toString();
        assertEquals("{{-1.0,0.0,1.0},{-1.0,0.0,1.0}}", res);
    }

    @Test
    public void testMmulD() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}*2");
        String res = p.calc("{{1,2,3},{1,2,3}}*2").toString();
        assertEquals("{{2.0,4.0,6.0},{2.0,4.0,6.0}}", res);
    }

    @Test
    public void testMdivD() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}/2");
        String res = p.calc("{{1,2,3},{1,2,3}}/2").toString();
        assertEquals("{{0.5,1.0,1.5},{0.5,1.0,1.5}}", res);
    }

    @Test
    public void testMmulV() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}*{1,2,3}");
        String res = p.calc("{{1,2,3},{1,2,3}}*{1,2,3}").toString();
        assertEquals("{14.0,14.0}", res);
    }

    @Test
    public void testMaddM() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}+{{1,2,3},{1,2,3},{1,2,3}}");
        String res = p.calc("{{1,2,3},{1,2,3}}+{{1,2,3},{1,2,3},{1,2,3}}").toString();
        assertEquals("{{2.0,4.0,6.0},{2.0,4.0,6.0}}", res);
    }

    @Test
    public void testMsubM() throws Exception {
        Parser p = new Parser("{{2,3,4},{2,3,4}}-{{1,2,3},{1,2,3},{1,2,3}}");
        String res = p.calc("{{2,3,4},{2,3,4}}-{{1,2,3},{1,2,3},{1,2,3}}").toString();
        assertEquals("{{1.0,1.0,1.0},{1.0,1.0,1.0}}", res);
    }

    @Test
    public void testMmulM() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3}}*{{1,2,3},{1,2,3},{1,2,3}}");
        String res = p.calc("{{1,2,3},{1,2,3}}*{{1,2,3},{1,2,3},{1,2,3}}").toString();
        assertEquals("{{6.0,12.0,18.0},{6.0,12.0,18.0}}", res);
    }


    @Test
    public void testStringToVarDtoString() throws Exception {
        Parser p = new Parser("-1.2");
        String res = p.getVarTest("-1.2").toString();
        assertEquals("-1.2", res);
    }

    @Test
    public void testStringToVarVtoString() throws Exception {
        Parser p = new Parser("{1,2,3,1,2,3,1,2,3}");
        String res = p.getVarTest("{1,2,3,1,2,3,1,2,3}").toString();
        assertEquals("{1.0,2.0,3.0,1.0,2.0,3.0,1.0,2.0,3.0}", res);
    }

    @Test
    public void testStringToVarMtoString() throws Exception {
        Parser p = new Parser("{{1,2,3},{1,2,3},{1,2,3}}");
        String res = p.getVarTest("{{1,2,3},{1,2,3},{1,2,3}}").toString();
        assertEquals("{{1.0,2.0,3.0},{1.0,2.0,3.0},{1.0,2.0,3.0}}", res);
    }


}
