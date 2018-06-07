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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbo.MemberDBO;
import infos.MemberInfos;

public class AllMemberListName extends JDialog {
	AllMemberListName self = this;
	MemberDBO mdbo = new MemberDBO();

	private String[] columnHeaders = new String[] {
			"INDEX ID","ID","이름","나이","주소","성별","뭔지 모르는것"
	};

	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	private JTextField search = new JTextField();
	private JButton buyBtn = new JButton("검색");
	private JButton endbtn = new JButton("닫기");
	private JPanel pan = new JPanel(new GridLayout());

	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.pan.add(search);
		this.pan.add(buyBtn);
		this.pan.add(endbtn);
		this.add(pan,BorderLayout.SOUTH);

	}

	private void eventInit() {
		this.buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				String name = search.getText();
				try {
					List<MemberInfos> list = mdbo.printNameMemberList(name);
					int linecol = list.size();
					for(int i=0;i<linecol;i++) {
						dtm.addRow(new Object[] {
							 list.get(i).getUNo(),list.get(i).getUID(),
							 list.get(i).getUName(),list.get(i).getUAge(),
							 list.get(i).getAddr(),list.get(i).getGender(),
							 list.get(i).getEnroll_Date()
						});
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		this.endbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
	}

	public AllMemberListName() {
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
