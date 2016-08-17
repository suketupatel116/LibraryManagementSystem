package deptlibrary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.LibraryItemEntry;

@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CheckOut() {
        super();
    }
    
    int a = 1;
    
    DateFormat borrowed = new SimpleDateFormat("MM/dd/YYYY");
	Date bdate = new Date();
	String d= borrowed.format(bdate);
    
    private LibraryItemEntry GetItem(Integer id) throws ServletException
    {
/*    	@SuppressWarnings("unchecked")
		List<LibraryItemEntry> entries = (List<LibraryItemEntry>)getServletContext().getAttribute("entries");
    		for(LibraryItemEntry e: entries)
    			if(e.getId().equals(n))			return e;
    		
    	return null;*/
    	
    	LibraryItemEntry e = null;
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/cs320stu55";
            String username = "cs320stu55";
            String password = "root";

            String sql = "select * from library where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                e = new LibraryItemEntry( rs.getInt( "id" ),
                    rs.getString( "type" ), rs.getString( "name" ), rs.getString("info"), rs.getString("available"), rs.getInt("number"), rs.getString("dbb") );
        }
        catch( SQLException ex )
        {
            throw new ServletException( ex );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException ex )
            {
                throw new ServletException( ex );
            }
        }

        return e;

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LibraryItemEntry entry = GetItem(Integer.valueOf( request.getParameter("id")));
		
		request.setAttribute( "entry", entry );
		
		request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
			}

	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("id"));
		String sname = request.getParameter("sname");
		String cin = request.getParameter("cin");
		String dbb = request.getParameter("dbb");
		
		try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            String sql = "insert into logentry (id, cin, sname, bdate, rdate, dbb)	values ( ?, ?, ?, ?, ?, ?)";   
	            Connection c = DriverManager
	                .getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement(sql);
	             
	            pstmt.setInt(1, id);
	            pstmt.setString(2, cin);
	            pstmt.setString(3, sname);
	            pstmt.setString(4, d);
	            pstmt.setString(5, null);
	            pstmt.setString(6, dbb);
	            pstmt.executeUpdate();
	          /*
	            String sql2 = "update table library set dbb = ? where id = ?";
	            PreparedStatement pstmt2 = c.prepareStatement(sql2);
	            pstmt2.setString(1, dbb);
	            pstmt2.setInt(2, id);
	            pstmt2.executeUpdate();
		      */     
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

		   	String available = "No";
			Integer num = 0 ;
			
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            String sql = "update library set available = ?, number = ?, dbb = ? where id = ?";

	            c = DriverManager.getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString( 1, available);
	            pstmt.setInt( 2, num);
	            pstmt.setString(3, dbb);
	            pstmt.setInt( 4, id );
	            pstmt.executeUpdate();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }

		
		response.sendRedirect("LibraryEntry");
	
	}
}