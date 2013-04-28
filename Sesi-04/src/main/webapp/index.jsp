<!--
---------------------------------------------------------------------------------------
	* Copyright by irvan abdurrahman, friday, 26 april 2013
---------------------------------------------------------------------------------------
-->

<html lang="id">
	<head>
		<title>Form JSP</title>
	</head>
	<body>
		<h1>Entri Data Produk</h1><hr>
		<form action="output.php">
			<table border="0">
				<tr><td>Kode</td><td><input type="text" name="kode"></td></tr>
				<tr><td>Nama</td><td><input type="text" name="nama"></td></tr>
				<tr><td>Harga</td><td><input type="number" name="harga"></td></tr>
				<tr><td>Terakhir Update</td><td><input type="date" name="terakhirUpdate"></td></tr>
				<tr><td><input type="submit" value="Simpan"></td></tr>
			</table>
		</form>
	</body>
</html>