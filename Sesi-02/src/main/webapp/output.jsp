<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>

<html lang="id">
<head>
	<title>Hasil Verifikasi</title>
</head>
<body>
<h1>Hasil Verifikasi</h1>
<p>Nama : <%= request.getParameter("nama")%> </br>
Email : <%= request.getParameter("email")%> </br>
Tanggal Lahir : <%= request.getParameter("tgl")%> </br>
Alamat : <%= request.getParameter("alamat")%> </br>
</body>
</html>