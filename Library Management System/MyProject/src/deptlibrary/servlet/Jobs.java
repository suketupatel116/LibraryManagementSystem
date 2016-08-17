package deptlibrary.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.JobsEntry;
import deptlibrary.model.LibraryItemEntry;

/**
 * Servlet implementation class Jobs
 */
@WebServlet("/Jobs")
public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<JobsEntry> entries = new ArrayList<JobsEntry>();
		
		  try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from jobs" );

	            while( rs.next() )
	            {
	            	JobsEntry entry = new JobsEntry( 
	            	rs.getInt("id"), rs.getString( "position" ), rs.getString( "name" ), rs.getString( "submitted" ));
	            	
	            	entries.add(entry);
	            }

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

		request.setAttribute("entries", entries);
		request.getRequestDispatcher("/WEB-INF/Jobs.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
