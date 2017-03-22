<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>

<script src="<c:url value="/resources/js/dashboard-controller.js" />" type="text/javascript" ></script>


<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">Dashboard</h1>
<div class="row">
	<form class="col-md-12" method="POST" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">
		<div class="col-md-2">
			<select name="fileType" class="btn btn-default selectpicker form-control">
			    <option value="GL">GL File</option>
			    <option value="OS">OverSelling</option>
				<option value="FacebookProduct">Facebook Product</option>
				<option value="Amazon">Amazon</option>
		  	</select>
		</div>
		<div class="col-md-3">
			<div class="input-group">
		    	<div class="input-group">
	               <input type="text" class="form-control" readonly>
	               <label class="input-group-btn">
	                   <span class="btn btn-default">Browse&hellip; 
	                    <input type="file" style="display: none;" name="upload" multiple>
	                    </span>
	                </label>
	           	</div>
			</div>
		</div>
		<div class="col-md-2 pull-right">
			<input id="uploadBtn" class="btn btn-default form-control" type="submit" value="Upload File" />
		</div>
	</form>
</div>
	<h2 class="sub-header">${data.title}</h2>
	<c:if test="${fn:length(data.data) gt 0}">
	<div class="row">
		<jsp:include page="/WEB-INF/jsp/tiles/partials/fileSearchResultGrid.jsp" />
	</div>
	</c:if>
</div>