package by.it.malyshev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {

    ICommand getCommand(HttpServletRequest req) {

        String strCommand = req.getParameter("command");

        if (strCommand==null) {
            strCommand="index";
        }

        try {
            return Actions.valueOf(strCommand.toUpperCase()).command;

        } catch (IllegalArgumentException e) {

            return Actions.ERROR.command;
        }
    }
}
