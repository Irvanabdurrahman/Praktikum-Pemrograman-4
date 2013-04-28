package com.spring;

import java.util.List;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Date;

public interface ProdukDao{
	
	public void simpan(String kode, String nama, BigDecimal harga, Date terakhirUpdate);
	
	public List <Produk> cariSemuaProduk();
}