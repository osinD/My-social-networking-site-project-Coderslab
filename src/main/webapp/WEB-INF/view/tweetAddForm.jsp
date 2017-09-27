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
					<form:form method ="post" modelAttribute="tweet">
						<form:label path="title">Title</form:label><br/>
						<form:input path="title" id="title"/><br/>
						<form:label path="tweet_text">Tweet text</form:label><br/>
						<form:textarea path="tweet_text" id="tweet_text"/><br/><br/>
					<!--<form:select path="user" items ="${avaiableUsers}" itemLabel="firstName" itemValue="id"></form:select><br/>-->
						<input class="signin" type="submit"  value="Tweet Yourself"></input>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>