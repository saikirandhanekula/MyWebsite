<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<form name = "profile" action="http://localhost:8080/springmvc.jdbc.website/profile" method = "post" name="UserInfo">
<a href = "javascript:document.profile.submit()" >Profile</a>
</form>
<form name = "rewards" action="http://localhost:8080/springmvc.jdbc.website/profile" method = "post" name="UserInfo">
<a href = "javascript:document.profile.submit()" >Rewards</a>
</form>
<form name = "balance" action="http://localhost:8080/springmvc.jdbc.website/profile" method = "post" name="UserInfo">
<a href = "javascript:document.profile.submit()" >Balance</a>
</form>
</body>
</html>