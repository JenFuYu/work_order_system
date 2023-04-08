package Dao;

import java.util.List;

import Model.schools;

public interface schoolsDao {
	//create
			void add(schools s);
			
			
			//Read
			List<schools> selectAll();
			schools selectId(int Id);
			
			//udpate
			void update(schools s);
			
			//delete
			void delete(int Id);
}
