package code.servlets;

import code.DbUtil;
import code.model.Book;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectDetails")
public class SelectDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found " + e);
        }

        Book book = IndexServlet.findBookInDb(
                Integer.parseInt(request.getParameter("id")));
        try {
            response.sendRedirect("result.jsp?id=" + book.getId() + "&name=" + book.getName() +
                    "&year=" + book.getYear() + "&author=" +
                    book.getAuthor().toString() + "&genre=" + book.getGenre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

