package deptlibrary.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColoredTdTag extends SimpleTagSupport{
	
	boolean available, overdue;
	
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public ColoredTdTag(){}
	
	@Override
    public void doTag() throws JspException, IOException
	{
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		
	if(available)
	{
		out.println("<td style='background-color: rgb(0,255,0);'>Yes</td>");
	}
	else if(overdue){
		out.println("<td style='background-color: rgb(255,0,0);'>No</td>");

	}
	else{
		out.println("<td style='background-color: rgb(255,255,0);'>No</td>");
		
	}	
			
	}

}
