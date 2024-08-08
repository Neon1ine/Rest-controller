<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details - Result</title>
</head>
<body>

    <h2>Details</h2>

    <form>
        <input type="hidden" name="stid"
            value="<%=request.getParameter("id")%>">

        <table>
            <tr>
                <td>ID:</td>
                <td><%=request.getParameter("id")%></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><%=request.getParameter("name")%></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><%=request.getParameter("year")%></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><%=request.getParameter("author")%></td>
            </tr>
            <tr>
                <td>Genre:</td>
                <td><%=request.getParameter("genre")%></td>
            </tr>
            <tr />
        </table>
        <br />
    </form>
    <br />
    <input type="button" value="Update data" onclick="update()" />
    <br />
    <input type="button" value="Return to home page"
        onclick="window.location.href='home.jsp'" />

</body>

<script language="javascript" type="text/javascript">
    function update() {
        var sid = document.forms[0].elements['stid'].value;
        window.location.href = "update.jsp?id=" + sid;
    }
</script>
</html>
