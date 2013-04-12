<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>Hasil Database</title>
</head>
<body>
 
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/P4"
     user="root"  password=""/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from produk;
</sql:query>
 <h1>Hasil Database</h1>
<table border="1" width="430" height="70">
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
   <td><c:out value="${row.terakhir_update}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>