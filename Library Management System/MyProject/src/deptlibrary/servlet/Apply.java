package deptlibrary.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.JobsEntry;

/**
 * Servlet implementation class Apply
 */
@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 DateFormat d = new SimpleDateFormat("YYYY-d-MM hh:mm");
		Date submitted = new Date();
		String a = d.format(submitted);
	    
    public Apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<JobsEntry> subentries = new ArrayList<JobsEntry>();
		
		  try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from positions" );

	            while( rs.next() )
	            {
	            	JobsEntry entry = new JobsEntry( 
	            	rs.getInt("id"), rs.getString( "position" ));
	            	
	            	subentries.add(entry);
	            }

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

		request.setAttribute("subentries", subentries);

	
		request.getRequestDispatcher("/WEB-INF/Apply.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		
		   try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            String sql = "insert into jobs (name, position, submitted)	values ( ?, ?, ?)";   
	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement(sql);
	             
	            pstmt.setString(1, name);
	            pstmt.setString(2, position);
	            pstmt.setString(3, a);
	            pstmt.executeUpdate();
	            
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }


			response.sendRedirect("Jobs");
	}

}
