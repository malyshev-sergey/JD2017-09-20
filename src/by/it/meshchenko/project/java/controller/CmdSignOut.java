package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignOut extends AbstractAction {

    private String _jsp = Pages.home;

    @Override
    public String jsp(){
        return _jsp;
    }

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
