package sai;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/Selectservlet")
public class Selectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Selectservlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String from =request.getParameter("from");
			String to=request.getParameter("to");
			System.out.println(from);
			System.out.println(to);
			Stations st=new Stations();
			ArrayList<Searchtrain> aa=st.conn(from,to);
			JSONArray ja=new JSONArray();
			for(Searchtrain s:aa) {
				JSONObject obj=new JSONObject();
				obj.put("tt",s.getTname());
				ja.put(obj);
				
			}
			
			response.getWriter().write(ja.toString());		
			System.out.println("AKSH"+ja.toString());
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	

}
