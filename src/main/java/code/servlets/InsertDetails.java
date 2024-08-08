package code.servlets;

import code.DbUtil;
import code.model.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertDetails")
public class InsertDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String authorFullName = request.getParameter("author");
        Author author = new Author(authorFullName);
        //change max authorId
        int authorId = -1;
        if (!(isDataExistsInDb("author", "author_name='" + author.getName() +
                "' AND author_surname='" + author.getSurname() + "'"))) {
            addDataToDb("INSERT INTO authors VALUES (" + authorId + ",'" + author.getName() +
                    "', '" + author.getSurname() + "')");
        }
        String genre = request.getParameter("genre");
        //change max genreId
        int genreId = -1;
        if (!(isDataExistsInDb("genre", "genre_name='" + genre))) {
            addDataToDb("INSERT INTO genres VALUES (" + genreId + ", " + genre + ")");
        }

        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            PreparedStatement statement = conn.prepareStatement("insert into books values(?, ?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, year);
            statement.setString(4, authorFullName);
            statement.setString(5, genre);
            statement.executeUpdate();
            statement.close();
            conn.close();

            response.sendRedirect("success.jsp?msg=Insert");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isDataExistsInDb(String dataName, String expression) {
        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT EXISTS(SELECT * FROM ").append(dataName).append("s WHERE ")
                    .append(expression).append(")");
            PreparedStatement st = conn.prepareStatement(sb.toString());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void addDataToDb(String msg) {
        try {
            Class.forName(DbUtil.driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
            System.out.println("connection successful");

            PreparedStatement st = conn.prepareStatement(msg);
            ResultSet rs = st.executeQuery();
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

