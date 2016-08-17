<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
         <c:if test = "${empty sessionScope.user }">
        	<c:redirect url = "Login"></c:redirect>
        </c:if>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />

<title>Edit Item</title>
</head>
<body>

	<table border = '2' >
	<h2>Edit Item</h2>
	<form action = 'EditItem' method = 'post'>
	
		<tr><td>Id </td><td> <input type= 'text' name = 'id' value = "${entry.id}" readonly/> </td></tr>
		<tr><td>Type </td>	

		<td><select name='type'>
		
		<%--  <option value='${entry.type}' selected = 'selected' >${entry.type}</option>
		  
		--%>
			 
		<c:forEach items = "${e}" var = "e">
		<option value='${e.type}' >${e.type}</option>	
		</c:forEach>	
		<option selected='selected'>${entry.type}</option>
 		</select></td>
		</tr>
		
<%-- 		<c:choose>
		
		<c:when test = "${entry.type = ${e.type}" >
		<td><select name='type'>
		<option selected='true'>${entry.type}</option>
		<option>${e.type}</option></select></td>
		</c:when>	
		</c:choose>
		
		</tr>
		<c:choose>
		
		<c:when test = "${entry.type == 'Tablet'}" >
		<td><select name='type'>
		<option selected='true'>Tablet</option>
		<option>Book</option></select></td>
		</c:when>	
		
		<c:otherwise>	
		<td><select name='type'>
		<option >Tablet</option>
		<option  selected='true'>Book</option></select></td></tr>
		</c:otherwise>	
		</c:choose>
	
	 --%>
		<tr><td>Name </td><td><input type= 'text' name = 'name' value = "${entry.name}"/></td></tr>
		<tr><td>Additional Info </td><td><input type= 'text' name = 'info' value = " ${entry.info}"/> </td></tr>
		<input type ='hidden' name = 'id' value = "${entry.id}"/>
		<input type ='hidden' name = 'index' value ="${entry.id-1}"/>
		<tr><td><input type = 'submit' name = 'save' value = 'Save'/></td><tr>
		
		</table></form>

</body>
</html>