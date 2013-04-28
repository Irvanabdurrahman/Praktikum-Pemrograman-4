<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 <!--
---------------------------------------------------------------------------------------
	* Copyright by irvan abdurrahman, friday, 26 april 2013
---------------------------------------------------------------------------------------
-->

<html>
<head>
<title>Daftar Data Produk</title>
</head>
<body bgcolor=#f0f0f0>
 
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/p4"
     user="root"  password=""/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from produk;
</sql:query>
 <h1 align="center">Daftar Data Produk</h1><hr><p>
<table border="1" width="430" height="70" align="center">
<tr>
   <th>Kode</th>
   <th>Nama</th>
   <th>Harga</th>
   <th>Terakhir Update</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.kode}"/></td>
   <td><c:out value="${row.nama}"/></td>
   <td><c:out value="${row.harga}"/></td>
   <td><c:out value="${row.terakhirUpdate}"/></td>
</tr>
</c:forEach>
</table>
<p align="center"><a href="index.jsp">>> Kembali ke halaman awal</a>
</body>
</html>