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
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"/>
</head>
<body>

<div id="flipkart-navbar">
    <div class="container">
        <div class="row row1">
            <ul class="largenav pull-right">
            	<li class="upper-links"><h1>MailBox</h1></li>
				<li class="upper-links"><a class="visited1" href="/createMessage">Create Message</a></li>
				<li class="upper-links"><a class="visited1" href="/logged">Your Profile</a></li>
			</ul>
		</div>
	</div>
</div>
	
	
	
	
	<h2>Your Friends</h2>
	<!--  <p>${avaiableFriends}</p>-->
	
	
	<c:forEach var="product" items="${avaiableFriends}">
		
		<a class="friends" href="/showMessages/${product.id}"  >${product.firstName}</a><br/>
	</c:forEach>
	
	

	
	<div >
		<table style="float: left">
			<tr class="male3">
				<td><h1>Recived Mails</h1><pre>&#9;&#9;&#9; </pre></td>
			</tr>
		</table>
		<table style="float: left">
			<tr class="male3">
				<td><h1>Sended Mails</h1></td>
			</tr>
		</table>
		
	</div>
	

	<br/><br/><br/><br/>
	<br/><br/>
	<div style="clear: both;">
  <table style="float: left">
  	
  	<c:forEach var="product" items="${recivedMessages}">
    <tr class="male2">
      <td><p>Message from :${product.userSender.firstName}</p><p class="male1">${product.userMessage} </p><pre>&#9; &#9;  </pre></td>
    </tr>
    </c:forEach>
  </table>
 
  <table style="float: left">
  <pre>&#9; &#9;</pre>
  <c:forEach var="product" items="${sendedMessages}">
  
    <tr class="male2">
      <td><p>Message reciver :${product.userReciver.firstName}</p><p class="male4">${product.userMessage}</p></td>
    </tr>
    </c:forEach>
  </table  >
</div>

	<!--  
	<c:forEach var="product" items="${recivedMessages}">
		<p>${product.userMessage}</p>
	</c:forEach>
	<h1>Sended messages</h1>
	<c:forEach var="product" items="${sendedMessages}">
		<p>${product.userMessage}</p>
	</c:forEach>
	 </table>
	-->
		
		
</body>
</html>