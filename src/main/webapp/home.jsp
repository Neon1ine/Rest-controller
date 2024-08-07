<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Welcome Page</title> 
</head> 
<body> 
  
    <h2 align="center">Welcome to Book database management system</h2>
    <br /> 
    <table align="center"> 
  
        <tr> 
            <td>To insert your details into the Database:</td> 
            <td><input type="button" value="Insert data"
                onclick="window.location.href='insert.jsp'" /></td>
        </tr> 
        <tr> 
            <td>To delete your details from the Database:</td> 
            <td><input type="button" value="Delete data"
                onclick="window.location.href='delete.jsp'" /></td>
        </tr> 
        <tr> 
            <td>To view your details from the Database:</td> 
            <td><input type="button" value="Select data"
                onclick="window.location.href='select.jsp'" /></td>
        </tr> 
    </table> 
  
</body> 
  
  
</html>
