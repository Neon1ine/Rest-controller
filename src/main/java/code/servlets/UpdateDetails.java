package code.servlets;

import code.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetails")
public class UpdateDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("update books set book_name=?, " +
                    "genre_id=?, book_year=?, author_id=? where book_id=?");

            st.setString(1, request.getParameter("name"));
            st.setString(2, request.getParameter("genre"));
            st.setString(3, request.getParameter("year"));
            st.setString(4, request.getParameter("author"));
            st.setInt(5, Integer.parseInt(request.getParameter("id")));
            st.executeUpdate();
            st.close();
            conn.close();

            response.sendRedirect("success.jsp?msg=Update");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
