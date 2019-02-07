package by.it.malyshev.project.java.controller;


import by.it.malyshev.project.java.beans.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Utils {

    public static String URL_DB;
    public static String USER_DB;
    public static String PASSWORD_DB;

//    static String param="";

    static Users getUserFromSession(HttpServletRequest req){
        HttpSession session=req.getSession(false);
        if (session==null) return null;
        Object o=session.getAttribute("user");
        if (o==null) return null;
        return (Users)o;
    }

    static String getStringFromSession(HttpServletRequest req, String name){
        HttpSession session=req.getSession(false);
        if (session==null) return null;
        Object o=session.getAttribute(name);
        if (o==null) return null;
        return (String) o;
    }


    static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    static void setSalt (int userId, byte[] salt) {

    }




}
