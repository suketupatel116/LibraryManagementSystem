<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cs320" uri="http://cs.calstatela.edu/cs320stu55/examples" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>



<jsp:useBean id="l" class = "deptlibrary.model.LibraryItemEntry" scope = "application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="http://www.calstatela.edu/sites/default/files/favicon.ico" />
<title>Library Entry</title>
</head>
<body>

<p>Welcome! to the Library Management System</p>

<table border = "2">

	<tr><th>Id</th><th>Type</th><th>Name</th><th>Additional Info</th><th>Available</th><th>Operation</th></tr>
	
<c:forEach items = "${entries}" var = "entry">

<tr>
	<td>${entry.id}</td>
	<td>${entry.type}</td>
	<td>${entry.name}</td>
	<td>${entry.info}</td>
	<fmt:parseDate var = "duedate" value = "${entry.dbb}" pattern = "mm/dd/yyyy"/>
	<fmt:parseDate var = "currentdate" value = "${systemdate}" pattern = "mm/dd/yyyy"/>
	

	<c:choose>
	<c:when test = "${entry.available == 'Yes'}" >
			
			<cs320:coloredTd available="true" overdue="true" />
	</c:when>
	<c:when test = "${duedate ge currentdate || empty entry.dbb}" >
			
			<cs320:coloredTd available="false" overdue="false" />
	</c:when>
	<c:otherwise>
			
			<cs320:coloredTd available="false" overdue="true" />
	</c:otherwise>
	</c:choose> 
	<td><a href = "ViewItem?id=${entry.id}">View </a> | <a href = "EditItem?id=${entry.id}"> Edit</a></td>
</tr>	
</c:forEach>

</table>

<c:choose>
<c:when test= "${empty sessionScope.user}">
			
				<p><a href ='Login'>Login</a></p>
</c:when>

<c:otherwise>

			<p><a href ='AddType'>Add Type</a></p>
			<p><a href ='AddItem'>Add Items</a></p>
    		<p><a href ='Logout'>Logout</a></p>

</c:otherwise>	

</c:choose>
</body>
</html> 