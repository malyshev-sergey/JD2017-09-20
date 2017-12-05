package by.it.likhanau.project.java.controller;



import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    ICommand getCommand(HttpServletRequest req){
        String strCommand = req.getParameter("command").toUpperCase();
        Actions tmp = Actions.valueOf(strCommand);
        return tmp.command;
    }

}
