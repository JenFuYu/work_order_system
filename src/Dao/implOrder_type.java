package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.order_type;
import Model.users;



public class implOrder_type implements order_type_dao{

	public static void main(String[] args) {
		//System.out.print(DBconnection.getDB());
		/*order_type p = new order_type("管理人員","2023-02-10 14:44:00",0);
		new implOrder_type().add(p);*/
		//System.out.print(new implOrder_type().selectAll());
		/*order_type p = new implOrder_type().selectId(3);
		p.setType_name("會計");
		new implOrder_type().update(p);*/

	}
	
	/*新增工單類型
	 * 輸入:工單類型名稱(type_name)、新增時間(created_at)、狀態(fake)
	 * 作用:新增工單類型
	 *  */
	@Override
	public void add(order_type ot) {
		Connection conn =DBconnection.getDB();
		String SQL = "insert into order_type(type_name,created_at,fake)"
				+ "values(?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ot.getType_name());
			ps.setString(2, ot.getCreated_at());
			ps.setInt(3, ot.getFake());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*搜索全部工單類型
	 *  */
	@Override
	public List<order_type> selectAll() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from order_type";
		//String SQL = "select * from order_type where fake = 0";
		List<order_type> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				order_type o1 = new order_type();
				o1.setId(rs.getInt("id"));
				o1.setType_name(rs.getString("type_name"));
				
				l1.add(o1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}
	
	@Override
	public order_type selectId(int Id) {
		Connection conn =DBconnection.getDB();
		
		String SQL = "select * from order_type where id = ?";
		order_type p1 = null;					//因為搜id只會有一筆，所以不用list
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p1=new order_type();
				p1.setId(rs.getInt("id"));
				p1.setType_name(rs.getString("type_name"));
				p1.setUpdated_at(rs.getString("updated_at"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p1;
	}
	
	/*變更工單類型名稱
	 *輸入:新的工單類型名稱(type_name)、新增時間(updated_at)*/
	@Override
	public void update(order_type ot) {
		Connection conn =DBconnection.getDB();
		String SQL = "update order_type set type_name = ?,updated_at = ?where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ot.getType_name());
			ps.setString(2, ot.getUpdated_at());
			ps.setInt(3, ot.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/*刪除現有工單類型
	 *輸入:現有工單id(order_type.id)、刪除日期(deleted_at)
	 *動作:刪除現有工單id、變更狀態(fake)、新增刪除日期*/
	@Override
	public void delete(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "delete from order_type where id = ?";
		order_type p1 = null;			
		
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
