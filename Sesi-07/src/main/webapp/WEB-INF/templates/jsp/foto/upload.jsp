<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Upload Foto</title>
		<style>
			fieldset{
						width:400px;
						border: 1px solid #781351;
						height:100px;
			}
		</style>
	</head>
	<body>
	<h1>Upload Foto</h1>
	<fieldset>
	<legend>Upload</legend>
	<spring:form modelAttribute="foto" enctype="multipart/form-data">
				<label><b>Upload Foto : </b></label>
				<input type="file" name="photofile"/></br>
				<input type="submit" value="Upload"/>
	</spring:form>
	</fieldset>
	</body>
</html>