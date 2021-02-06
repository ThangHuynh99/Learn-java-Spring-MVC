<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
<div class="container">
	<a class="navbar-brand" href="#">Welcome to T&T shop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			
			<security:authorize access = "isAnonymous()">
				<li class="nav-item"><a class="nav-link" href='<c:url value="/login"/> '>Login</a></li>
				<li class="nav-item"><a class="nav-link" href='<c:url value="/register"/>'>Register</a></li>
			</security:authorize>
			
			<security:authorize access = "isAuthenticated()">
				<li class="nav-item"><a class="nav-link" href="#">Xin chào, <%= SecurityUtils.getPrincipal().getFullName() %></a></li>
				<li class="nav-item"><a class="nav-link" href='<c:url value="/logout"/> '>Logout</a></li>
			</security:authorize>
		</ul>
	</div>
</div>
</nav>
