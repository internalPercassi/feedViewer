<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
	 	<script src="<c:url value="/resources/libraries/jquery-3.1.1.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/js/dashboard-controller.js" />" type="text/javascript" ></script>
		
		<script src="<c:url value="/resources/datatable/js/jquery.dataTables.min.js" />" type="text/javascript" ></script>
	    <script src="<c:url value="/resources/datatable/js/dataTables.bootstrap.min.js" />" type="text/javascript" ></script>
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
	    <link href="<c:url value="/resources/datatable/css/buttons.dataTables.min.css" />" rel="stylesheet" type="text/css" >
	    <link href="<c:url value="/resources/datatable/css/dataTables.bootstrap.min.css" />" rel="stylesheet" type="text/css" >
	    
	    <script type="text/javascript">
	    
		    $(document).ready(function() {     
		    	
			<c:if test="${not empty data}" >
				
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
    </head>
	<body>
	<h1>${data.title}</h1>
		<div class="table-responsive col-md-12">
		 	<table id="example" class="display table table-striped table-bordered" cellspacing="0" width="100%">
			</table>
		</div>
	</body>
</html>