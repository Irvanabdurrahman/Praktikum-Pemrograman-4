/* Irvan Abdurrahman - 4510210003, Friday, April 19, 2013 */

package com.spring;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.math.BigDecimal;
import java.util.Date;

public class ProdukTemplate implements ProdukDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void simpan(String nama, String kode, BigDecimal harga, Date terakhirUpdate){
		String SQL = "insert into Produk (kode, nama, harga, terakhirUpdate) values (?,?,?,?)";
		
		jdbcTemplateObject.update(SQL, kode, nama, harga, terakhirUpdate);
		System.out.println("Kode: " + kode + " Nama: " + nama + " Harga: " + harga + " Terakhir Update: " + terakhirUpdate );
		return;
	
	}
	
	public List<Produk> cariSemuaProduk(){
		String SQL="select * from produk";
		List <Produk> produks = jdbcTemplateObject.query(SQL, new ProdukMapper());
		return produks;
	}

}