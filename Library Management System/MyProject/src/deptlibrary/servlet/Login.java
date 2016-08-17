package deptlibrary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.LibraryItemEntry;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
				
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
	}
    
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {

			    	/*        if( request.getParameter( "username" ).equals( "cysun" )
			        && request.getParameter( "password" ).equals( "root" ) )
			    {
			    	System.out.println("Get");
			        request.getSession().setAttribute("user", "cysun" );
			        response.sendRedirect( "LibraryEntry" );
			    }
			    else
			        response.sendRedirect( "Login" );
			*/	

    	request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);			
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
   
						
		try
        {
            String url = "jdbc:mysql://localhost/cs320stu55";
            String username = "cs320stu55";
            String password = "root";

            String sql = "select * from users where username = ? and password = ?";

            Connection c = DriverManager.getConnection( url, username, password );
            PreparedStatement ptmt = c.prepareStatement(sql);
            ptmt.setString(1, user);
            ptmt.setString(2, pass);
            ResultSet rs = ptmt.executeQuery();
            	
            if( rs.next() )
            {
            	
    		        request.getSession().setAttribute("user",rs.getString("username") );
    		    	        		
            		response.sendRedirect("LibraryEntry");
            } 	
           else{
            		
            		response.sendRedirect("Login");
            	}

            
        
            c.close();
        } 
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
		
	}
	
}   