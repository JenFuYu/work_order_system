package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.order_type;
import Model.schools;

public class implSchools implements schoolsDao{

	public static void main(String[] args) {
		//System.out.print(DBconnection.getDB());
		/*schools p = new schools("台北大安校","0920123456","2023-02-13 14:21:00",0);
		new implSchools().add(p);*/
		//System.out.print(new implSchools().selectAll());
		/*schools p = new implSchools().selectId(2);
		p.setPhone("0930123456");
		new implSchools().update(p);*/

	}

	@Override
	public void add(schools s) {
		Connection conn =DBconnection.getDB();
		String SQL = "insert into schools(school_name,phone,created_at,fake)"
				+ "values(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, s.getSchool_name());
			ps.setString(2, s.getPhone());
			ps.setString(3, s.getCreated_at());
			ps.setInt(4, s.getFake());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<schools> selectAll() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from schools";
		List<schools> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				schools o1 = new schools();
				o1.setId(rs.getInt("id"));
				o1.setSchool_name(rs.getString("school_name"));
				o1.setPhone(rs.getString("phone"));
				o1.setCreated_at(rs.getString("created_at"));
				o1.setUpdated_at(rs.getString("updated_at"));
				
				l1.add(o1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	@Override
	public schools selectId(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from schools where id = ?";
		schools s1 = null;					//因為搜id只會有一筆，所以不用list
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				s1=new schools();
				s1.setId(rs.getInt("id"));
				s1.setSchool_name(rs.getString("school_name"));
				s1.setPhone(rs.getString("phone"));
				s1.setCreated_at(rs.getString("created_at"));
				s1.setUpdated_at(rs.getString("updated_at"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s1;
	}

	@Override
	public void update(schools s) {
		Connection conn =DBconnection.getDB();
		String SQL = "update schools set school_name = ?,phone = ?,updated_at = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, s.getSchool_name());
			ps.setString(2, s.getPhone());
			ps.setString(3, s.getUpdated_at());
			ps.setInt(4, s.getId());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "delete from schools where id = ?";		
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, Id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
