package by.it.akhmelev.project.java.controller;


import by.it.akhmelev.project.java.bean.Ad;
import by.it.akhmelev.project.java.bean.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdProfile extends AbstractAction{
    @Override
    public ICommand execute(HttpServletRequest req) {
        if (FormValidator.isPost(req)){
            req.getSession().invalidate();
            return Actions.LOGIN.command;
        }

        User user=Utils.getUserFromSession(req);
        if (user==null) return Actions.LOGIN.command;

        try {
            DAO dao=DAO.getInstance();
            List<Ad> ads=dao.ad.getAll(" where FK_Users="+user.getId());
            req.setAttribute("ads",ads);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
