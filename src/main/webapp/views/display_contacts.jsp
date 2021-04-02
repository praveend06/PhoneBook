<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function confirmDelete(){
	return confirm("Are you sure you want to delete?");
}
</script>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<span>${failMsg}</span><span>${succMsg}</span>
<h3>List of Contacts</h3>
<a href="/" > Create new contact </a>

<table border="1">
<thead>
<tr><th>Name</th><th>Email</th><th>Phone number</th></tr>
</thead>
<tbody>
<c:forEach items="${contacts}" var="contact">
<tr><td>${contact.name}</td><td>${contact.email}</td><td>${contact.phno}</td>
<td><a href="/edit_contact?id=${contact.id}">Edit</a></td>
<td><a href="/delete_contact?id=${contact.id}"  onclick="return confirmDelete">Delete</a></td>
</c:forEach>
</tbody>

</table>
</body>
</html>