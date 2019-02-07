package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FrontController",
        urlPatterns = {
                "/do",""
        })
public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            getServletContext().setAttribute("roles", DAO.getInstance().role.getAll(""));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getParameter("term")!=null) {
//            resp.setContentType("application/json");
//            try {
//                String term = "%"+ req.getParameter("term")+"%";
//
//                DAO dao = DAO.getInstance();
//                List<Authors> authors=dao.author.getAll(
//                        String.format("WHERE authorname LIKE '%s'",term)
//                );
//
//                List<String> list=new ArrayList<>();
//                for (Authors author: authors) {
//                    list.add(author.getAuthorname());
//                }
//
//                String searchList = new Gson().toJson(list);
//                resp.getWriter().write(searchList);
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//
//        } else {
            resp.setHeader("Cache-Control", "no-store");
            processRequest(req, resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-store");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand cmd = new ActionFactory().getCommand(req);
        ICommand nextAction = cmd.execute(req, resp);
        if (nextAction == null) {
            RequestDispatcher disp = req.getRequestDispatcher(cmd.getJsp());
            disp.forward(req, resp);
        } else
            resp.sendRedirect("do?command="+nextAction);
    }

}



