<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rewards</title>
<style type="text/css">
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<hr>
<body>
<div class = "topnav">
<form name = "profile" action="http://localhost:8080/springmvc.jdbc.website/profile" method = "post" >
<a href = "javascript:document.profile.submit()" target = "profile_page" >Profile</a>
</form>
<form name = "balancepage" action="http://localhost:8080/springmvc.jdbc.website/balancepage" method = "post" >
<a  href = "javascript:document.balancepage.submit()" target = "balance_page" >Balance</a>
</form>
<form name = "rewardspage" action="http://localhost:8080/springmvc.jdbc.website/rewardspage" method = "post" >
<a class = "active" href = "javascript:document.rewardspage.submit()" target = "rewards_page" >Rewards</a>
</form>
<form name = "logout" action="http://localhost:8080/springmvc.jdbc.website/logout" method = "post" >
<a href = "javascript:document.logout.submit()" target = "logout_page" >Logout</a>
</form>
</div>
<div style="padding-left:16px">
<h3>Hello,<%out.println(request.getAttribute("Username").toString()); %>....</h3>
<h3>Rewards Earned = <%out.println(request.getAttribute("Rewards").toString()); %> </h3>
</div>
</body>
</html>