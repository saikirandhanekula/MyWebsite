<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PasswordReset</title>
</head>
<body>
<h2>We are sent a link to <%out.println(request.getAttribute("Email").toString()); %></h2>
<h2>Please follow that link to reset your password....</h2>
</body>
</html>