<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
	 	<script src="<c:url value="/resources/libraries/jquery-3.1.1.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/js/dashboard-controller.js" />" type="text/javascript" ></script>
 		<script src="<c:url value="/resources/js/upload-controller.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/datatable/js/jquery.dataTables.min.js" />" type="text/javascript" ></script>
	
	
	
		<script src="<c:url value="/resources/datatable/js/dataTables.buttons.min.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/datatable/js/buttons.flash.min.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/datatable/js/jszip.min.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/datatable/js/pdfmake.min.js" />" type="text/javascript" ></script>
	<script src="<c:url value="/resources/datatable/js/vfs_fonts.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/datatable/js/buttons.html5.min.js" />" type="text/javascript" ></script>
				<script src="<c:url value="/resources/datatable/js/buttons.print.min.js" />" type="text/javascript" ></script>
		
		<!-- css -->
	 	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" >
	 	<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet" type="text/css" >
	    <link href="<c:url value="/resources/datatable/css/jquery.dataTables.min.css" />" rel="stylesheet" type="text/css" >
	    
    
    </head>
<body>

<h1>Upload Status</h1>
<div class="table-responsive">
 	<table id="example" class="display table table-striped">
	 	<thead>
            <tr>
                <th>1</th>
                <th>2</th>
                <th>3</th>
                <th>4</th>
                <th>5</th>
                <th>6</th>
                <th>7</th>
                <th>8</th>
                <th>9</th>
            </tr>
        </thead>
         <tbody>
			<c:forEach items="${data}" var="DemoNames">
			    <tr>
			    	<c:forEach items="${DemoNames}" var="col">
			        	<td>${col}</td>
			        </c:forEach>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>