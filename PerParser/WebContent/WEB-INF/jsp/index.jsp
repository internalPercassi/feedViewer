<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    

	<!-- scripts -->
 	<script src="<c:url value="/resources/libraries/jquery-3.1.1.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/js/dashboard-controller.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/js/data-table.js" />" type="text/javascript" ></script>
	
	<!-- css -->
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" >
	<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet" type="text/css" >
	<link href="<c:url value="/resources/css/data-table.css" />" rel="stylesheet" type="text/css" >
 	    <script type="text/javascript">
	    
		    $(document).ready(function() {     
		    	
			
			<c:if test="${not empty data}">
				
				var data = ${data}
			
	            $('#example').DataTable( {
	                data:data.data,
	                columns: data.headers,
	                dom: 'B<"clear">lfrtip', 
	                buttons: [
	                    'copy', 'csv', 'excel'
	                ]
	            } );
				
			</c:if>
				
			

		    	

		    } );
	    
	    </script>
	<title>PerParser</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">PerParser</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Help</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>
		  <div class="row placeholders">
			<form method="POST" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">
				<div class="col-md-3">
					<select name="fileType" class="btn btn-default selectpicker">
					    <option value="GL">GL File</option>
					    <option value="OS">OverSelling</option>
					    <option value="OPE">OPE</option>
					    <option value="OBE">OBE</option>
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
				<div class="col-md-3">
					<input class="btn btn-default" id="uploadBtn" type="submit" value="Upload File" />
				</div>
			</form>
			
		<ul>

		</ul>
		  </div>
          <h2 class="sub-header">Section title</h2>       
          		<c:if test="${fn:length(data.data) gt 0}" >
			<div class="table-responsive col-md-12">
			 	<table id="example" class="display table table-striped table-bordered" cellspacing="0" width="100%">
				</table>
			</div>
		</c:if>
        </div>
      </div>
    </div>
  </body>
</html>