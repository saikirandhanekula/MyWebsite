<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/jpg" href="https://t4.ftcdn.net/jpg/00/92/43/63/240_F_92436345_3vi39s16xqwACLRrGwsrbdvpQ20y513z.jpg"/>
<title>Good Job Bank</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">

.container-4{
  overflow: hidden;
  width: 300px;
  vertical-align: middle;
  white-space: nowrap;
  margin-left: 78%;
}

.container-4 input#search{
  width: 300px;
  height: 50px;
  background: #2b303b;
  box-shadow: 0 0 10px #999;
  border: 2px solid #ccc;
  font-size: 12pt;
  float: left;
  color: #fff;
  padding-left: 15px;
  -webkit-border-radius: 5px;
  border-radius: 5px;
}
.container-4 input#search::-webkit-input-placeholder {
   color: #65737e;
}

.container-4 button.icon{
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
 
  border: none;
  background: #232833;
  height: 50px;
  width: 50px;
  color: #4f5b66;
  opacity: 0;
  margin-right:1em;
  font-size: 10pt;
 
  -webkit-transition: all .55s ease;
}

.container-4:hover button.icon, .container-4:active button.icon, .container-4:focus button.icon{
  outline: none;
  opacity: 1;
  margin-left: -50px;
}
 
.container-4:hover button.icon:hover{
  background: white;
}

header {
padding: 10px;
    color: white;
    text-align: center;
}

footer {
    padding: 10px;
    color: white;
    text-align: center;
}
fieldset{
display: block;
box-sizing: border-box;
box-shadow: 0 0 10px #999;
      background-color:	white;
      padding: 25px;
      font-size: 20px;
      width:400px;
      margin:auto;
      font-family:Arial,Helvetica,sans-serif;
}

body {
	 background: #343d46;
	 
    font-family: Arial,Helvetica,sans-serif,Meta-Bold;
    font-size: 16px;
    line-height: 1.125em;
    color:#293033;
}

input{
	background-color: white;
    width: 100%;
    padding: 5px;
    margin: 0;
    box-sizing: border-box;
    box-shadow: 0 0 10px #999;
}
input:focus {
    background-color: lightblue;
}

.container {
    overflow: hidden;
    background-color: #293033;
    font-family: Arial;
    box-sizing: border-box;
    box-shadow: 0 0 10px #999;
}

.container a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: black;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
a{
color: navy;
text-decoration:none;
}
a:hover{
 text-decoration: underline;
}
</style>
</head>
<body>
<header>
<h1>Welcome to DB Bank</h1>
</header>

<div class="container">
  <a href="#home">Home</a>
  <div class="dropdown">
    <button class="dropbtn">Banking</button>
    <div class="dropdown-content">
      <a href="#">Checking</a>
      <a href="#">Savings</a>
      <a href="#">Student Banking</a>
    </div>
  </div> 
  <div class="dropdown">
   <button class="dropbtn">Credit Cards</button>
     <div class="dropdown-content">
      <a href="#">Checking</a>
      <a href="#">Savings</a>
      <a href="#">Student Banking</a>
    </div>
    </div>
    <div class="dropdown">
   <button class = "dropbtn">Investments</button>
     <div class="dropdown-content">
      <a href="#">Checking</a>
      <a href="#">Savings</a>
      <a href="#">Student Banking</a>
    </div>
    </div>
     <a href="#aboutus">About Us</a>
     
       <div class="box">
  <div class="container-4">
    <input type="search" id="search" placeholder="Search..." />
    <button class="icon"><i class="fa fa-search"></i></button>
  </div>
</div>
     
</div>
<br>
<div>
<form:form action="http://localhost:8080/springmvc.jdbc.website/" method = "post"><br>
<fieldset>
Secure Sign-In
<br><br>
<table>
<tr>
<td><input type = "text" placeholder="Online ID" name="Username" /></td>
<td><input type = "password" placeholder="Password" name="Password" /></td>
<td><button style = "padding: 5px; box-sizing: border-box; box-shadow: 0 0 10px #999; width: 130%;" type="submit" class="btn">Sign In</button></td>
</tr>
</table>
<br>
<form name = "forgotpassword" action="http://localhost:8080/springmvc.jdbc.website/UsernameValidationPage">
<a href = "javascript:document.forgotpassword.submit()" target = "forgotpassword_page" >Forgot Password?</a>
</form>
<br><br>
<form name = "register" action="http://localhost:8080/springmvc.jdbc.website/register">
<a href = "javascript:document.register.submit()" target = "register_page" >Create Account</a>
</form>
</fieldset>
</form:form>
</div>
<footer>
<p>Developed by Dhanekula Bros</p>
<p>Contact Information:<a style="color:white" href = "mail to:gaalisreenu@gmail.com">dhanekulabros@dhanekula.com</a></p>
Copyright &copy; DhanekulaBros. All Rights Reserved.
<br><br>
<a href="https://www.facebook.com/saikiran.chowdary.372" class="fa fa-facebook" style="font-size:36px;color:lightblue"></a>
<a href="https://twitter.com/dhanekula_sai" class="fa fa-twitter" style="font-size:36px;color:lightblue"></a>
<a href="https://www.instagram.com/saikiran_dhanekula/" class="fa fa-instagram" style="font-size:36px;color:lightblue"></a>
</footer>

</body>
</html>