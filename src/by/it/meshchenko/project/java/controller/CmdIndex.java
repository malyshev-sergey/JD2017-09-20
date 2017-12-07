package by.it.meshchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdIndex extends AbstractAction {

    private String _jsp = "";

    @Override
    public String jsp(){
        return _jsp;
    }

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {

//        if (MyRequest.isPost(req)){
//
//        }
//        if (MyRequest.isGet(req)){
//
//        }
        return null;
    }
}
