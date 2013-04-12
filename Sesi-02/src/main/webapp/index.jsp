<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>

<html lang="id">
<head>
	<title>Belajar JSP dan JSTL</title>
</head>
<body>
	<section>
		<h1>Tanggal dan waktu </h1>
			<% Date dNow = new Date( );
					SimpleDateFormat ft = new SimpleDateFormat ("E, dd MM yyyy");
					out.print( "Hari dan Tanggal Saat ini : " + ft.format(dNow));
				%>
				<br/>
		
			<% Date tNow = new Date( );
					SimpleDateFormat fs = new SimpleDateFormat ("hh:mm:ss");
					out.print( "Waktu saat ini : " + fs.format(tNow)); %>
		</p>
	</section>
<p><hr>
<form action="output.jsp" method="POST">
	<h1>Input Data</h1>
	<table>
		<tr><td>Nama</td><td><input type="text" name="nama"></td></tr>
		<tr><td>Email</td><td><input type="text" name="email"></td></tr>
		<tr><td>Tanggal Lahir</td><td><input type="text" name="tgl"></td>
		</tr><tr><td>Alamat</td><td><textarea width="15" height="20" name="alamat"></textarea></td></tr>
		<tr colspan=2"><td><input type="submit" value="Simpan"></td></tr>
	</table>
</form>
</body>
</html>