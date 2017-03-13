<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="http://localhost:8080/springmvc.jdbc.website/UsernameValidationPage" method="post"><br>
UserName <input type = "text" placeholder="Please enter User Name" name="Username" /><br><br>
<button type="submit" class="btn">Submit</button> <br><br>
</form:form>
</body>
</html>