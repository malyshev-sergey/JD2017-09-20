package by.it.meshchenko.project.java.controller;

import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdHome extends AbstractAction {

    private String _jsp = Pages.home;

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
