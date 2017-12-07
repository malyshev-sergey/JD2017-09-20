package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class MyRequest {

    static String getParam(HttpServletRequest req, String name, String pattern) throws ParseException {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        throw new ParseException("incorrect value " + value, 0);
    }

    static boolean isPost(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("POST");
    }

    static boolean isGet(HttpServletRequest req) {
        return req
                .getMethod()
                .toUpperCase()
                .equals("GET");
    }
}
