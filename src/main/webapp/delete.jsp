<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Details</title>
</head>
<body>

    <form action="./deleteDetails" method="post">
        <table>
            <tr>
                <td>Enter ID:</td>
                <td><input type="text" name="id" /></td>
            </tr>

        </table>
        <br /> <input type="submit" value="delete data" />
    </form>
    <br />

    <input type="button" value="Return to home page"
        onclick="window.location.href='home.jsp'" />

</body>

</html>
