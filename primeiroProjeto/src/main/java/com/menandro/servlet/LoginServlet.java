package com.menandro.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 98599739738L;
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + username + "<br/>";      
        htmlResponse += "Your password is: " + password + "</h2>";    
        htmlResponse += "</html>";
         
        // return response
        writer.println(htmlResponse);
         
    }
 
}