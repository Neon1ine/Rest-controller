<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book library</title>

</head>
<body>

<h2>List of all books</h2>

<c:forEach var="book" items="${requestScope.books}">
    <ul>
        ID: <c:out value="${book.id}"/> <br>
        Name: <c:out value="${book.name}"/> <br>
        Description: <c:out value="${book.description}"/> <br>
        Author: <c:out value="${book.author.name}"/> <c:out value="${book.author.surname}"/> <br>
        In use: <c:out value="${book.isInUse}"/> <br>
    </ul>
    <hr/>

</c:forEach>


</body>
</html>