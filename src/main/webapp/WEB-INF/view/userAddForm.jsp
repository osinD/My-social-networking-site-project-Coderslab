<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="<c:url value="/resources/homeStyle.css" />" rel="stylesheet"/>
</head>
<body>
<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<h3>Enter Your's data</h3>
					<form:form method ="post" modelAttribute="user">
						<form:label path="firstName">FirstName</form:label><br/>
						<form:input path="firstName" id="firstName"/><br/>
						<form:label path="lastName">LastName</form:label><br/>
						<form:input path="lastName" id="lastName"/><br/>
						<form:label path="email">Email</form:label><br/>
						<form:input type="email" path="email" id="email"/><br/>
				<!--  	<form:label path="password">Password</form:label>-->
						<form:label path="password">Password</form:label><br/>
						<form:password path="password" /><br/><br/>
						<input class="signin" type="submit"  value="Register"></input>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>