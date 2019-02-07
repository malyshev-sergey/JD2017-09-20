package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Messages;
import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.beans.pojo.BookDTO;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

class CmdBook extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
//        if (FormValidator.isPost(req)){
//            req.getSession().invalidate();
//            return Actions.LOGIN.command;
//        }

        Users user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;



        try {
//            BO bo=BO.getInstance();
            DAO dao = DAO.getInstance();

            List<BookDTO> bookDTOs=dao.fullBook.getAll("WHERE ID=" +
                    FormValidator.getInt(req,"bookId"));


            if (bookDTOs.size() == 1) {
                req.setAttribute("fullBook", bookDTOs.get(0));
            }

            req.setAttribute("fullMessages",
                    dao.fullMessage.getAll("WHERE books_ID=" +
                            FormValidator.getInt(req,"bookId")));

            HttpSession session = req.getSession(false);
            session.setAttribute("bookId",
                    Integer.toString(FormValidator.getInt(req,"bookId")));

            if (req.getParameter("delete") != null) {
                Messages dmes = dao.message.read(
                        FormValidator.getInt(req,"deleteMessageId"));
                dao.message.delete(dmes);
                return Actions.BOOK.command;
            }

            if (req.getParameter("updateMessageId") != null) {
                Messages umes = dao.message.read(FormValidator.getInt(req,"updateMessageId"));
                umes.setMessage(req.getParameter("editMessage"));
                dao.message.update(umes);
                return Actions.BOOK.command;
            }

            if (req.getParameter("createMessage") != null) {
                Messages mes = new Messages();
                mes.setBooks_Id(FormValidator.getInt(req, "bookId"));
                mes.setMessage(req.getParameter("newMessage"));
                mes.setUsers_Id(user.getId());
                dao.message.create(mes);
                return Actions.BOOK.command;
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
