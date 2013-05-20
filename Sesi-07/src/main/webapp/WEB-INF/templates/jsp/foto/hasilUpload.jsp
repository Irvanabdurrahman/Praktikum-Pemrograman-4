<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Hasil Upload</title>
	</head>
	<body>
	<h1>Hasil Upload Foto</h1>
	 <c:choose>
			<c:when test="${empty hasilUpload}">
                <h2>Kosong</h2>
			</c:when>
	<c:otherwise>
	<table border="1">
		<tr>
			<th><input type="checkbox" disabled></th>
			<th>Nama File</th>
			<th>Ukuran (KB)</th>
			<th colspan="2">Aksi</th>
		</tr>
		<form action="hapus-semua" method="POST" id="checkForm">
		<c:forEach items="${hasilUpload}" var="f">
		<tr>
			<td><input type="checkbox" name="Pilihan" value="${f.nama}"></td>
			<td>${f.nama}</td>
			<td>${f.ukuran}</td>
			<td><a href="<%= request.getContextPath() %>/images/${f.nama}">lihat</a></td>
			<td><a href="hapus?nama=${f.nama}">hapus</a></td>
		</tr>
		</c:forEach>
		</form>
	<table>
		<a href="hapus-semua">Hapus Semua</a> | <a href="#" onclick="submitForm()">hapus terpilih</a> |
	</c:otherwise>
	</c:choose>
	<a href="<%= request.getContextPath() %>/aplikasi/foto/upload">Upload Foto</a>
			 <script>
					function submitForm(){
						var a = document.getElementById("checkForm");
						a.submit();
					}
			</script>
	</body>
</html>