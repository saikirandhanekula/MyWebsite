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
<form name = "profile" action="http://localhost:8080/springmvc.jdbc.website/profile" method = "post" >
<a href = "javascript:document.profile.submit()" target = "profile_page" >Profile</a><br><br>
</form>
<form name = "balancepage" action="http://localhost:8080/springmvc.jdbc.website/balancepage" method = "post" >
<a href = "javascript:document.balancepage.submit()" target = "balance_page" >Balance</a><br><br>
</form>
<form name = "rewardspage" action="http://localhost:8080/springmvc.jdbc.website/rewardspage" method = "post" >
<a href = "javascript:document.rewardspage.submit()" target = "rewards_page" >Rewards</a><br><br>
</form>
</body>
</html>