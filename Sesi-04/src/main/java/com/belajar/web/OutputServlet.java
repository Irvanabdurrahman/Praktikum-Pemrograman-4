/*
---------------------------------------------------------------------------------------
	* Copyright by irvan abdurrahman, friday, 26 april 2013
---------------------------------------------------------------------------------------
*/

package com.belajar.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.math.BigDecimal;
import java.sql.Date; 

public class OutputServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           //inisialisation for display result
		   PrintWriter out = response.getWriter();
				try {
						//inisialisation spring framework from config-spring.xml
						ApplicationContext context = new ClassPathXmlApplicationContext("config-spring.xml");
						
						//get object from spring framework
						ProdukDao dao = context.getBean(ProdukDao.class);
						
						//make object, take and save object produkDao from spring
						Produk p = new Produk();
						p.setKode(request.getParameter("kode"));
						p.setNama(request.getParameter("nama"));
						p.setHarga(new BigDecimal(request.getParameter("harga")));
						p.setTerakhirUpdate(Date.valueOf(request.getParameter("terakhirUpdate")));
						
						//save object produk with use method save in produkDao
						dao.simpan(p);
				}catch (Exception e) {
					//handling error with throws exception
						out.println(e);
				}
			
			//for display in html
			response.setContentType("text/html");
			
			//display values
			String title = "Hasil Entri Data<hr>";
			out.println("<html><head><title>hasil entri</title></head><body bgcolor=#f0f0f0>\n" +
							"<h1 align=center>\n" + title + "</h1>" +
									"<ul>\n" +
											"  <li>\nKode : " + request.getParameter("kode") +
											"  <li>Nama : " + request.getParameter("nama") +
											"  <li>Harga : " + request.getParameter("harga") +
											"  <li>Terakhir Update : " + request.getParameter("terakhirUpdate") +
									"</ul>\n<a href=outputDao.php>Daftar data produk</a> | <a href=index.jsp>Kembali ke halaman awal</a></body></html>");           
    }
}
