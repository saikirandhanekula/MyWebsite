<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Success</title>
</head>
<body>
<h3>Hello,<%out.println(request.getAttribute("Name").toString()); %></h3>
<h3><%out.println(request.getAttribute("Rewards").toString()); %></h3>
<form:form name = "balancepage" action="http://localhost:8080/springmvc.jdbc.website/balancepage" method = "post" >
Click balance to see your balance<a href = "javascript:document.balancepage.submit()" >Balance</a>
</form:form>
</body>
</html>