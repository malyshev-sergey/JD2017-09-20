package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Users;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {


        if (FormValidator.isPost(req)){
            Users user=new Users();
            try {
//                String login = FormValidator.getString(req, "login", Patterns.LOGIN);

                user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
//                user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
                DAO dao= DAO.getInstance();
                List<Users> users=dao.user.getAll(
                        String.format(" WHERE login='%s'",
                                user.getLogin()
//                                , user.getPassword()
                                )
                );
                if (users.size()==1){
                    user=users.get(0);

                    String passwordToHash=FormValidator.getString(req, "password", Patterns.PASSWORD);
                    byte[] salt = dao.user.getSalt(user.getId());
                    String securePassword = Utils.get_SHA_512_SecurePassword(passwordToHash, salt);
                    if (user.getPassword().equals(securePassword)) {
                        HttpSession session=req.getSession();
                        session.setMaxInactiveInterval(30*60);
                        session.setAttribute("user",user);

                        Cookie loginCookie = new Cookie("FrontController.login",user.getLogin());
                        loginCookie.setMaxAge(60*60);
                        Cookie passwordCookie = new Cookie("FrontController.password",user.getPassword());
                        passwordCookie.setMaxAge(60*60);
                        resp.addCookie(loginCookie);
                        resp.addCookie(passwordCookie);

                        return Actions.PROFILE.command;
                    } else {
                        req.setAttribute(Messages.ERROR, "The password for user: " + user.getLogin() + " is not valid");
                    }

                } else {
                    req.setAttribute(Messages.ERROR,"User: "+user.getLogin()+" is not found");
                }

//                req.setAttribute(Messages.MESSAGE,"test=" + test);

            /* TODO session */
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return null;
    }

}
