package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdIndex extends AbstractAction {
    @Override
    public ICommand execute(HttpServletRequest req) {
        try {
            req.setAttribute(
                    "ads",
                    DAO.getInstance().ad.getAll("")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
