package server;

import java.util.List;

import Controller.account_management;
import Controller.affairs_work_order;
import Controller.assign_work_order;
import Controller.authority_management;
import Controller.history_work_order;
import Controller.index;
import Controller.inspect_work_order;
import Controller.new_work_order;
import Controller.report;
import Controller.work_order_schedule;
import Dao.implOrder_type;
import Dao.implUsers;
import Dao.implWork_order;
import Model.order_type;
import Model.permission_set;
import Model.users;
import Model.work_order;

public class re_directed {
	//統一管理左側排跳頁
	public void change_new_work_order(int user_id,permission_set p1){
		new_work_order.nwo_frame = new new_work_order(user_id,p1);
		new_work_order.nwo_frame.setVisible(true);
	}
	
	public void change_work_order_schedule(int user_id,permission_set p1){
		work_order_schedule.wos_frame = new work_order_schedule(user_id,p1);
		work_order_schedule.wos_frame.setVisible(true);
	}
	
	public void change_inspect_work_order(int user_id,permission_set p1){
		inspect_work_order.iwo_frame = new inspect_work_order(user_id,p1);
		inspect_work_order.iwo_frame.setVisible(true);
	}
	
	public void change_affairs_work_order(int user_id,permission_set p1){
		affairs_work_order.afwo_frame = new affairs_work_order(user_id,p1);
		affairs_work_order.afwo_frame.setVisible(true);
	}
	
	public void change_history_work_order(int user_id,permission_set p1){
		history_work_order.hwo_frame = new history_work_order(user_id,p1);
		history_work_order.hwo_frame.setVisible(true);
	}
	
	public void change_report(int user_id,permission_set p1){
		report.reo_frame = new report(user_id,p1);
		report.reo_frame.setVisible(true);
	}
	
	public void change_assign_work_order(int user_id,permission_set p1){
		assign_work_order.awo_frame = new assign_work_order(user_id,p1);
		assign_work_order.awo_frame.setVisible(true);
	}
	
	public void change_account_management(int user_id,permission_set p1){
		account_management.am_frame = new account_management(user_id,p1);
		account_management.am_frame.setVisible(true);
	}
	
	public void change_authority_management(int user_id,permission_set p1){
		authority_management.aum_frame = new authority_management(user_id,p1);
		authority_management.aum_frame.setVisible(true);
	}
	
	public void change_index(){
		index.frame = new index();
		index.frame.setVisible(true);
	}
	
	


}
