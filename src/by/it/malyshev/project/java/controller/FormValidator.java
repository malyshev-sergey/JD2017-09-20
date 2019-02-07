package by.it.malyshev.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;

class FormValidator {

    static String getString(HttpServletRequest req, String name, String pattern) throws ParseException {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        throw new ParseException("incorrect value " + value, 0);
    }

    static int getInt(HttpServletRequest req, String name) throws ParseException{
        if(req.getParameter(name)==null) {
            return Integer.parseInt(Utils.getStringFromSession(req,name));
        } else {
            return Integer.parseInt(req.getParameter(name));
        }
    }

    static BigDecimal getBigDecimal(HttpServletRequest req, String name) throws ParseException{
        return BigDecimal.valueOf(Double.parseDouble(req.getParameter(name)));
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().toUpperCase().equals("POST");
    }


}
