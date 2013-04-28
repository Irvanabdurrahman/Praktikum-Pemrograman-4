package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class ProdukMapper implements RowMapper<Produk>{
	public Produk mapRow(ResultSet rs, int rowNum) throws SQLException{
		Produk produk = new Produk();
		produk.setId(rs.getInt("id"));
		produk.setKode(rs.getString("kode"));
		produk.setNama(rs.getString("nama"));
		produk.setHarga(rs.getBigDecimal("harga"));
		produk.setTerakhirUpdate(rs.getDate("terakhirUpdate"));
		return produk;
	}
}