<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance</title>
</head>
<body>
<h2>Hello, <%out.println(request.getAttribute("Username").toString()); %></h2>
<h2>Your Current Balance = <% out.println(request.getAttribute("Balance").toString()); %></h2>
<form name = "makepayment" action = "http://localhost:8080/springmvc.jdbc.website/makepayment">
<a href = "javascript:document.makepayment.submit()" target = "makepayment_page" >Make a Payment</a><br><br>
</form>
<form name = "paybills" action = "http://localhost:8080/springmvc.jdbc.website/paybills">
<a href = "javascript:document.paybills.submit()" target = "paybills_page" >Pay Bills</a><br><br>
</form>
</body>
</html>