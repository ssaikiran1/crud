package sai;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/Trainservlet")
public class Trainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Trainservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		try {		
			Stations st=new Stations();
			st.connections();
			ArrayList<Train> dt=st.fromto();
			
			JSONArray ja =new JSONArray();
			
			for ( Train s:dt) {
				JSONObject ob=new JSONObject();
				ob.put("data", s.getFrom());
				ja.put(ob);
			}
			response.getWriter().write(ja.toString());
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

		try {		
			Stations st=new Stations();
			st.connections();
			ArrayList<Train> tt=st.fromto();
			
			JSONArray ja =new JSONArray();
			
			for ( Train s:tt) {
				JSONObject ob=new JSONObject();
				ob.put("data", s.getTo());
				ja.put(ob);
			}
			System.out.println(ja.toString());
			response.getWriter().write(ja.toString());
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	

}
