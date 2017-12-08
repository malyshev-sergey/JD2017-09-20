package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.bean.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdEditUsers extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            DAO dao=DAO.getInstance();
            if (FormValidator.isPost(req)) {
                User user = new User();
                try {
                    user.setId(FormValidator.getInt(req, "id"));
                    user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                    user.setEmail(FormValidator.getString(req, "email", Patterns.EMAIL));
                    user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                    user.setFk_Roles(FormValidator.getInt(req, "fk_Roles"));
                    if (req.getParameter("Update") != null)
                        dao.user.update(user);
                    if (req.getParameter("Delete") != null)
                        dao.user.delete(user);
                } catch (Exception e) {
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }
            }
            req.setAttribute("users", DAO.getInstance().user.getAll());
        } catch (SQLException e) {
            req.setAttribute(Messages.ERROR, e.toString());
        }

        return null;
    }

}
