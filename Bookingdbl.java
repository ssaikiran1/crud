package sai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bookingdbl {
	public void addpassengers(ArrayList<Passenger> al,int pnrno) throws ClassNotFoundException, SQLException {
	Class.forName("org.postgresql.Driver");
	Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training\",\"plf_training_admin\",\"pff123");
	PreparedStatement ps=cn.prepareStatement("insert into sai_tpassengers ?,?,?,?,?");
	for(Passenger p:al) {
	ps.setInt(1, pnrno);
	ps.setString(2,p.getName());
	ps.setString(3,p.getGender());
	ps.setInt(4,p.getAge());
	ps.addBatch();
	}
	ps.executeBatch();
	System.out.println("query updated with"+ps.executeBatch());
	cn.close();
}
}
