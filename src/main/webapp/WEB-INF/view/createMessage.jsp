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
					<form:form method ="post" modelAttribute="usermessage">
						<form:select path="userReciver" items ="${avaiableFriends}" itemLabel="firstName" itemValue="id"></form:select><br/>
						<form:textarea path="userMessage" id="userMessage"/><br/><br/>
						<input class="signin" type="submit"  value="Send message"></input>
					</form:form>
				</div>
			</div>
		</div>
	
	
	

</body>
</html>