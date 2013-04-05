
package com.belajar.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nama = request.getParameter("nama");
			nama = nama.toUpperCase();
                    
            String output = "<html>";
            output += "<body>";
            output += "<h1>Halo "+nama+"</h1>";
            output += "</body>";
            output += "</html>";
            
            // content type = html
            response.setContentType("text/html");
            response.getWriter().print(output);
        } catch (IOException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
