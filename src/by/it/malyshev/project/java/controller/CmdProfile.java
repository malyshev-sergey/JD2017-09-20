package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.beans.Messages;
import by.it.malyshev.project.java.beans.Orders;
import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdProfile extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        if (FormValidator.isPost(req)){
            req.getSession().invalidate();
            return Actions.LOGIN.command;
        }

        Users user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;

        try {
            DAO dao=DAO.getInstance();
            List<Orders> ords=dao.order.getAll(" where users_ID="+user.getId());
            req.setAttribute("orders",ords);
            List<Books> books=dao.book.getAll();
            req.setAttribute("books",books);
            List<Messages> mess=dao.message.getAll(" where users_ID="+user.getId());
            req.setAttribute("messages",mess);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
