<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email with Spring MVC</title>
</head>
<body>
        <form action="http://localhost:8080/springmvc.jdbc.website/forgotpassword" method="post">
            <table class = "center-div" style="width: 500px;">
                <tr>
                    <td colspan="2" align = "center"><h4>Please Enter Email Address</h4></td>
                    <td><input type="text" placeholder = "Please Enter Email" name="Recipient" size="65" /></td>
                </tr>
                             
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Send E-mail" />
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>