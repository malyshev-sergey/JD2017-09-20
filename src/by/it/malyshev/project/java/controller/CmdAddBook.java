package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Authors;
import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.beans.Store;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

class CmdAddBook extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {

        if (FormValidator.isPost(req)) {

            if (req.getParameter("createNewAuthor") != null) {
                Authors tmpAuthor = new Authors();

                try {
                    tmpAuthor.setAuthorname(FormValidator.getString(req, "newAuthorName", Patterns.ANY));
                    DAO dao = DAO.getInstance();
                    if (dao.author.getAll("WHERE authorname='" + tmpAuthor.getAuthorname() + "'").size() > 0) {
                        req.setAttribute(Messages.ERROR, "Такой автор уже есть");
                        return null;
                    }
                    int newAuthorId = dao.author.create(tmpAuthor);

//                    List<Authors> authors = dao.author.getAll("WHERE authorname='" + tmpAuthor.getAuthorname() + "'");
                    if (newAuthorId > 0) {

                        HttpSession session = req.getSession(false);
                        session.setAttribute("authorId", Integer.toString(newAuthorId));
//                        req.setAttribute(Messages.MESSAGE, "finish");
                        return Actions.EDITBOOK.command;
                    }

                } catch (Exception e) {
                    req.getServletContext().log(e.getMessage());
                    System.out.println(e.getMessage());
                    req.setAttribute(Messages.ERROR, e.getMessage());
                }

            }

            if (req.getParameter("createNewBook") != null) {
                Books book = new Books();
                Store store = new Store();

                try {

                    if(!req.getParameter("newBookTitle").isBlank()) {
                        book.setTitle(FormValidator.getString(req, "newBookTitle", Patterns.ANY));
                    } else return null;
                    if(!req.getParameter("newBookPubYear").isBlank()) {
                        book.setPubyear(FormValidator.getInt(req, "newBookPubYear"));
                    } else book.setPubyear(0);
                    if(!req.getParameter("newBookIsbn").isBlank()) {
                        book.setIsbn(FormValidator.getString(req, "newBookIsbn", Patterns.ANY));
                    } else book.setIsbn("");
                    if(!req.getParameter("newBookPrice").isBlank()) {
                        book.setPrice(FormValidator.getBigDecimal(req, "newBookPrice"));
                    } else book.setPrice(BigDecimal.valueOf(0.00));


                    DAO dao = DAO.getInstance();

                    int newBookId=dao.book.create(book);

                    if (newBookId > 0) {

                        store.setBooks_Id(newBookId);
                        store.setQuantity(0);

                        dao.store.create(store);

                        HttpSession session = req.getSession(false);
                        session.setAttribute("bookId", Integer.toString(newBookId));
//                        req.setAttribute(Messages.MESSAGE, "finish");
                        return Actions.EDITBOOK.command;
                    }

                } catch (Exception e) {
//                    req.getServletContext().log(e.getMessage());
//                    System.out.println(e.getMessage());
//                    req.setAttribute(Messages.ERROR, e.getMessage());
                }



            }


        }


//            Users user=new Users();
//            try {
//
//                user.setLogin(FormValidator.getString(req, "login", Patterns.LOGIN));
//                user.setPassword(FormValidator.getString(req, "password", Patterns.PASSWORD));
//                DAO dao= DAO.getInstance();
//                List<Users> users=dao.user.getAll(
//                        String.format(" WHERE login='%s' AND password='%s'",
//                                user.getLogin(),
//                                user.getPassword())
//                );
//                if (users.size()==1){
//                    user=users.get(0);
//                    HttpSession session=req.getSession();
//                    session.setAttribute("user",user);
//                    return Actions.PROFILE.command;
//                } else {
//                    req.setAttribute(Messages.ERROR,"User: "+user.getLogin()+" not found");
//                }
//
//
//                /* TODO session */
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        return null;
    }

}
