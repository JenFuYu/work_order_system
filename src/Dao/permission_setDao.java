package Dao;

import java.util.List;

import Model.permission_set;


public interface permission_setDao {
		//create
		void add(permission_set p);
		
		
		//Read
		List<permission_set> selectAll();
		permission_set selectId(int Id);
		
		//udpate
		void update(permission_set p);
		
		//delete
		void delete(int Id);

}
