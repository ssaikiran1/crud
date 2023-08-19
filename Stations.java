package sai;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stations {
	ResultSet rs;
	public void connections() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training","plf_training_admin","pff123");
		Statement s=cn.createStatement();
		rs=s.executeQuery("select  trn_start,trn_end from sai_tdata");
		
	}
	
	 public ArrayList<Train> fromto() throws SQLException{
		 ArrayList<Train> al=new ArrayList<>();
		
		 while(rs.next()) {
		 String from=rs.getString(1);
		 String to=rs.getString(2);
		 al.add(new Train(from,to));
		
		 }
		 
		 return al;
	 }
	public ArrayList<Searchtrain> conn(String from,String to) throws ClassNotFoundException, SQLException {
		System.out.println("nnnnnnnnnn"+from);
		System.out.println("kkkk"+to);
		Class.forName("org.postgresql.Driver");
		Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training","plf_training_admin","pff123");
		PreparedStatement ps=cn.prepareStatement("select * from sai_tdata where trn_start=? and trn_end=?");
		ps.setString(1, from);
		ps.setString(2, to);
		ArrayList<Searchtrain> ta=new ArrayList<>();
		rs=ps.executeQuery();
		System.out.println("hiiiiiiiiiiii");
		while(rs.next()) {
			ta.add(new Searchtrain(rs.getString(2)));
			System.out.println(ta);
					}
		
		return ta;
		
	}

}
