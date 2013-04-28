/* Irvan Abdurrahman - 4510210003, Friday, April 19, 2013 */

package com.spring;

import java.math.BigDecimal;
import java.util.Date;

public class Produk{
	private Integer id;
	private String kode;
	private String nama;
	private BigDecimal harga;
	private Date terakhirUpdate;
		
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setKode(String kode){
		this.kode=kode;
	}
	
	public String getKode(){
		return kode;
	}
	
	public void setNama(String nama){
		this.nama=nama;
	}
	
	public String getNama(){
		return nama;
	}
	
	public void setHarga(BigDecimal harga){
		this.harga=harga;
	}
	
	public BigDecimal getHarga(){
		return harga;
	}
	
	public void setTerakhirUpdate(Date terakhirUpdate){
		this.terakhirUpdate=terakhirUpdate;
	}
	
	public Date getTerakhirUpdate(){
		return terakhirUpdate;
	}
}