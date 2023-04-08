package Dao;

import java.util.List;

import Model.order_type;
import Model.users;

public interface order_type_dao {
			//create
			void add(order_type ot);

			//Read
			List<order_type> selectAll();
			order_type selectId(int Id);
			
			//udpate
			void update(order_type ot);
			
			//delete
			void delete(int Id);
}
