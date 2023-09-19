   

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registraion
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Registration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("userName");  
		String p=request.getParameter("userPass");  
		String e=request.getParameter("userEmail");  
		String c=request.getParameter("userCountry");  
		 if (n!="" && p!="" && e!="") {
			 try{  
	
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","reiter");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into registeruser values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		
		              
		int i=ps.executeUpdate(); 
		if(i>0)  
		   out.print("<center>You are successfully registered " + n + "</center>");  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}
		 }
		 else
			 out.print("please fill all the detials");
	
		          
		out.close();
	}

}
