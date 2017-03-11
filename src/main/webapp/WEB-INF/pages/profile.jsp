<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<%
 String Firstname ="";
 String Lastname ="";
 String Maidenname ="";
 String Email ="";
 String Username ="";
 String Phone ="";
 Firstname=request.getAttribute("Firstname").toString(); 
 Lastname = request.getAttribute("Lastname").toString();
 Maidenname = request.getAttribute("Maidenname").toString();
 Email = request.getAttribute("Email").toString();
 Username = request.getAttribute("Username").toString();
 Phone = request.getAttribute("Phone").toString();
 out.println("First Name::"+Firstname+"<br>"+"Last Name::"+Lastname+"<br>"+"Mother's Maiden Name::"+Maidenname+"<br>"+"Email::"+Email+"<br>"+"User Name::"+Username+"<br>"+"Phone::"+Phone);
 %>
</body>
</html>