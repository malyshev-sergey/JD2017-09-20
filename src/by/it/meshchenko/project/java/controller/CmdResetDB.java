package by.it.meshchenko.project.java.controller;


import by.it.meshchenko.project.java.beans.User;
import by.it.meshchenko.project.java.dao.DB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public class CmdResetDB extends AbstractAction {

    private String _jsp = "/resetdb.jsp";

    @Override
    public String jsp(){
        return _jsp;
    }

//    public static void main(String[] args) throws SQLException{
//        DB.reset();
//    }


    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
        if (MyRequest.isPost(req)){
            User user = Utils.getUserFromSession(req);
            try {
                DB.reset();
                req.setAttribute(Messages.MESSAGE, "db reset");
                if(user == null) {
                    return Actions.INDEX.command;
                }
                else {
                    return Actions.HOME.command;
                }


            } catch (Exception e) {
                req.getServletContext().log(e.getMessage());
                System.out.println(e.getMessage());
                req.setAttribute(Messages.ERROR, e.getMessage());
            }
        }
        if (MyRequest.isGet(req)){
            //_jsp = "/resetdb.jsp";
        }
        return null;
    }
}
