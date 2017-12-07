package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {

    public static User getUserFromSession(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session == null) return null;
        Object o = session.getAttribute("user");
        if (o == null) return null;
        return (User)o;
    }
}
