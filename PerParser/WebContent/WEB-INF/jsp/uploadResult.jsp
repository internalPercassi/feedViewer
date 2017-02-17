<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Applying jQuery DataTables plugin in the Java Server application</title>
<!--         <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet"  type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css"  rel="stylesheet" type="text/css" media="all" /> -->
	 	<script src="<c:url value="/resources/libraries/jquery-3.1.1.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript" ></script>
		<script src="<c:url value="/resources/js/dashboard-controller.js" />" type="text/javascript" ></script>
 				<script src="<c:url value="/resources/js/upload-controller.js" />" type="text/javascript" ></script>
<%-- 	<script src="<c:url value="/resources/js/data-table.js" />" type="text/javascript" ></script> --%>
	<script src="<c:url value="/resources/datatable/js/jquery.dataTables.min.js" />" type="text/javascript" ></script>
	
	<!-- css -->
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" >
	<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet" type="text/css" >
<%-- 	<link href="<c:url value="/resources/css/data-table.css" />" rel="stylesheet" type="text/css" > --%>
    <link href="<c:url value="/resources/datatable/css/jquery.dataTables.min.css" />" rel="stylesheet" type="text/css" >
    <script type="text/javascript">
    
    $(document).ready(function() {     
    	
    	var data = ${data};
    	var tmp = data.data;
    	
                $('#example').DataTable( {
                    "data":tmp,
                    
                } );
    } );
    
    </script>
    </head>
<body>

<h1>Upload Status</h1>
<div class="table-responsive">
 	<table id="example" class="display table table-striped">
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