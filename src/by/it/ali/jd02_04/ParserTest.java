package by.it.ali.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String expression="2+9";
        String res=parser.pars(expression).toString();
        //String control="8.0";
        //assertTrue(res.equals(control));
        assertEquals("8",res);
    }
}