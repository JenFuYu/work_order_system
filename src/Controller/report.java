package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Dao.implOrder_type;
import Dao.implPermission_set;
import Dao.implSchools;
import Dao.implUsers;
import Dao.implWork_order;
import Model.order_type;
import Model.permission_set;
import Model.schools;
import Model.users;
import Model.work_order;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.List;

import server.re_directed;
import server.show;

public class report extends JFrame {

	private JPanel contentPane;
	public static report reo_frame = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					reo_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public report(int user_id,permission_set p1) {
		
		users u1 = new implUsers().selectId(user_id);
		int sch_id = u1.getSchool();//取得使用者所屬分校
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("工單報表");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 45));
			lblNewLabel.setBounds(305, 10, 190, 102);
			contentPane.add(lblNewLabel);

		
		if(p1.getSub_function() == 1) {
			JButton New_workorder_Button = new JButton("新增工單");
			New_workorder_Button.setBounds(10, 120, 120, 40);
			contentPane.add(New_workorder_Button);
			
			New_workorder_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_new_work_order(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getSchedule_function() == 1) {
			JButton workorder_schedule_Button = new JButton("工單進度顯示");
			workorder_schedule_Button.setBounds(10, 170, 120, 40);
			contentPane.add(workorder_schedule_Button);
			workorder_schedule_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_work_order_schedule(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getInspect_function() == 1) {
			JButton workorder_inspect_Button = new JButton("工單驗收");
			workorder_inspect_Button.setBounds(10, 220, 120, 40);
			contentPane.add(workorder_inspect_Button);
			
			workorder_inspect_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_inspect_work_order(user_id,p1);
					reo_frame.setVisible(false);
		    		dispose();
				}
			});
		}
		
		if(p1.getAffairs_function() == 1) {
			JButton workorder_affairs_Button = new JButton("工單完成提交");
			workorder_affairs_Button.setBounds(10, 270, 120, 40);
			contentPane.add(workorder_affairs_Button);
			
			workorder_affairs_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_affairs_work_order(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getHistory_function() == 1) {
			JButton workorder_history_Button = new JButton("歷史工單");
			workorder_history_Button.setBounds(10, 320, 120, 40);
			contentPane.add(workorder_history_Button);
			workorder_history_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_history_work_order(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getReport_function()==1) {
			JButton workorder_report_Button = new JButton("工單報表");
			workorder_report_Button.setBounds(10, 370, 120, 40);
			contentPane.add(workorder_report_Button);
			workorder_report_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_report(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getAssign_function()==1) {
			JButton assign_Button = new JButton("工單指派");
			assign_Button.setBounds(10, 420, 120, 40);
			contentPane.add(assign_Button);
			assign_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_assign_work_order(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getAccount_mana_function()==1) {
			JButton account_mana_Button = new JButton("人員帳號管理");
			account_mana_Button.setBounds(10, 470, 120, 40);
			contentPane.add(account_mana_Button);
			account_mana_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_account_management(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getPermission_function()==1) {
			JButton permission_Button = new JButton("級別權限管理");
			permission_Button.setBounds(10, 520, 120, 40);
			contentPane.add(permission_Button);
			permission_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_authority_management(user_id,p1);
					reo_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 121, 634, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("1. 已完成歷史工單");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 10, 206, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2. 待完成工單");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 55, 206, 35);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("3. 分校員工清單");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 100, 206, 35);
		panel.add(lblNewLabel_1_1_1);
		
		JButton dow_Button1 = new JButton("下載");
		dow_Button1.setBounds(315, 17, 87, 23);
		panel.add(dow_Button1);
		
		JButton dow_Button2 = new JButton("下載");
		dow_Button2.setBounds(315, 62, 87, 23);
		panel.add(dow_Button2);
		
		JButton dow_Button3 = new JButton("下載");
		dow_Button3.setBounds(315, 107, 87, 23);
		panel.add(dow_Button3);
		
		//下載已完成工單
		dow_Button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<work_order> l1 = new implWork_order().select_inspect();
				/** Excel 檔案要存放的位置 */
				String outputFile = "end_work_order.xls";
			    HSSFSheet sheet = null;
			    HSSFWorkbook excelbook=new HSSFWorkbook();
			    // 定義產生Excel表格方法
			    try {
			        sheet = excelbook.createSheet("已完成工單"); // 在索引0的位置建立行（最頂端的行）
			        HSSFRow row = sheet.createRow((short) 0);
			        HSSFCell monadism = row.createCell((short) 0); // 在索引0的位置建立單元格（左上端）
			        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
			        monadism.setCellValue("分校");// 在單元格中輸入一些內容
			        row.createCell((short) 1).setCellValue("工單提交時間"); // 在第一行第二列增加內容
			        row.createCell((short) 2).setCellValue("提交人員");
			        row.createCell((short) 3).setCellValue("工單類型");
			        row.createCell((short) 4).setCellValue("內容");
			        row.createCell((short) 5).setCellValue("指派主管");
			        row.createCell((short) 6).setCellValue("處理人員");
			        row.createCell((short) 7).setCellValue("完成時間");
			        row.createCell((short) 8).setCellValue("備註");
			        row.createCell((short) 9).setCellValue("驗收人員");
			        row.createCell((short) 10).setCellValue("驗收時間");
			        
			        for(work_order o:l1) {
			        	schools s_name = new implSchools().selectId(o.getSchool_id());//分校資料
			        	users u2 = new implUsers().selectId(o.getSubmitter_id());//提交者
			        	users u3 = new implUsers().selectId(o.getAssignment_id());//指派者
			    		users u4 = new implUsers().selectId(o.getGeneral_affairs_id());//處理人員
			    		order_type ot2 = new implOrder_type().selectId(o.getOrder_type_id());//問題類型
			    		users u5 = new implUsers().selectId(o.getInspector_user_id());//驗收人員
			    		
			        	int count = sheet.getPhysicalNumberOfRows(); 		//獲得工作表中總體行數
			        	row = sheet.createRow((short) count);       		//新增一行
			        	row.createCell((short) 0).setCellValue(s_name.getSchool_name());	// 增加內容
			        	row.createCell((short) 1).setCellValue(o.getCreated_at()); 
				        row.createCell((short) 2).setCellValue(u2.getUser_name());
				        row.createCell((short) 3).setCellValue(ot2.getType_name());
				        row.createCell((short) 4).setCellValue(o.getContent());
				        row.createCell((short) 5).setCellValue(u3.getUser_name());
				        row.createCell((short) 6).setCellValue(u4.getUser_name());
				        row.createCell((short) 7).setCellValue(o.getEnd_time());
				        row.createCell((short) 8).setCellValue(o.getRemark());
				        row.createCell((short) 9).setCellValue(u5.getUser_name());
				        row.createCell((short) 10).setCellValue(o.getInspector_at()); 
			        }
			        
			        FileOutputStream out = new FileOutputStream(outputFile); // 新增輸出檔案流
			        excelbook.write(out);// 把對應的Excel工作簿存碟
			        out.flush();
			        out.close(); // 操作結束，關閉檔案
			        
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			}
		});
		
		//下載未完成工單
		dow_Button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<work_order> l1 = new implWork_order().select_unassign();	//未指派
				List<work_order> l2 = new implWork_order().select_assign();		//已指派
				List<work_order> l3 = new implWork_order().select_uninspect();	//未驗收

				/** Excel 檔案要存放的位置 */
				String outputFile = "undone_work_order.xls";
			    HSSFSheet sheet = null;
			    HSSFWorkbook excelbook=new HSSFWorkbook();
			    // 定義產生Excel表格方法
			    try {
			        sheet = excelbook.createSheet("未完成工單"); // 在索引0的位置建立行（最頂端的行）
			        HSSFRow row = sheet.createRow((short) 0);
			        HSSFCell monadism = row.createCell((short) 0); // 在索引0的位置建立單元格（左上端）
			        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
			        monadism.setCellValue("分校");// 在單元格中輸入一些內容
			        row.createCell((short) 1).setCellValue("工單提交時間"); // 在第一行第二列增加內容
			        row.createCell((short) 2).setCellValue("提交人員");
			        row.createCell((short) 3).setCellValue("工單類型");
			        row.createCell((short) 4).setCellValue("內容");
			        row.createCell((short) 5).setCellValue("指派主管");
			        row.createCell((short) 6).setCellValue("處理人員");
			        row.createCell((short) 7).setCellValue("完成時間");
			        row.createCell((short) 8).setCellValue("備註");
			        row.createCell((short) 9).setCellValue("驗收人員");
			        row.createCell((short) 10).setCellValue("驗收時間");
			        
			        for(work_order o:l1) {
			        	schools s_name = new implSchools().selectId(o.getSchool_id());//分校資料
			        	users u2 = new implUsers().selectId(o.getSubmitter_id());//提交者
			    		order_type ot2 = new implOrder_type().selectId(o.getOrder_type_id());//問題類型

			    		
			        	int count = sheet.getPhysicalNumberOfRows(); 		//獲得工作表中總體行數
			        	row = sheet.createRow((short) count);       		//新增一行
			        	row.createCell((short) 0).setCellValue(s_name.getSchool_name());	// 增加內容
			        	row.createCell((short) 1).setCellValue(o.getCreated_at()); 
				        row.createCell((short) 2).setCellValue(u2.getUser_name());
				        row.createCell((short) 3).setCellValue(ot2.getType_name());
				        row.createCell((short) 4).setCellValue(o.getContent());
			        }
			        
			        for(work_order o:l2) {
			        	schools s_name = new implSchools().selectId(o.getSchool_id());//分校資料
			        	users u2 = new implUsers().selectId(o.getSubmitter_id());//提交者
			        	users u3 = new implUsers().selectId(o.getAssignment_id());//指派者
			    		users u4 = new implUsers().selectId(o.getGeneral_affairs_id());//處理人員
			    		order_type ot2 = new implOrder_type().selectId(o.getOrder_type_id());//問題類型

			    		
			        	int count = sheet.getPhysicalNumberOfRows(); 		//獲得工作表中總體行數
			        	row = sheet.createRow((short) count);       		//新增一行
			        	row.createCell((short) 0).setCellValue(s_name.getSchool_name());	// 增加內容
			        	row.createCell((short) 1).setCellValue(o.getCreated_at()); 
				        row.createCell((short) 2).setCellValue(u2.getUser_name());
				        row.createCell((short) 3).setCellValue(ot2.getType_name());
				        row.createCell((short) 4).setCellValue(o.getContent());
				        row.createCell((short) 5).setCellValue(u3.getUser_name());
				        row.createCell((short) 6).setCellValue(u4.getUser_name());

			        }
			        
			        for(work_order o:l3) {
			        	schools s_name = new implSchools().selectId(o.getSchool_id());//分校資料
			        	users u2 = new implUsers().selectId(o.getSubmitter_id());//提交者
			        	users u3 = new implUsers().selectId(o.getAssignment_id());//指派者
			    		users u4 = new implUsers().selectId(o.getGeneral_affairs_id());//處理人員
			    		order_type ot2 = new implOrder_type().selectId(o.getOrder_type_id());//問題類型

			    		
			        	int count = sheet.getPhysicalNumberOfRows(); 		//獲得工作表中總體行數
			        	row = sheet.createRow((short) count);       		//新增一行
			        	row.createCell((short) 0).setCellValue(s_name.getSchool_name());	// 增加內容
			        	row.createCell((short) 1).setCellValue(o.getCreated_at()); 
				        row.createCell((short) 2).setCellValue(u2.getUser_name());
				        row.createCell((short) 3).setCellValue(ot2.getType_name());
				        row.createCell((short) 4).setCellValue(o.getContent());
				        row.createCell((short) 5).setCellValue(u3.getUser_name());
				        row.createCell((short) 6).setCellValue(u4.getUser_name());
				        row.createCell((short) 7).setCellValue(o.getEnd_time());
				        row.createCell((short) 8).setCellValue(o.getRemark());

			        }
			        
			        FileOutputStream out = new FileOutputStream(outputFile); // 新增輸出檔案流
			        excelbook.write(out);// 把對應的Excel工作簿存碟
			        out.flush();
			        out.close(); // 操作結束，關閉檔案
			        
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			}
		});
		
		//下載員工資料
		dow_Button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<users> l1 = new implUsers().selectAll();
				/** Excel 檔案要存放的位置 */
				String outputFile = "employee list.xls";
			    HSSFSheet sheet = null;
			    HSSFWorkbook excelbook=new HSSFWorkbook();
			    // 定義產生Excel表格方法
			    try {
			        sheet = excelbook.createSheet("員工清單"); // 在索引0的位置建立行（最頂端的行）
			        HSSFRow row = sheet.createRow((short) 0);
			        HSSFCell monadism = row.createCell((short) 0); // 在索引0的位置建立單元格（左上端）
			        monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
			        monadism.setCellValue("分校");// 在單元格中輸入一些內容
			        row.createCell((short) 1).setCellValue("姓名"); // 在第一行第二列增加內容
			        row.createCell((short) 2).setCellValue("英文姓名");
			        row.createCell((short) 3).setCellValue("郵箱");
			        row.createCell((short) 4).setCellValue("性別");
			        row.createCell((short) 5).setCellValue("生日");
			        row.createCell((short) 6).setCellValue("電話");
			        row.createCell((short) 7).setCellValue("權限");
			        row.createCell((short) 8).setCellValue("註冊日期");

			        
			        for(users o:l1) {
			        	schools s_name = new implSchools().selectId(o.getSchool());//分校資料
			        	permission_set ps = new implPermission_set().selectId(o.getPermission_id());
			        	String gen = null;
			        	if(o.getGender()==1) {
			        		gen = "男性";
			        	}else if(o.getGender()==2) {
			        		gen = "女性";
			        	}else {
			        		gen = "不明";
			        	}
			    		
			        	int count = sheet.getPhysicalNumberOfRows(); 		//獲得工作表中總體行數
			        	row = sheet.createRow((short) count);       		//新增一行
			        	row.createCell((short) 0).setCellValue(s_name.getSchool_name());	// 增加內容
			        	row.createCell((short) 1).setCellValue(o.getUser_name()); 
				        row.createCell((short) 2).setCellValue(o.getEnglish_name());
				        row.createCell((short) 3).setCellValue(o.getEmail());
				        row.createCell((short) 4).setCellValue(gen);
				        row.createCell((short) 5).setCellValue(o.getBirth_date());
				        row.createCell((short) 6).setCellValue(o.getCell_phone());
				        row.createCell((short) 7).setCellValue(ps.getPosition_name());
				        row.createCell((short) 8).setCellValue(o.getCreated_at());
			        }
			        
			        FileOutputStream out = new FileOutputStream(outputFile); // 新增輸出檔案流
			        excelbook.write(out);// 把對應的Excel工作簿存碟
			        out.flush();
			        out.close(); // 操作結束，關閉檔案
			        
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			}
		});
		
	}

}
