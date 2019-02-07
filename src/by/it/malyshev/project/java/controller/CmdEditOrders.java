package by.it.malyshev.project.java.controller;


import by.it.malyshev.project.java.beans.Orders;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

class CmdEditOrders extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DAO dao=DAO.getInstance();
            if (FormValidator.isPost(req)) {
                Orders order = dao.order.read(FormValidator.getInt(req,"id"));
                try {
                    order.setId(FormValidator.getInt(req, "id"));
                    order.setQuantity(FormValidator.getInt(req, "quantity"));
                    if (req.getParameter("update") != null)
                        dao.order.update(order);
                    if (req.getParameter("delete") != null)
                        dao.order.delete(order);
                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("users", DAO.getInstance().user.getAll());
            req.setAttribute("books", DAO.getInstance().book.getAll());
            req.setAttribute("orders", DAO.getInstance().order.getAll());
        } catch (SQLException | ParseException e) {
            req.setAttribute(Messages.ERROR, e.toString());
        }

        return null;
    }

}
