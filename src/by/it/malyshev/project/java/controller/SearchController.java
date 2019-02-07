package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.beans.Authors;
import by.it.malyshev.project.java.beans.Books;
import by.it.malyshev.project.java.dao.DAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search")
public class SearchController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        try {
            String term = "%" + req.getParameter("term") + "%";
            String searchInstance = req.getParameter("searchInstance");
            String searchResult="";
            Map<Integer, String> map = new HashMap<>();

            DAO dao = DAO.getInstance();

            if (searchInstance.equals("author")) {

                List<Authors> authors = dao.author.getAll(
                        String.format("WHERE authorname LIKE '%s'", term)
                );

                for (Authors author : authors) {
                    map.put(author.getId(),author.getAuthorname());
                }

            } else if (searchInstance.equals("book")) {


                List<Books> books = dao.book.getAll(
                        String.format("WHERE title LIKE '%s'", term)
                );

                for (Books book : books) {
                    map.put(book.getId(),book.getTitle());
                }

            }

            searchResult = new Gson().toJson(map);
            resp.getWriter().write(searchResult);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
