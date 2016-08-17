<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:useBean id="now" class="java.util.Date" />
    
     <c:if test = "${empty sessionScope.user }">
        	<c:redirect url = "Login"></c:redirect>
        </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />

<title>Checkout</title>
</head>
<body>
<h2>Checkout Item</h2>
<table border = '2' >


<tr><td>Id </td><td> <input type= 'text' name = 'id' value = "${entry.id}" readonly/></td></tr>
<tr><td> Name </td><td> "${entry.name}" </td></tr></table>

<%@ page import="java.util.*"%>
<form action = 'CheckOut' method = 'post'>
<table border = '2'><tr><td>Date Borrowed </td><td><fmt:formatDate pattern="MM/dd/yyyy" value="${now}" /></td></tr>
<tr><td>CIN </td><td><input type = 'text' name = 'cin'/><br/></td></tr>
<tr><td>Name </td><td><input type = 'text' name = 'sname'/><br/></td></tr>
<tr><td>Due Back By </td><td><input type = 'text' name = 'dbb'/><br/></td></tr></table>
<input type ='hidden' name = 'id' value = "${entry.id}" />
<input type ='hidden' name = 'number' value = "${entry.number}"/>
<tr><td><input type = 'submit' name = 'checkout' value = 'Checkout'/></td><tr>

<p><a href ='LibraryEntry'>Back to Items </a>
</p>
</form>
</body>
</html>