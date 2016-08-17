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
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.LibraryItemEntry;

/**
 * Servlet implementation class Return
 */
@WebServlet("/Return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Return() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer subid=Integer.parseInt(request.getParameter("index"));
		Integer lid=Integer.parseInt(request.getParameter("lid"));
		 DateFormat dateformat = new SimpleDateFormat("MM/dd/YYYY");
		   	Date date = new Date();
		   	String rdate=dateformat.format(date);
		Connection c=null;
		
		System.out.println(subid);
		
		String available = "Yes";
		Integer number = 1;
		 try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            
	            String sql="update logentry set rdate=? where sid=?";
	            c = DriverManager.getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString(1,rdate );
	            pstmt.setInt(2, subid);
	            pstmt.executeUpdate();
	            
	             String sql1="update library set available=?, number = ? where id=?";
		            c = DriverManager
		                .getConnection( url, username, password );
		             PreparedStatement pstmt1 = c.prepareStatement( sql1 );
		             pstmt1.setString(1,available );
		             pstmt1.setInt(2, number);
		             pstmt1.setInt(3, lid);
		             pstmt1.executeUpdate();
	            

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

		
		 response.sendRedirect("LibraryEntry");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
