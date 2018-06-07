package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SalaryMap extends JDialog {
	SalaryMap self = this;
	Deptlist dl = new Deptlist();
	DAOemp dao =new DAOemp();
	
	private String[] columnHeaders = new String[] {
			"부서코드","부서명","총액"  
	};

	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	private JPanel panel = new JPanel(new FlowLayout());
	private JLabel label = new JLabel("검색할 동을 입력하세요 ");
	private JTextField text = new JTextField();
	private JButton endbtn = new JButton("닫기");
	
	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.add(endbtn,BorderLayout.SOUTH);

		try {
			List<Deptlist> info = dao.selectDB();
			int listsize = info.size();
			
			for(int i=0;i<listsize;i++) {
				dtm.addRow(new Object[] {info.get(i).getDeptcode(),
						info.get(i).getDeptname(),info.get(i).getSalary()
						});
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void eventInit() {
		this.endbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
	}
	
	public SalaryMap() {
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		this.setVisible(true);
	}
}
