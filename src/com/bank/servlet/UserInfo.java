package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	Connection connection;
	PreparedStatement psSelect;
	private static final long serialVersionUID = 1L;
       
    
    public UserInfo() {
        super();
        
    }
    public void init(ServletConfig config) throws ServletException 
	{	
		super.init(config);
		try 
        {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/bank","root","root");
			 psSelect=connection.prepareStatement("select * from NewCustomer where UserName=?;");
        } 
        catch (ClassNotFoundException  | SQLException e) 
        {
			
			e.printStackTrace();
        }
    }
    
        
    


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
	     if (session==null)
	     {
	  	   response.sendRedirect("Login.html");
	  	   return;
	     }
	     String user=(String) session.getAttribute("username");
	     
			
		
	     try
			{  
	    	 psSelect.setString(1, user);
	    	 ResultSet result =psSelect.executeQuery();
			  out.println("<html>");
			  out.println("<body>");
		  out.println("Welcome  <b>"+session.getAttribute("username")+"</b><br/>");
		  out.println("<b>"+"working on it"+"</b>");
		 


		  
	}
	     catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     

}
}
