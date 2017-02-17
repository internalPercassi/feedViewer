<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		    	
		    	var data = ${data};
		    	var tmp = data.data;
		    	
		                $('#example').DataTable( {
		                    data:tmp,
		                    dom: 'B<"clear">lfrtip', 
		                    buttons: [
		                        'copy', 'csv', 'excel'
		                    ]
		                } );
		    } );
	    
	    </script>
    </head>
	<body>
		<div class="table-responsive col-md-12">
		 	<table id="example" class="display table table-striped table-bordered" cellspacing="0" width="100%">
			 	<thead>
		            <tr>
		                <th>GL</th>
		                <th>INS</th>
		                <th>Pertinency Site</th>
		                <th>Pertinency Site Desc</th>
		                <th>Unique product code</th>
		                <th>Depositor</th>
		                <th>Stocked Qty</th>
		                <th>Stocked Qty</th>
		                <th>Accounting State</th>
		            </tr>
		        </thead>
			</table>
		</div>
	</body>
</html>