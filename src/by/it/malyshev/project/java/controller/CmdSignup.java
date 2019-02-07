package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdSignup extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {

        if (FormValidator.isPost(req)) {
            Users user = new Users();
            try {
                user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
                user.setEmail(FormValidator.getString(req, "email", Patterns.EMAIL));
                String passwordToHash=FormValidator.getString(req, "password", Patterns.PASSWORD);
                byte[] salt = Utils.getSalt();
                String securePassword = Utils.get_SHA_512_SecurePassword(passwordToHash, salt);
                user.setPassword(securePassword);
                user.setRoles_Id(2);

                DAO dao = DAO.getInstance();
                if (dao.user.getAll("where login='"+user.getLogin()+"'").size()>0)
                {
                    req.setAttribute(Messages.ERROR, "Такой пользователь уже есть");
                    return null;
                }
                int userId=dao.user.create(user);
                dao.user.setSalt(userId,salt);

                req.setAttribute(Messages.MESSAGE, "finish");
                return Actions.LOGIN.command;

            } catch (Exception e) {
                req.getServletContext().log(e.getMessage());
                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }

        return null;
    }

}
