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
import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class OutputServletDao extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//inisialisation for display result
        PrintWriter out = response.getWriter();
 		  try {
			//inisialisation spring framework from config-spring.xml
			ApplicationContext context = new ClassPathXmlApplicationContext("config-spring.xml");
			
			//get object from spring framework
			ProdukDao dao = context.getBean(ProdukDao.class);
			
			//for display in html
			response.setContentType("text/html");
			
			//call method cariSemuaProduk() from produkDao.java
			List <Produk> hasil = dao.cariSemuaProduk();
			out.println("<html><head><title></title></head><body bgcolor=#f0f0f0><h1>HASIL</h1>");
			
			//looping for display values
			for (Produk p:hasil){
						
						//input data dengan menggunakan request attribute
						request.setAttribute("kode", request.getParameter("kode"));
						request.setAttribute("nama", request.getParameter("nama"));
						request.setAttribute("harga", request.getParameter("harga"));
						request.setAttribute("terakhirUpdate", request.getParameter("terakhirUpdate"));
						
						//forward to outputData.jsp
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/outputData.jsp");
						dispatcher.forward(request,response);
						
						//display values
						out.println("\nKode : " + p.getId() +
											" , Nama : " + p.getNama() +
											" , Harga : " + p.getHarga()+
											" , Terakhir Update : " + p.getTerakhirUpdate() + "<br></body></html>");
			}   
		}catch(Exception e){
			//handling error with throws exception
			out.println(e);
		}
    }
}
