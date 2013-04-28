package com.spring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.ProdukTemplate;
import java.math.BigDecimal;
import java.util.Date;

public class Main{
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("config-spring.xml");

		
		ProdukTemplate produkTemplate = (ProdukTemplate)context.getBean("ProdukTemplate");
		
		System.out.println("\n---------------------------------------------- \n \tMenyimpan Record \n----------------------------------------------");
			produkTemplate.simpan("Acer", "123" , new BigDecimal(50000), new Date());
			produkTemplate.simpan("Asus" , "124", new BigDecimal(55000), new Date());
			produkTemplate.simpan("Sony" , "125", new BigDecimal(60000), new Date());
			
		System.out.println("\n---------------------------------------------- \n \tDaftar Record \n----------------------------------------------");
		List <Produk> produks = produkTemplate.cariSemuaProduk();
		for (Produk record : produks){
			System.out.print("ID: " + record.getId());
			System.out.print(", Nama: " + record.getNama());
			System.out.print(", Kode: " + record.getKode());
			System.out.print(", Harga: " + record.getHarga());
			System.out.println(", Terakhir Update: " + record.getTerakhirUpdate());
		}
		System.out.println("---------------------------------------------- \n \tCopyright by Irvan Abdurrahman \n----------------------------------------------\n");
	}
}