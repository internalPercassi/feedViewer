<html>
<head>
<title>Spring MVC Tutorial Series by Crunchify.com</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
	<br>
	<div style="text-align:center">
		<h2>perParser<br> <br>
		</h2>
<!-- 		<h3>
			<a href="welcome.html">Click here to See Welcome Message... </a>(to
			check Spring MVC Controller... @RequestMapping("/welcome"))
		</h3> -->
<!-- 			<form action="action.jsp">

			  <input type="submit" value="Submit">
			</form> -->
			
			
			<%-- <form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data"> --%>
			<form method="POST" action="upload" enctype="multipart/form-data">
			<select name="fileType">
			    <option value="GL">GL File</option>
			    <option value="OS">OverSelling</option>
			    <option value="OPE">OPE</option>
			    <option value="OBE">OBE</option>
			  </select>
	    		<input type="file" name="pippo" /><br/>
			    <input type="submit" value="Upload File" />
			</form>
	</div>
</body>
</html>