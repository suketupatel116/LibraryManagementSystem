package deptlibrary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.JobsEntry;
import deptlibrary.model.LibraryItemEntry;

@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	int id = 3;
	public String[] ItemId; 
	public AddItem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<LibraryItemEntry> e = new ArrayList<LibraryItemEntry>();
		
		  try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from types" );

	            while( rs.next() )
	            {
	            	LibraryItemEntry entry = new LibraryItemEntry( 
	            	rs.getInt("id"), rs.getString( "type" ));
	            	
	            	e.add(entry);
	            }

	            c.close();
	        }
	        catch( SQLException ex )
	        {
	            throw new ServletException( ex );
	        }

		request.setAttribute("e", e);

		
	request.getRequestDispatcher("/WEB-INF/AddItem.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String id = request.getParameter("id");
	
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		String available = request.getParameter("available");
		int number = Integer.parseInt(request.getParameter("number"));
		
		
		if(number > 0){
			available = "Yes";
		}
		else 
			available = "No";
		
		if(name == null || info == null || available == null ){
			response.sendRedirect("AddItem");
		}
		
	
		for(int i = 0; i < number; i++){

		       try
		        {
		            String url = "jdbc:mysql://localhost/cs320stu55";
		            String username = "cs320stu55";
		            String password = "root";

		            String sql = "insert into library (type, name, info, available, number,dbb)	values ( ?, ?, ?, ?, ?, ?)";   
		            Connection c = DriverManager
		                .getConnection( url, username, password );
		            PreparedStatement pstmt = c.prepareStatement(sql);
		             
		            pstmt.setString(1, type);
		            pstmt.setString(2, name);
		            pstmt.setString(3, info);
		            pstmt.setString(4, available);
		            pstmt.setInt(5, 1);
		            pstmt.setString(6, null);
		            
		            //String sql = "insert into library (type, name, info, available, number)	values ('" + type + "', '" + name + "', '" + info + "', '" + available + "', '" + number + "')";
		            pstmt.executeUpdate();
		            
		            c.close();
		        }
		        catch( SQLException e )
		        {
		            throw new ServletException( e );
		        }


			//getServletContext().setAttribute("entries", entries);
		}
		
		response.sendRedirect("LibraryEntry");
	}

}