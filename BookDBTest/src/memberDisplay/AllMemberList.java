package memberDisplay;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbo.BookDBO;
import dbo.MemberDBO;
import infos.BookInfos;
import infos.MemberInfos;

public class AllMemberList extends JDialog {
	AllMemberList self = this;
	
	MemberDBO mdbo = new MemberDBO();
	
	private String[] columnHeaders = new String[] {
			"INDEX ID","ID","이름","나이","주소","성별","뭔지 모르는것"
	};
	
	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	
	//private JButton buyBtn = new JButton("구입");
	private JButton endbtn = new JButton("닫기");
	private JPanel pan = new JPanel(new GridLayout());
	
	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.pan.add(endbtn);
		this.add(pan,BorderLayout.SOUTH);
		try {
			List<MemberInfos> list = mdbo.printMemberList();
			int linecol = list.size();
			for(int i=0;i<linecol;i++) {
				dtm.addRow(new Object[] {
					 list.get(i).getUNo(),list.get(i).getUID(),
					 list.get(i).getUName(),list.get(i).getUAge(),
					 list.get(i).getAddr(),list.get(i).getGender(),
					 list.get(i).getEnroll_Date()
				});
			}
		} catch (Exception e) {
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
	
	public AllMemberList() {
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
