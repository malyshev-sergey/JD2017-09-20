package by.it.malyshev.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface ICommand {
//    ICommand execute(HttpServletRequest req);
    ICommand execute(HttpServletRequest req, HttpServletResponse resp);
    String getJsp();


}
