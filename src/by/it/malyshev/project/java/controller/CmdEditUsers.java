package by.it.malyshev.project.java.controller;


import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CmdEditUsers extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DAO dao=DAO.getInstance();
            if (FormValidator.isPost(req)) {
                Users user = new Users();
                try {
                    user.setId(FormValidator.getInt(req, "id"));
                    user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                    user.setEmail(FormValidator.getString(req, "email", Patterns.EMAIL));
                    user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                    user.setRoles_Id(FormValidator.getInt(req, "roles_Id"));
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
