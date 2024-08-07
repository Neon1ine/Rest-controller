package code.servlets;

import code.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectDetails")
public class SelectDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {

            int id = 0;
            String name = "", genre = "", year = "", author = "";

            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("select * from books where book_id=?");

            st.setInt(1, Integer.parseInt(request.getParameter("id")));

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                id = rs.getInt(1);
                name = rs.getString(2);
                genre = rs.getString(3);
                year = rs.getString(4);
                author = rs.getString(5);

            }

            rs.close();
            st.close();
            conn.close();

            response.sendRedirect("result.jsp?id=" + id + "&name=" + name +
                    "&genre=" + genre + "&year=" + year + "&author=" + author);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

