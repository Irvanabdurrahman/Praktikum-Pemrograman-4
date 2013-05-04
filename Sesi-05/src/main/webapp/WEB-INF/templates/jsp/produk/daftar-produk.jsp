<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>Daftar Produk</title>
	</head>
	<body>
		<h1>DAFTAR PRODUK</h1><hr>
		<a href="input-produk">Tambah Data</a><p>
        <table border="1" cellspacing="5" width="500">
                <tr>
                    <th>No</th>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Harga</th>
                    <th>Terakhir Update</th>
                </tr>
                <c:forEach items="${daftarProduk}" var="p" varStatus="i">
                <tr>
                    <td align="center">${i.count}</td>
                    <td>${p.kode}</td>
                    <td>${p.nama}</td>
                    <td><fmt:formatNumber value="${p.harga}" type="number"></fmt:formatNumber></td>
                    <td align="center"><fmt:formatDate value="${p.terakhirUpdate}" pattern="EEE, dd MMM yyyy"></fmt:formatDate></td>
                </tr>
                </c:forEach>
        </table>
	</body>
</html>
