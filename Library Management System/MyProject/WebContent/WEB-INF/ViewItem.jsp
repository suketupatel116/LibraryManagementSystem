<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />

<title>View Item</title>
</head>
<body>

	<form action = "ViewItem" method = "post">

		<input type ='hidden' name = 'id' value = "${entry.id}"/>
		
		<table border = '2' >

		<tr><td>Id</td><td>${entry.id}</td></tr>
		<tr><td>Name</td><td>${entry.name}</td></tr>
		</table>
		
		<a href = 'LibraryEntry'> Back to List </a>
		
		<c:if test = "${entry.number != 0}">
		| <a href = 'CheckOut?id=${entry.id}'> Checkout Item</a>
		</c:if>
	
		<table border = '2' >
		<tr><th>CIN</th><th>Name</th><th>Borrowed Date</th><th>Due Back By</th><th>Returned Date</th></tr>
		
		<c:forEach items = "${subentries}" var = "e1">
		<c:choose>
			<c:when test = "${e1.id == entry.id}">
				<tr><td> ${e1.cin} </td><td> ${e1.sname} </td><td> ${e1.bdate} </td><td>${e1.dbb}</td>
				
				<c:if test = "${e1.rdate == null}">
				<td><a href='Return?index=${e1.sid}&lid=${entry.id}'>RETURN</a></td>
			</c:if>
			<c:if test = "${not empty e1.rdate}">		
				<td> ${e1.rdate}</td></tr>
			</c:if>
			</c:when>
				</c:choose>
				</c:forEach>
			</table>
	</form>	
</body>
</html>

