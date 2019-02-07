package by.it.malyshev.project.java.controller;


import by.it.malyshev.project.java.beans.Messages;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

class CmdEditMessages extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DAO dao=DAO.getInstance();
            if (FormValidator.isPost(req)) {
                Messages mes = dao.message.read(FormValidator.getInt(req,"id"));
                try {
                    mes.setId(FormValidator.getInt(req, "id"));
                    mes.setMessage(FormValidator.getString(req, "message",Patterns.ANY));
                    if (req.getParameter("update") != null)
                        dao.message.update(mes);
                    if (req.getParameter("delete") != null)
                        dao.message.delete(mes);
                } catch (Exception e) {
                    req.setAttribute(by.it.malyshev.project.java.controller.Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("users", DAO.getInstance().user.getAll());
            req.setAttribute("books", DAO.getInstance().book.getAll());
            req.setAttribute("messages", DAO.getInstance().message.getAll());
        } catch (SQLException | ParseException e) {
            req.setAttribute(by.it.malyshev.project.java.controller.Messages.ERROR, e.toString());
        }

        return null;
    }

}
