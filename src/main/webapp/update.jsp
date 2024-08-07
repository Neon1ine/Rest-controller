<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body>

    <h2>Fill in your details</h2>

    <form action="./updateDetails" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id"
                    value="<%=request.getParameter("id")%>" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Genre Id:</td>
                <td><input type="text" name="genre" /></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><input type="text" name="year" /></td>
            </tr>
            <tr>
                <td>Author Id:</td>
                <td><input type="text" name="author" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" value="Update data" />
    </form>
    <br />
    <input type="button" value="Return to home page"
        onclick="window.location.href='home.jsp'" />

</body>
</html>
