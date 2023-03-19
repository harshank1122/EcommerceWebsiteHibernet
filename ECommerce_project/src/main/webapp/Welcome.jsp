<%@page import="com.ecommerce.user.User"%>

<%
User user = (User) session.getAttribute("current-user");
if (user == null) {
	response.sendRedirect("login.jsp");
} 
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New User</title>
<link rel="stylesheet" href="css/style.css">
<%@ include file="components/cs_js.jsp"%>


</head>

<body>
	<%@ include file="components/navbar.jsp"%>
</body>

</html>