package Dao;

import java.util.List;


import Model.work_order;

public interface work_orderDao {
	//create
			void add(work_order wo);
			
			
			//Read
			List<work_order> selectAll();
			work_order selectId(int Id);
			List<work_order> select_unassign();		//未指派
			List<work_order> select_assign();		//已指派
			List<work_order> select_assign(int id);		//已指派，分人
			List<work_order> select_uninspect();	//已完成未驗收
			List<work_order> select_inspect();		//已驗收
			List<work_order> select_workorder(int school_id,int order_type_id,String content);		//搜索歷史清單

			
			//udpate
			void update(work_order wo);
			void update_assign(work_order wo);		//更新:已指派
			void update_affairs(work_order wo);		//更新:已完成未驗收
			
			//delete
			void delete(int Id);
}
