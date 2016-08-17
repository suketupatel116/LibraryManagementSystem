package deptlibrary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.LibraryItemEntry;

@WebServlet(urlPatterns = "/LibraryEntry", loadOnStartup = 1)
public class LibraryEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LibraryEntry() {
        super();
    }

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		List<LibraryItemEntry> entries = new ArrayList<LibraryItemEntry>();
		   
	       try 	
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from library" );

	            while( rs.next() )
	            {
	            	LibraryItemEntry entry = new LibraryItemEntry( 
	            	rs.getInt("id"), rs.getString( "type" ), rs.getString( "name" ), rs.getString( "info" ), rs.getString( "available" ), rs.getInt("number"), rs.getString("dbb"));
	            	
	            	entries.add(entry);
	            }

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	       List<LibraryItemEntry> subentries = new ArrayList<LibraryItemEntry>();
		   
	       try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from logentry" );

	            while( rs.next() )
	            {
	            	LibraryItemEntry subentry = new LibraryItemEntry( 
	            	rs.getInt("id"), rs.getInt("sid"), rs.getString( "cin" ), rs.getString( "sname" ),
	            	rs.getString( "bdate" ), rs.getString( "rdate" ), rs.getString( "dbb" ));
	            	
	            	subentries.add(subentry);
	            	Collections.reverse(subentries);
	            }

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	       Calendar cal = Calendar.getInstance();
	       cal.add(Calendar.DATE, 1);
	       SimpleDateFormat format1 = new SimpleDateFormat("mm/dd/yyyy");

		request.setAttribute( "subentries", subentries );
		request.setAttribute( "systemdate", format1.format(new Date()) );
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("/WEB-INF/LibraryEntry.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	
	}

}
