<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Contact Info</h3>
<span>${failMsg}</span><span>${succMsg}</span>
<form:form action="save_contact?id=${contact.id}" method="POST" modelAttribute="contact"  >
<table>
<tr><td>Name</td><td><form:input path="name" /></td></tr>
<tr><td>Email</td><td><form:input path="email" /></td></tr>
<tr><td>Phone no.</td><td><form:input path="phno" /></td></tr>
<tr><td></td><td><input type="submit" value="submit" /></td></tr>
</table>

<a href="/display_contacts">Show all contacts</a>
</form:form>
</body>
</html>