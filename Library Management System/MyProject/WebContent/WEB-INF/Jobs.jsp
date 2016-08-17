<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="l" class = "deptlibrary.model.JobsEntry" scope = "application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Jobs</title>
</head>
<body>

	
	<a href = "Post">Post A Position </a> | <a href = "Apply"> Apply For Position(s)</a>

<table border = "2">

	<tr><th class = "sortable">Position</th>
	<th class = "sortable">Name</th>
	<th class = "sortable">Submitted On</th></tr>
	
<c:forEach items = "${entries}" var = "entry">
<tr>

	<td>${entry.position}</td>
	<td>${entry.name}</td>
	<td>${entry.date}</td>
</tr>
	
</c:forEach>	

</table>

</body>
</html> 