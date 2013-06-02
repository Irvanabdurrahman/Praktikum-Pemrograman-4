<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Form Edit</title>
	</head>
	<body>
		<h1>EDIT PRODUK</h1><hr>
		
		<spring:form modelAttribute="produk">
            <table border="0">
                    <tr><td>Kode</td><td><spring:input path="kode"/></td><td><spring:errors path="kode"/></td></tr>
                    <tr><td>Nama</td><td><spring:input path="nama"/></td><td><spring:errors path="nama"/></td></tr>
                    <tr><td>Harga</td><td><spring:input path="harga"/></td><td><spring:errors path="harga"/></td></tr>
                    <tr><td><input type="submit" value="Simpan"> </td></tr>
            </table>
       </spring:form>  
	</body>
</html>
