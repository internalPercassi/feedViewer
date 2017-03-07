<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>
<html>
 
	<head>
	   <!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	    <title><tiles:getAsString name="title" /></title>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">    
	
		<!-- scripts -->
	 	<script src="<c:url value="/resources/libraries/jquery-3.1.1.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript" ></script>
 		<script src="<c:url value="/resources/js/data-table.js" />" type="text/javascript" ></script>
		
		<!-- css -->
		<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" >
		<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet" type="text/css" >
	</head>
	  
	<body>
			<section id="top-menu">
	            <tiles:insertAttribute name="topMenu" />
	        </section>
	        
	        <header id="header">
	            <tiles:insertAttribute name="header" />
	        </header>
	     
	        <section id="side-menu">
	            <tiles:insertAttribute name="sideMenu" />
	        </section>
	             
	         <section id="site-content">
	            <tiles:insertAttribute name="body" />
	        </section>
	         
	        <footer id="footer">
	            <tiles:insertAttribute name="footer" />
	        </footer>
	</body>
</html>