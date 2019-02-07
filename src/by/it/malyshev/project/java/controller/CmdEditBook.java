package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Authors;
import by.it.malyshev.project.java.beans.AuthorsBooks;
import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.beans.Store;
import by.it.malyshev.project.java.beans.pojo.BookDTO;
import by.it.malyshev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

class CmdEditBook extends AbstractAction {

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {
//            req.getSession().invalidate();
//            return Actions.LOGIN.command;
//        }

//        Users user=Utils.getUserFromSession(req);
//        if (user==null) return Actions.LOGIN.command;

            HttpSession session = req.getSession(false);


            try {
                DAO dao = DAO.getInstance();
//                BO bo = BO.getInstance();


                if (req.getParameter("reportName") != null) {

//                Authors auth;
//                List<Authors> auths = dao.author.getAll(
//                        String.format("WHERE authorname='%s'",
//                                FormValidator.getString(req, "reportName", Patterns.ANY)));
//                if (auths.size() == 1) {
//                    auth = auths.get(0);
//                    session.setAttribute("author", auth);
//                    session.removeAttribute("bookId");
//                    return Actions.EDITBOOK.command;
//                }

                    session.setAttribute("authorId", req.getParameter("reportName"));
                    session.removeAttribute("bookId");
                    return Actions.EDITBOOK.command;

                }
                if (req.getParameter("reportBook") != null) {
//                Books book;
//                List<Books> books = dao.book.getAll(
//                        String.format("WHERE title='%s'",
//                                FormValidator.getString(req, "reportBook", Patterns.ANY)));
//                if (books.size() == 1) {
//                    book = books.get(0);
//                    session.setAttribute("bookId", Integer.toString(book.getId()));
//                    session.removeAttribute("author");
//                    return Actions.EDITBOOK.command;
//                }
                    session.setAttribute("bookId", req.getParameter("reportBook"));
                    session.removeAttribute("authorId");
                    return Actions.EDITBOOK.command;
                }

// AUTHOR ***********************************************************************


                if (Utils.getStringFromSession(req, "authorId") != null) {

                    int authorId = FormValidator.getInt(req, "authorId");

// Author read ****************************

                    Authors author = dao.author.read(authorId);
                    req.setAttribute("author", author);

// Author update ****************************

                    if (req.getParameter("authorEdit") != null) {

                        author.setAuthorname(FormValidator.getString(req, "editAuthorName", Patterns.ANY));
                        dao.author.update(author);
                        return Actions.EDITBOOK.command;
                    }

// Author delete ****************************

                    if (req.getParameter("authorDelete") != null) {


                        dao.author.delete(author);
                        session.removeAttribute("authorId");
                        return Actions.EDITBOOK.command;
                    }

                }


// BOOK ***********************************************************************

                if (Utils.getStringFromSession(req, "bookId") != null) {

                    int bookId = FormValidator.getInt(req, "bookId");

// Book read ****************************

                    List<BookDTO> bookDTOs = dao.fullBook.getAll("WHERE ID=" + bookId);

                    if (bookDTOs.size() == 1) {
                        req.setAttribute("fullBook", bookDTOs.get(0));
                    }

// Book update ****************************

                    if (req.getParameter("updateBook") != null) {

                        Books tmpBook = dao.book.read(bookId);

                        if (!req.getParameter("editBookTitle").isBlank()) {
                            tmpBook.setTitle(FormValidator.getString(req, "editBookTitle", Patterns.ANY));
                        }
                        if (!req.getParameter("editBookPubYear").isBlank()) {
                            tmpBook.setPubyear(FormValidator.getInt(req, "editBookPubYear"));
                        }
                        if (!req.getParameter("editBookIsbn").isBlank()) {
                            tmpBook.setIsbn(FormValidator.getString(req, "editBookIsbn", Patterns.ANY));
                        }
                        if (!req.getParameter("editBookPrice").isBlank()) {
                            tmpBook.setPrice(FormValidator.getBigDecimal(req, "editBookPrice"));
                        }

                        dao.book.update(tmpBook);

                        Store tmpStore;
                        List<Store> sts = dao.store.getAll("WHERE books_ID=" + bookId);
                        if (sts.size() == 1) {
                            tmpStore = sts.get(0);

                            if (!req.getParameter("editBookQuantity").isBlank()) {
                                tmpStore.setQuantity(FormValidator.getInt(req, "editBookQuantity"));
                            }
                            dao.store.update(tmpStore);
                            return Actions.EDITBOOK.command;
                        }

                    }


// Book delete ****************************
                    if (req.getParameter("deleteBook") != null) {
                        Books tmpBook = dao.book.read(bookId);

                        dao.book.delete(tmpBook);
                        session.removeAttribute("bookId");

                        return Actions.EDITBOOK.command;
                    }


// AuthorBook read ****************************
                    req.setAttribute("fullAuthorBooks", dao.fullAuthorBook.getAll(
                            String.format("WHERE books_ID=%d ORDER BY position",
                                    bookId)));

// AuthorBook create ****************************
                    if (req.getParameter("reportAuBo") != null) {

                        int auBoId = FormValidator.getInt(req, "reportAuBo");

//                    Authors auth;
//                    List<Authors> auths = dao.author.getAll("WHERE ID=" + auBoId);
//                    if (auths.size() == 1) {
//                        auth = auths.get(0);
                        AuthorsBooks tempAuthorBook = new AuthorsBooks();
                        tempAuthorBook.setAuthors_Id(auBoId);
                        tempAuthorBook.setBooks_Id(bookId);
                        List<AuthorsBooks> tAuBo = dao.authorBook.getAll(
                                "WHERE books_ID=" + bookId);
                        if (tAuBo.size() > 0) {
                            tempAuthorBook.setPosition(tAuBo.size());
                        } else tempAuthorBook.setPosition(0);
                        dao.authorBook.create(tempAuthorBook);
                        return Actions.EDITBOOK.command;
//                    }

                    }

// AuthorBook update ****************************
                    if (req.getParameter("authorBookUpdate") != null) {

                        AuthorsBooks tmpAuthorBook = new AuthorsBooks();
                        AuthorsBooks tmpAuthorBookNext = new AuthorsBooks();
                        int currentAuthorBookId = FormValidator.getInt(req, "authorBookId");

                        List<AuthorsBooks> tmpAuthorBooksAll = dao.authorBook.getAll(
                                "WHERE books_ID=" + bookId + " ORDER BY position");
                        int currentAuthorBookPosition = -999;
                        for (AuthorsBooks tAb : tmpAuthorBooksAll) {
                            if (tAb.getId() == currentAuthorBookId) {
                                tmpAuthorBook = tAb;
                                currentAuthorBookPosition = tAb.getPosition();
                            }

                        }
                        for (AuthorsBooks tAb : tmpAuthorBooksAll) {

                            if (currentAuthorBookPosition >= 0) {

                                if (tAb.getPosition() == currentAuthorBookPosition + 1) {
                                    tmpAuthorBookNext = tAb;
                                    break;
                                }
                            }
                        }
                        tmpAuthorBook.setPosition(tmpAuthorBook.getPosition() + 1);
                        tmpAuthorBookNext.setPosition(tmpAuthorBookNext.getPosition() - 1);
                        dao.authorBook.update(tmpAuthorBook);
                        dao.authorBook.update(tmpAuthorBookNext);
                        return Actions.EDITBOOK.command;
                    }


// AuthorBook delete ****************************
                    if (req.getParameter("authorBookDelete") != null) {
                        AuthorsBooks tmpAuthorBook = new AuthorsBooks();
                        int currentAuthorBookId = FormValidator.getInt(req, "authorBookId");

                        List<AuthorsBooks> tmpAuthorBooks = dao.authorBook.getAll(
                                "WHERE ID=" + currentAuthorBookId);
                        if (tmpAuthorBooks.size() == 1) {
                            tmpAuthorBook = tmpAuthorBooks.get(0);
                        }

                        int position = tmpAuthorBook.getPosition();

                        List<AuthorsBooks> tmpAuthorBooksAll = dao.authorBook.getAll(
                                "WHERE books_ID=" + bookId + " ORDER BY position");
                        if (tmpAuthorBooksAll.size() > position + 1) {
                            for (int i = position + 1; i < tmpAuthorBooksAll.size(); i++) {
                                tmpAuthorBooksAll.get(i).setPosition(i - 1);
                                dao.authorBook.update(tmpAuthorBooksAll.get(i));
                            }
                        }

                        dao.authorBook.delete(tmpAuthorBook);
                        return Actions.EDITBOOK.command;
                    }

                }




            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }


        return null;
    }

}
