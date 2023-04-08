package Dao;

import java.util.List;

import Model.users;

public interface usersDao {
			//create
			void add(users s);
			
			
			//Read
			List<users> selectAll();
			users selectId(int Id);
			boolean querycustomer(String email,String password);//確認帳號存在與否
			users querymember(String email, String password);//取得帳號身分資料
			List<users> querypermission_id2();//取得總務帳號
			public boolean queryemail(String email);//確認email是否重複 
			List<users> querymember(String email, String user_name,String cell_phone);//帳號管理頁搜索
			users query_sel_email(String email);//用email找帳號資料
			
			//udpate
			void update(users s);
			
			//delete
			void delete(int Id);
}
