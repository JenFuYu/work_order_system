package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.order_type;
import Model.permission_set;

public class implPermission_set implements permission_setDao{

	public static void main(String[] args) {
		//System.out.print(DBconnection.getDB());
		/*permission_set p = new permission_set("總務人員",1,1,1,1,0,0,0,0);
		new implPermission_set().add(p);*/
		//System.out.print(new implPermission_set().selectAll());
		/*permission_set p = new implPermission_set().selectId(2);
		p.setHistory_function(0);
		new implPermission_set().update(p);*/
	}
	
	/*新增使用者權限種類
	 * 輸入:權限類型名稱(type_name)、各頁面開放與否(0不可見,1可見)
	 *  */
	@Override
	public void add(permission_set p) {
		Connection conn =DBconnection.getDB();
		String SQL = "insert into permission_set(position_name,sub_function,schedule_function,assign_function,affairs_function,"
				+ "inspect_function,history_function,account_mana_function,permission_function,report_function)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getPosition_name());
			ps.setInt(2, p.getSub_function());
			ps.setInt(3, p.getSchedule_function());
			ps.setInt(4, p.getAssign_function());
			ps.setInt(5, p.getAffairs_function());
			ps.setInt(6, p.getInspect_function());
			ps.setInt(7, p.getHistory_function());
			ps.setInt(8, p.getAccount_mana_function());
			ps.setInt(9, p.getPermission_function());
			ps.setInt(10, p.getReport_function());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*搜索全部權限
	 *  */
	@Override
	public List<permission_set> selectAll() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from permission_set";
		//String SQL = "select * from order_type where fake = 0";
		List<permission_set> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				permission_set p1 = new permission_set();
				p1.setId(rs.getInt("id"));
				p1.setPosition_name(rs.getString("position_name"));
				p1.setSub_function(rs.getInt("sub_function"));
				p1.setSchedule_function(rs.getInt("schedule_function"));
				p1.setAssign_function(rs.getInt("assign_function"));
				p1.setAffairs_function(rs.getInt("affairs_function"));
				p1.setInspect_function(rs.getInt("inspect_function"));
				p1.setHistory_function(rs.getInt("history_function"));
				p1.setAccount_mana_function(rs.getInt("account_mana_function"));
				p1.setPermission_function(rs.getInt("permission_function"));
				p1.setReport_function(rs.getInt("report_function"));		
				
				l1.add(p1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	/*搜索所屬權限
	 * 輸入: 使用者user_id
	 * 作用: 返回各頁面顯示與否
	 *  */
	@Override
	public permission_set selectId(int Id) {
		Connection conn =DBconnection.getDB();
		
		String SQL = "select * from permission_set where id = ?";
		permission_set p1 = null;					//因為搜id只會有一筆，所以不用list
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				p1=new permission_set();
				p1.setId(rs.getInt("id"));
				p1.setPosition_name(rs.getString("position_name"));
				p1.setSub_function(rs.getInt("sub_function"));
				p1.setSchedule_function(rs.getInt("schedule_function"));
				p1.setAssign_function(rs.getInt("assign_function"));
				p1.setAffairs_function(rs.getInt("affairs_function"));
				p1.setInspect_function(rs.getInt("inspect_function"));
				p1.setHistory_function(rs.getInt("history_function"));
				p1.setAccount_mana_function(rs.getInt("account_mana_function"));
				p1.setPermission_function(rs.getInt("permission_function"));
				p1.setReport_function(rs.getInt("report_function"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p1;
	}
	
	/*變更權限對應(開放、遮蔽頁面)
	 * 輸入: 權限類別、權限變更新對應
	 * 作用: 變更權限
	 *  */
	@Override
	public void update(permission_set p) {
		Connection conn =DBconnection.getDB();
		String SQL = "update permission_set set position_name = ?,sub_function = ?,schedule_function = ?,assign_function = ?,affairs_function = ?,inspect_function = ?,history_function = ?,account_mana_function = ?,permission_function = ?,report_function = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getPosition_name());
			ps.setInt(2, p.getSub_function());
			ps.setInt(3, p.getSchedule_function());
			ps.setInt(4, p.getAssign_function());
			ps.setInt(5, p.getAffairs_function());
			ps.setInt(6, p.getInspect_function());
			ps.setInt(7, p.getHistory_function());
			ps.setInt(8, p.getAccount_mana_function());
			ps.setInt(9, p.getPermission_function());
			ps.setInt(10, p.getReport_function());
			ps.setInt(11, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*刪除權限
	 * 輸入: 權限類別id
	 * 作用: 刪除權限
	 *  */
	@Override
	public void delete(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "delete from permission_set where id = ?";
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
