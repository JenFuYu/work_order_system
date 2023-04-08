package Controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import server.re_directed;
import server.show;
import javax.swing.JTextField;

public class account_management extends JFrame {

	private JPanel contentPane;
	public static account_management am_frame = null;
	private JTable table;
	private JTextField search_textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//wos_frame = new work_order_schedule(user_id,p1);
					am_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public account_management(int user_id,permission_set p1) {
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {	//視窗啟動時執行
                do_this_windowActivated(e);
            }
        });
		
		users u1 = new implUsers().selectId(user_id);
		int sch_id = u1.getSchool();//取得使用者所屬分校
		work_order wo = new work_order();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

			JLabel lblNewLabel = new JLabel("帳號管理");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 45));
			lblNewLabel.setBounds(319, 10, 283, 102);
			contentPane.add(lblNewLabel);

		
		if(p1.getSub_function() == 1) {
			JButton New_workorder_Button = new JButton("新增工單");
			New_workorder_Button.setBounds(10, 120, 120, 40);
			contentPane.add(New_workorder_Button);
			
			New_workorder_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_new_work_order(user_id,p1);
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
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
					am_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		if(p1.getAccount_mana_function()==1) {
			JButton account_mana_Button = new JButton("人員帳號管理");
			account_mana_Button.setBounds(10, 470, 120, 40);
			contentPane.add(account_mana_Button);
			
		}
		
		if(p1.getPermission_function()==1) {
			JButton permission_Button = new JButton("級別權限管理");
			permission_Button.setBounds(10, 520, 120, 40);
			contentPane.add(permission_Button);
			permission_Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new re_directed().change_authority_management(user_id,p1);
					am_frame.setVisible(false);
	        		dispose();
				}
			});
		}
		
		
		/*JTextArea textArea = new JTextArea();
		textArea.setBounds(140, 170, 634, 317);
		contentPane.add(textArea);*/
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(140, 135, 634, 366);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();		//新增JScrollPane
		panel.add(scrollPane, BorderLayout.CENTER);		//用center讓JScrollPane跟panel同大小
		table = new JTable();							//新增欄位table
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("微軟雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微軟雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
		

		
		JButton check_Button = new JButton("帳號修改");
		check_Button.setBounds(654, 511, 120, 40);
		contentPane.add(check_Button);
		
		JButton create_Button = new JButton("新增帳號");
		
		create_Button.setBounds(506, 511, 120, 40);
		contentPane.add(create_Button);
		
		search_textField = new JTextField();
		search_textField.setBounds(140, 104, 262, 21);
		contentPane.add(search_textField);
		search_textField.setColumns(10);
		
		JButton search_Button = new JButton("搜索");
		
		search_Button.setBounds(412, 102, 87, 23);
		contentPane.add(search_Button);
		
		//執行搜索輸入字串
		search_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sea = search_textField.getText();
				search_windowActivated(sea,sea,sea);
			}
		});
		
		/*
		前往history_work_order2
		*/
		check_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*users wo2=null;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        int index = table.getSelectedRow();
		        List<users> l1 = new implUsers().selectAll();
		        for(int n =0; n <= index;n++) {
		        	wo2 = l1.get(index);
		        }*/
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();	//選取的列數
				String sel_user_ema = (String)table.getValueAt(row, 0); //取得選取的帳號資料
				users wo2=new implUsers().query_sel_email(sel_user_ema);
				
		        account_management2.am2_frame = new account_management2(user_id,p1,wo2);
		        am_frame.setVisible(false);
		        account_management2.am2_frame.setVisible(true);
        		dispose();
			}
		});
		
		//新增帳號
		create_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				users wo2=null;
				account_management3.am3_frame = new account_management3(user_id,p1,wo2);
		        am_frame.setVisible(false);
		        account_management3.am3_frame.setVisible(true);
        		dispose();
			}
		});
		
	}
    
    protected void do_this_windowActivated(WindowEvent e) {
    	List<users> l1 = new implUsers().selectAll();		//取得已驗收資料
		
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "帳號", "姓名", "分校", "權限"});		//設計table
        
        for(users o:l1) {
			permission_set ps = new implPermission_set().selectId(o.getPermission_id());
			schools s1 = new implSchools().selectId(o.getSchool());
			
			model.addRow(new Object[] { o.getEmail(), o.getUser_name(), s1.getSchool_name(), ps.getPosition_name()});
		}
        table.setModel(model);
    }
    
    protected void search_windowActivated(String email,String user_name,String cell_phone) {
    	List<users> l1 = new implUsers().querymember(email,user_name,cell_phone);		//取得已驗收資料
		
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "帳號", "姓名", "分校", "權限"});		//設計table
        System.out.println(l1);
        for(users o:l1) {
			permission_set ps = new implPermission_set().selectId(o.getPermission_id());
			schools s1 = new implSchools().selectId(o.getSchool());
			
			model.addRow(new Object[] { o.getEmail(), o.getUser_name(), s1.getSchool_name(), ps.getPosition_name()});
			//System.out.println(o);
		}
        table.setModel(model);
    }
}
