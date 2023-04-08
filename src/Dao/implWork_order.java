package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.order_type;
import Model.permission_set;
import Model.work_order;

public class implWork_order implements work_orderDao{
	static String workorder;
	public static void main(String[] args) {
		//System.out.print(DBconnection.getDB());
		/*work_order p = new work_order(2,1,"2023-02-13 16:2018:00",1,"廁所馬桶不通",0);
		new implWork_order().add(p);*/
		//System.out.print(new implWork_order().selectAll());
		/*work_order p = new implWork_order().selectId(2);
		p.setSubmitter_id(2);
		new implWork_order().update(p);*/
		List<work_order> p = new implWork_order().select_unassign();
		for(work_order o:p) {
			workorder = workorder +o+"\n";

		}
		System.out.print(workorder);
	}

	@Override
	public void add(work_order wo) {
		Connection conn =DBconnection.getDB();
		String SQL = "insert into work_order(school_id,submitter_id,created_at,order_type_id,content,fake)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, wo.getSchool_id());
			ps.setInt(2, wo.getSubmitter_id());
			ps.setString(3, wo.getCreated_at());
			ps.setInt(4, wo.getOrder_type_id());
			ps.setString(5, wo.getContent());
			ps.setInt(6, wo.getFake());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<work_order> selectAll() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order";
		//String SQL = "select * from order_type where fake = 0";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));
				wo1.setEnd_time(rs.getString("end_time"));	
				wo1.setRemark(rs.getString("remark"));
				wo1.setInspector_user_id(rs.getInt("inspector_user_id"));
				wo1.setInspector_at(rs.getString("inspector_at"));
				wo1.setDelete_user_id(rs.getInt("delete_user_id"));
				wo1.setDeleted_at(rs.getString("deleted_at"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	@Override
	public work_order selectId(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where id = ?";
		work_order wo1 = null;					//因為搜id只會有一筆，所以不用list
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				wo1=new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));
				wo1.setEnd_time(rs.getString("end_time"));	
				wo1.setRemark(rs.getString("remark"));
				wo1.setInspector_user_id(rs.getInt("inspector_user_id"));
				wo1.setInspector_at(rs.getString("inspector_at"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wo1;
	}

	@Override
	public void update(work_order wo) {
		Connection conn =DBconnection.getDB();
		String SQL = "update work_order set school_id = ?,submitter_id = ?,created_at = ?,order_type_id = ?,content = ?,assignment_id = ?,general_affairs_id = ?,end_time = ?,remark = ?,inspector_user_id = ?,inspector_at = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, wo.getSchool_id());
			ps.setInt(2, wo.getSubmitter_id());
			ps.setString(3, wo.getCreated_at());
			ps.setInt(4, wo.getOrder_type_id());
			ps.setString(5, wo.getContent());
			ps.setInt(6, wo.getAssignment_id());
			ps.setInt(7, wo.getGeneral_affairs_id());
			ps.setString(8, wo.getEnd_time());
			ps.setString(9, wo.getRemark());
			ps.setInt(10, wo.getInspector_user_id());
			ps.setString(11, wo.getInspector_at());
			ps.setInt(12, wo.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int Id) {
		Connection conn =DBconnection.getDB();
		String SQL = "delete from work_order where id = ?";
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
	
	//尋找:未指派
	@Override
	public List<work_order> select_unassign() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where assignment_id is null or assignment_id = 0";
		//String SQL = "select * from work_order";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	//尋找:已指派
	@Override
	public List<work_order> select_assign() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where assignment_id <> '' and assignment_id != 0 and end_time is null";
		//String SQL = "select * from order_type where fake = 0";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}
	//尋找:已指派(分使用者)
	@Override
	public List<work_order> select_assign(int id) {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where assignment_id <> '' and assignment_id != 0 and end_time is null and general_affairs_id = ?";
		//String SQL = "select * from order_type where fake = 0";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	//尋找:已完成未驗收
	@Override
	public List<work_order> select_uninspect() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where end_time <> '' and inspector_user_id is null";
		//String SQL = "select * from order_type where fake = 0";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));
				wo1.setEnd_time(rs.getString("end_time"));	
				wo1.setRemark(rs.getString("remark"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	//尋找:已驗收
	@Override
	public List<work_order> select_inspect() {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where inspector_user_id <> '' ";
		//String SQL = "select * from order_type where fake = 0";
		List<work_order> l1 = new ArrayList();
		
		try {
			PreparedStatement p = conn.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));
				wo1.setEnd_time(rs.getString("end_time"));	
				wo1.setRemark(rs.getString("remark"));
				wo1.setInspector_user_id(rs.getInt("inspector_user_id"));
				wo1.setInspector_at(rs.getString("inspector_at"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}
	
	
	//更新:已指派
	@Override
	public void update_assign(work_order wo) {
		Connection conn =DBconnection.getDB();
		String SQL = "update work_order set school_id = ?,submitter_id = ?,created_at = ?,order_type_id = ?,content = ?,assignment_id = ?,general_affairs_id = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, wo.getSchool_id());
			ps.setInt(2, wo.getSubmitter_id());
			ps.setString(3, wo.getCreated_at());
			ps.setInt(4, wo.getOrder_type_id());
			ps.setString(5, wo.getContent());
			ps.setInt(6, wo.getAssignment_id());
			ps.setInt(7, wo.getGeneral_affairs_id());
			ps.setInt(8, wo.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//更新:已完成未驗收
	@Override
	public void update_affairs(work_order wo) {
		Connection conn =DBconnection.getDB();
		String SQL = "update work_order set school_id = ?,submitter_id = ?,created_at = ?,order_type_id = ?,content = ?,assignment_id = ?,general_affairs_id = ?,end_time = ?,remark = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, wo.getSchool_id());
			ps.setInt(2, wo.getSubmitter_id());
			ps.setString(3, wo.getCreated_at());
			ps.setInt(4, wo.getOrder_type_id());
			ps.setString(5, wo.getContent());
			ps.setInt(6, wo.getAssignment_id());
			ps.setInt(7, wo.getGeneral_affairs_id());
			ps.setString(8, wo.getEnd_time());
			ps.setString(9, wo.getRemark());
			ps.setInt(10, wo.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//搜索歷史清單
	@Override
	public List<work_order> select_workorder(int school_id, int order_type_id, String content) {
		Connection conn =DBconnection.getDB();
		String SQL = "select * from work_order where school_id = ? or order_type_id = ? or content like ?";
		List<work_order> l1 = new ArrayList();
		
		
		content = "%"+content+"%";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, school_id);
			ps.setInt(2, order_type_id);
			ps.setString(3, content);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				work_order wo1 = new work_order();
				wo1.setId(rs.getInt("id"));
				wo1.setSchool_id(rs.getInt("school_id"));
				wo1.setSubmitter_id(rs.getInt("submitter_id"));
				wo1.setCreated_at(rs.getString("created_at"));
				wo1.setOrder_type_id(rs.getInt("order_type_id"));
				wo1.setContent(rs.getString("content"));
				wo1.setAssignment_id(rs.getInt("assignment_id"));
				wo1.setGeneral_affairs_id(rs.getInt("general_affairs_id"));
				wo1.setEnd_time(rs.getString("end_time"));	
				wo1.setRemark(rs.getString("remark"));
				wo1.setInspector_user_id(rs.getInt("inspector_user_id"));
				wo1.setInspector_at(rs.getString("inspector_at"));
				wo1.setDelete_user_id(rs.getInt("delete_user_id"));
				wo1.setDeleted_at(rs.getString("deleted_at"));

				l1.add(wo1);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l1;
	}

	

	

}
