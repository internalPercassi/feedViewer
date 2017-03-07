<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="table-responsive col-md-12">
 	<table id="dataGrid" class="display table table-striped table-bordered order-column"  cellspacing="0" width="100%"></table>
</div>

<script src="<c:url value="/resources/datatable/js/dataTables.fixedColumns.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/dataTables.bootstrap.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/dataTables.buttons.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/buttons.bootstrap.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/buttons.flash.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/jszip.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/pdfmake.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/vfs_fonts.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/buttons.html5.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/buttons.print.min.js" />" type="text/javascript" ></script>
<script src="<c:url value="/resources/datatable/js/buttons.colVis.min.js" />" type="text/javascript" ></script>

<link href="<c:url value="/resources/datatable/css/buttons.dataTables.min.css" />" rel="stylesheet" type="text/css" >
<link href="<c:url value="/resources/datatable/css/buttons.bootstrap.min.css" />" rel="stylesheet" type="text/css" >
<link href="<c:url value="/resources/datatable/css/dataTables.bootstrap.min.css" />" rel="stylesheet" type="text/css" >

<script type="text/javascript">
	    
		    $(document).ready(function() {     
		    	
			<c:if test="${not empty data}">
				
			   var data = ${data}
	            
			   var table = $('#dataGrid').DataTable( {
	                data:data.data,
	                columns: data.headers,
	                dom: 'B<"clear">lfrtip', 
	                buttons: [ 'copy', 'csv' ]
	           });

			   $("#dataGrid").append( $('<tfoot/>').append( $("#dataGrid thead tr").clone() ) );
			   
	            // Setup - add a text input to each footer cell
               $('#dataGrid tfoot th').each( function (i) {
			        var title = $('#dataGrid thead th').eq( $(this).index() ).text();
			        $(this).html( '<input type="text" placeholder="'+title+'" data-index="'+i+'" />' );
			   });
	            
               // Apply the search
               $( table.table().container() ).on( 'keyup', 'tfoot input', function () {
			        table
			            .column( $(this).data('index') )
			            .search( this.value )
			            .draw();
			    });
               
			</c:if>
		    	
		    });
	    
	    </script>