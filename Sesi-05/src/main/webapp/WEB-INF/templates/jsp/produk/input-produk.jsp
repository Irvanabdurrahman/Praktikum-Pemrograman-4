<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Input Form</title>
	</head>
	<body>
		<h1>INPUT PRODUK</h1><hr>
		 <form method="POST">
            <table border="0">
                    <tr><td>Kode</td><td><input name="kode"></td></tr>
                    <tr><td>Nama</td><td><input type="text" name="nama" value="" /></td></tr>
                    <tr><td>Harga</td><td><input type="text" name="harga" value="" /></td></tr>
                    <tr><td><input type="submit" value="Simpan"> </td></tr>
            </table>
        </form>     
	</body>
</html>
