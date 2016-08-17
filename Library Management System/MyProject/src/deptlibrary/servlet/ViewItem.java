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
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deptlibrary.model.LibraryItemEntry;

@WebServlet("/ViewItem")
public class ViewItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewItem() {
        super();
         
    }
/*public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		List<LibraryItemEntry> entries = new ArrayList<LibraryItemEntry>(); 
		List<LibraryItemEntry> subentries = new ArrayList<LibraryItemEntry>(); 
		
		entries.add(new LibraryItemEntry(1, "Tablet", "Samsung Galaxy Tab 10.7", "Android 4.4.2", "Yes", 1));
		entries.add(new LibraryItemEntry(2, "Book", "Introduction to Algorithms", "Thomas Cormen", "No", 0));
		
		getServletContext().setAttribute("entries", entries);
		getServletContext().setAttribute("subentries", subentries);
		
	}
    */
    
    
    private LibraryItemEntry GetItem(Integer n) throws ServletException
    {
/*    	@SuppressWarnings("unchecked")
		List<LibraryItemEntry> entries = (List<LibraryItemEntry>)getServletContext().getAttribute("entries");
    		for(LibraryItemEntry e: entries)
    			if(e.getId().equals(n))			return e;
    		
    	return null;
*/    	
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
            pstmt.setInt( 1, n );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                e = new LibraryItemEntry( rs.getInt( "id" ),
                    rs.getString( "type" ), rs.getString( "name" ), rs.getString("info"), rs.getString("available"),
                    rs.getInt("number"), rs.getString("dbb"));
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

    
    @SuppressWarnings("unused")
	private LibraryItemEntry Subtem(Integer n) throws ServletException
    {
/*    	@SuppressWarnings("unchecked")
		List<LibraryItemEntry> subentries = (List<LibraryItemEntry>)getServletContext().getAttribute("subentries");
    		for(LibraryItemEntry e: subentries)
    			if(e.getSid().equals(n))			return e;
    		
    	return null;
*/
    	LibraryItemEntry e = null;
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/cs320stu55";
            String username = "cs320stu55";
            String password = "root";

            String sql = "select * from logentry le, library l where le.id = l.id";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                e = new LibraryItemEntry( rs.getInt( "id" ), rs.getInt( "sid" ),
                    rs.getString( "cin" ), rs.getString( "sname" ), rs.getString("bdate"), rs.getString("rdate"),
                    rs.getString("dbb"));
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
	
		//System.out.println(Integer.valueOf( request.getParameter("id")));
		Integer id = Integer.parseInt( request.getParameter("id"));
		
		LibraryItemEntry entry = GetItem(id);
		LibraryItemEntry e1 = GetItem(Integer.valueOf( request.getParameter( "id" )));
		//System.out.print(e1.getId());
		//System.out.print(e1.getName());
		
		//LibraryItemEntry subentries = Subtem(Integer.valueOf(request.getParameter("id")));
		//LibraryItemEntry 
	
		
		request.setAttribute( "entry", entry );

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

		request.setAttribute( "subentries", subentries );
		request.getRequestDispatcher("/WEB-INF/ViewItem.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}