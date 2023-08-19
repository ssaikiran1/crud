package sai;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bookingservlet")
public class Bookingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     int pnrno=100; 
 
    public Bookingservlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bookingdbl bd=new Bookingdbl();
		ArrayList<Passenger> al= new ArrayList<>();
		String name[];
		String gender[];
		int age[];
		for (int i=0;i<request.getContentLength();i++) {
			String x=request.getParameter();
			name[i]=x;
		}
		
		
		
		
		
		
	}

	
}
