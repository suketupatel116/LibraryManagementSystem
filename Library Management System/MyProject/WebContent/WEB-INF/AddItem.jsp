<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        
        
        <c:if test = "${empty sessionScope.user }">
        	<c:redirect url = "Login"></c:redirect>
        </c:if>
                
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />
<title>Add Item</title>
</head>
<body>
      
      
<table border = '2' >
	<h2>Add Item</h2>
		<form action = 'AddItem' method = 'post'>
		

		<tr><td>Type </td><td><select  name='type'>
	 <c:forEach items = "${e}" var = "e">
		
			<option value='${e.type}' >${e.type}</option>
			</c:forEach>	
		</select></td></tr>
		

<!-- 		<option value='Tablet' selected='selected'>Tablet</option>

		<option value='Book' selected='selected'>Book</option></select></td></tr>
 -->	
		<tr><td>Name </td><td> <Input type= 'text' name = 'name'/> <br/></td></tr>
		<tr><td>Additional Info</td><td> <Input type= 'text' name = 'info'/> </td><tr>
		<tr><td> # of Copies </td><td> <Input type= 'text' name = 'number'/> <br/>

		<tr><td><input type = 'submit' name = 'add' value = 'Add'/></tr></td>
		
	</form>
		</table>
	
</body>
</html>