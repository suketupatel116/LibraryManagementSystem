<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <c:if test = "${empty sessionScope.user }">
        	<c:redirect url = "Login"></c:redirect>
        </c:if>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />

<title>Add Type</title>
</head>
<body>
<table border = '2' >
	<h2>Add Type</h2>
		<form action = 'AddType' method = 'post'>
				
		<tr><td>Type </td><td> <Input type= 'text' name = 'type'/> <br/></td></tr>
		
		<tr><td><input type = 'submit' name = 'add' value = 'Add'/></tr></td>
		</table>
		
	</form>
	


</body>
</html>