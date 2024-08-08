package code.servlets;

import code.DbUtil;
import code.model.Author;
import code.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("home.jsp");
    }

    protected static Book findBookInDb(int id) {
        ArrayList<String> arrayBook = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("select * from books where book_id=?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    arrayBook.add(rs.getString(i));
                }
            }
            rs.close();
            conn.close();
            int authorId = Integer.parseInt(arrayBook.get(arrayBook.size() - 2));
            int genreId = Integer.parseInt(arrayBook.get(arrayBook.size() - 1));
            arrayBook.remove(arrayBook.size() - 2);
            arrayBook.remove(arrayBook.size() - 1);
            arrayBook.add(findAuthorInDb(authorId).toString());
            arrayBook.add(findGenreInDb(genreId));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Book.convertArrayToBook(arrayBook);
    }

    private static Author findAuthorInDb(int id) {
        String authorFullName = "Null Author";
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("select * from authors where author_id=?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            StringBuilder sb = new StringBuilder();
            System.out.println("findAuthorInDb working");
            while (rs.next()) {
                for (int i = 2; i < 4; i++) {
                    sb.append(rs.getString(i));
                    sb.append(" ");
                }
            }
            authorFullName = sb.substring(0, sb.length() - 1);
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Author(authorFullName);
    }

    private static String findGenreInDb(int id) {
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("select * from genres where genre_id=?");
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(2);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "nullGenre";
    }
}
