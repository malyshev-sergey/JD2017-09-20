package by.it.malyshev.project.java.controller;

import by.it.malyshev.project.java.connection.ConnectionCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet("/upload")
@MultipartConfig
public class UploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Part filePart = req.getPart("file");
        long fileSize = filePart.getSize();
        InputStream fileContent = filePart.getInputStream();

        int bookId;
        try {
                bookId=FormValidator.getInt(req,"bookId");

                Connection connection = ConnectionCreator.getConnection();
                PreparedStatement pStatement = connection.prepareStatement("UPDATE books SET imgfile = ? WHERE books.ID = ?");
                pStatement.setBlob(1,fileContent, fileSize);
                if(bookId!=0) pStatement.setInt(2,bookId);
                pStatement.executeUpdate();

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher("/editbook.jsp").forward(req,res);
        res.sendRedirect("do?command=editbook");

     }

 }
