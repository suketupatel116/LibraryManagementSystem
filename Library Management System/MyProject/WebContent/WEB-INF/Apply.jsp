<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
      
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
      

<table border = '2' >
	<h2>Application</h2>
	
		<form action = 'Apply' method = 'post'>
		
		<tr><td>Name </td><td> <Input type= 'text' name = 'name'/></td></tr>
		<tr><td>Position(s)</td><td> 
		
	 	<c:forEach items = "${subentries}" var = "entry">
	
		<input type="checkbox" name="position" value="${entry.position}">${entry.position}<br />
		</c:forEach> 
		
		
		<tr><td><input type = 'submit' name = 'add' value = 'Add'/></tr></td>
	
		
	</form>
		</table>
</body>
</html>