package by.it.meshchenko.project.java.controller;

import java.lang.reflect.Array;
import java.util.*;

public class Pages {

    public static final String css = "css";
    public static final String js = "js";
    public static final String index = "/index.jsp";
    public static final String home = "/a_home.jsp";
    public static final String cmdindex = "do?command=index";
    public static final String cmdsignin = "do?command=signin";
    public static final String cmdregister = "do?command=register";
    public static final String cmdhome = "do?command=home";
    public static final String cmdlogout = "do?command=logout";
    public static final String cmdleaseroom = "do?command=leaseroom";
    public static final String cmdmanagerpage = "do?command=managerpage";
    public static final String cmdadminpage = "do?command=adminpage";
    public static final String cmdresetdb = "do?command=resetdb";

    public final static List<String> RESURS = new ArrayList<String>(
            Arrays.asList(
                    css,
                    js
            )
    );

    public final static List<String> NOTAUTHENTICATION = new ArrayList<String>(
            Arrays.asList(
                    index,
                    cmdindex,
                    cmdsignin,
                    cmdregister,
                    cmdresetdb
            )
    );

    public final static List<String> AUTHENTICATION = new ArrayList<String>(
            Arrays.asList(
                    cmdhome,
                    cmdlogout,
                    cmdleaseroom,
                    cmdmanagerpage,
                    cmdadminpage,
                    cmdresetdb
            )
    );

    // Страницы, которые могут посещать пользователи с Role = 'user'
    public final static List<String> AUTHORIZATIONUser = new ArrayList<String>(
            Arrays.asList(
            )
    );
    // Страницы, которые могут посещать пользователи с Role = 'manager'
    public final static List<String> AUTHORIZATIONManager = new ArrayList<String>(
            Arrays.asList(
                    cmdmanagerpage
            )
    );
    // Страницы, которые могут посещать пользователи с Role = 'admin'
    public final static List<String> AUTHORIZATIONAdmin = new ArrayList<String>(
            Arrays.asList(
                    cmdadminpage
            )
    );
}
