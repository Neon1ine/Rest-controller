package code.servlets;

import code.data.Book;
import code.data.Author;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/all_books")
public class AllBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        Book testBook1 = new Book(0, "Anna Karenina", "novel", 1887,
                new Author("Leo", "Tolstoy"), false);

        printWriter.write(testBook1.toString());

        printWriter.close();
    }
}