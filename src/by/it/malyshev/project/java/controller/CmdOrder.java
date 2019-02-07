package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.beans.Orders;
import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

class CmdOrder extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
//        if (FormValidator.isPost(req)){
//            req.getSession().invalidate();
//            return Actions.LOGIN.command;
//        }

        Users user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;
        Orders ord=new Orders();
        try {
            DAO dao=DAO.getInstance();
            Books book=dao.book.read(FormValidator.getInt(req,"bookId"));
            // .getAll(" where FK_Users="+user.getId());
            req.setAttribute("book",book);
            if (req.getParameter("cancel") != null) {
//                req.setAttribute("id",FormValidator.getInt(req,"id"));
                return Actions.BOOK.command;
            }
            if (req.getParameter("ok") != null) {
                ord.setBooks_Id(FormValidator.getInt(req, "id"));
                ord.setQuantity(FormValidator.getInt(req, "quantity"));
                ord.setUsers_Id(user.getId());
                dao.order.create(ord);
                return Actions.PROFILE.command;
            }

            } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
