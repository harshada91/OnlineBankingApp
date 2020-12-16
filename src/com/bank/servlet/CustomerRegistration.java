package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.pojo.*;


@WebServlet("/CustomerRegistration")
public class CustomerRegistration extends HttpServlet
{
	Connection connection;
	PreparedStatement psInsert;
	private static final long serialVersionUID = 1L;
       
    
    public CustomerRegistration() {
        super();
    }  

	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		try 
        {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/bank","root","root");
				//PreparedStatement psInsert=connection.prepareStatement("insert into NewCustomer values(?,?,?,?,?,?,?,?)");
	             
	        } 
			
        
        catch (ClassNotFoundException  | SQLException e) 
        {
			
			e.printStackTrace();
        }
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			PrintWriter out=response.getWriter();
	String id=request.getParameter("Id");
			//int id=101;
		String name=request.getParameter("Name");
		String username=request.getParameter("UserName");
		String password=request.getParameter("Password1");
		String password2=request.getParameter("Password2");
		String email=request.getParameter("email");
		String amount=request.getParameter("Ammount");
		String address=request.getParameter("Address");
		String mobile=request.getParameter("mobile");
		if(password.equals(password2))
        {
        	
		PreparedStatement psInsert=connection.prepareStatement("insert into NewCustomer values(?,?,?,?,?,?,?,?)");         
		psInsert.setString(1,id);
		psInsert.setString(2,name);
		psInsert.setString(3,username);
		psInsert.setString(4,password);
		psInsert.setString(5,email);
		psInsert.setString(6,amount);
		psInsert.setString(7,address);
		psInsert.setString(8,mobile);

        
        
		int rowAffected= psInsert.executeUpdate();
	    

	    if(rowAffected > 0) {
	    	
	    	
            out.println("<b>"+ "Successfully created Account"+ "</b>");
            response.sendRedirect("Login.html");
        }
        else {
        	out.println("<b>"+ "Failed to create account,Try later"+ "</b>");
        	
            response.sendRedirect("index.html");
        }
	          
		}
        else
        	out.println("<b>"+"password does not match"+"</b>");
		}
	    catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	
	}
	
	
	public void destroy()
	{

		super.destroy();
		try
		{
			
			if(psInsert!=null)
				psInsert.close();
			if(connection!=null)
	    		connection.close();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
	
	}


}
