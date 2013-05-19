<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Upload Foto</title>
	</head>
	<body>
	<h1>Upload Foto</h1>
	<spring:form modelAttribute="foto" enctype="multipart/form-data">
				<label>Upload Foto : </label>
				<input type="file" name="photofile"/><br>
				<input type="submit" value="Proses"/>
	</spring:form>
	</body>
</html>