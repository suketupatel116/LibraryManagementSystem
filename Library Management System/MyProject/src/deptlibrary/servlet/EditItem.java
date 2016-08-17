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

import deptlibrary.model.LibraryItemEntry;

@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditItem() {
        super();
    }
    

    
    @SuppressWarnings("unchecked")
	private LibraryItemEntry getEntry(Integer id) throws ServletException{
    	
    	/*List<LibraryItemEntry> entries = (List<LibraryItemEntry>) getServletContext().getAttribute("entries");
    	
    	for(LibraryItemEntry entry : entries)
    		if(entry.getId().equals(id))return entry;
    	
    	return null;*/
    	
    	 LibraryItemEntry entry = null;
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
                 entry = new LibraryItemEntry( rs.getInt( "id" ),
                     rs.getString( "type" ), rs.getString( "name" ), rs.getString("info"), rs.getString("available"),
                     rs.getInt("number"), rs.getString("dbb"));
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

         return entry;
    }
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Integer id = Integer.valueOf(request.getParameter("id"));
		LibraryItemEntry entry = getEntry(id);
		
		request.setAttribute("entry", entry);
		
		List<LibraryItemEntry> e = new ArrayList<LibraryItemEntry>();
		
		  try
	        {
	            String url = "jdbc:mysql://localhost/cs320stu55";
	            String username = "cs320stu55";
	            String password = "root";

	            Connection c1 = DriverManager
	                .getConnection( url, username, password );
	            Statement stmt = c1.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from types" );

	            while( rs.next() )
	            {
	            	LibraryItemEntry entry1 = new LibraryItemEntry( 
	            	rs.getInt("id"), rs.getString( "type" ));
	            	
	            	e.add(entry1);
	            }

	            c1.close();
	        }
	        catch( SQLException ex )
	        {
	            throw new ServletException( ex );
	        }

		request.setAttribute("e", e);

		request.getRequestDispatcher("/WEB-INF/EditItem.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		//String available = request.getParameter("available");
		//int index = Integer.parseInt(request.getParameter("index"));
			
	/*	List<LibraryItemEntry> entries = (List<LibraryItemEntry>)getServletContext().getAttribute("entries");
		
		LibraryItemEntry entry = getEntry(id);
	
		entry.setType(type);
		entry.setName(name);
		entry.setInfo(info);
		*/
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/cs320stu55";
            String username = "cs320stu55";
            String password = "root";

            String sql = "update library set type = ?, name = ?, info = ? where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, type);
            pstmt.setString( 2, name);
            pstmt.setString( 3, info);
            pstmt.setInt(4, id);
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