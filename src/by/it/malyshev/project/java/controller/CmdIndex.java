package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

class CmdIndex extends AbstractAction {

//    public static void main(String[] args) {
//        try {
//            System.out.println(
//                    DAO.getInstance().book.getAll(""));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int start = 0;
            int indexStep = 10;
            if (req.getParameter("start") != null)
                try {
                    start = FormValidator.getInt(req, "start");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            DAO dao = DAO.getInstance();
//            BO bo=BO.getInstance();
            int indexCount = dao.book.getSize();
            req.setAttribute("indexCount", indexCount);
            req.setAttribute("indexStep", indexStep);
            req.setAttribute("indexCurrent", start);


            req.setAttribute("fullBooks", dao.fullBook.getAll(String.format(" LIMIT %s,10", start)));
//            req.setAttribute(
//                    "authorbooks",
//                    DAO.getInstance().authorBook.getAll(""));
//            req.setAttribute(
//                    "books",
//                    DAO.getInstance().book.getAll(""));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
