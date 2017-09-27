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
				<li class="upper-links"><h1>Welcome  </h1></li>
				<li class="upper-links"><h2><c:out value="${user.firstName}"/></h2></li>
				<li class="upper-links"><h2><c:out value="${user.lastName}"/></h2></li>
				
				 <li class="upper-links"><a class="visited" href="/Tweets/add">Add Tweet</a></li> 
				 <li class="upper-links"><a class="visited" href="/addfriend">Add User</a></li>
				 <li class="upper-links"><a class="visited" href="/signOut">Sign Out</a></li>
				 <li class="upper-links"><a class="visited" href="Messages">Messages</a></li>
			</ul>
		</div>
	</div>
</div>
	
	<h2>Your Friends</h2>
	<!--  <p>${avaiableFriends}</p>-->
	
	
	<c:forEach var="product" items="${avaiableFriends}">
		
		<a class="friends" href="/show/${product.id}"  >${product.firstName}</a><br/>
	</c:forEach>
		
	<table style="width:100%">
	<tr>
		<th><h1>Your tweets</h1></th>
	</tr>
	<c:forEach var="project" items="${Tweets}">
	
			
		
  		<tr>
    		<th><h2><c:out value="${project.title}"/></h2>
    		<p class="male">Created:<c:out value="${project.created}"/></p><br/>
    		
    		</th>
  		</tr>
  		<tr>
  			<th><p class="male1"><c:out value="${project.tweet_text}"/></p></th>
  		</tr>
  	
	
	</c:forEach>
	</table>
	
<!--  	<input type="text" name="param" value="<c:out value="${user}" />" />-->

</body>
</html>