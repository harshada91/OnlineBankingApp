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
 * Servlet implementation class Authenticate
 */
@WebServlet("/login")
public class login extends HttpServlet 
{
	Connection connection;
	PreparedStatement psSelect;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		try 
        {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/bank","root","root");
				
	             
	        } 
			
        
        catch (ClassNotFoundException  | SQLException e) 
        {
			
			e.printStackTrace();
        }
	}
		

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
	    
	    {
	    	 boolean flag=false;
	    	psSelect=connection.prepareStatement("select * from NewCustomer where UserName=? and Password=?");
	    	
         String username=request.getParameter("username");
		 String password=request.getParameter("password");
		
		 
		 psSelect.setString(1, username.trim());
		 psSelect.setString(2, password.trim());
		
		 try(ResultSet result=psSelect.executeQuery())
		 {		
		 PrintWriter out=response.getWriter();
		 
			 if(result.next())
			 { 
				 HttpSession session=request.getSession();
				 session.setAttribute("username", username);
				 response.sendRedirect("UserInfo");
			 
			 
			 }						 
			 else
			 {
				 response.sendRedirect("Login.html");
			 }
			 
		 }
		 
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
   
	

	}
	public void destroy() {
		super.destroy();
		try {
			
			if(psSelect!=null)
			   psSelect.close();
			if(connection!=null)
	    		connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}


}
