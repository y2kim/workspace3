package exam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kh_dao.CustomerDBMA;
import kh_infos.SellerListInfo;
import service.Service;

public class SellerList extends JDialog {
	SellerList self = this;

	Service svi = Service.getInstance();
	
	private String[] columnHeaders = new String[] {
			"판매자번호","판매업체명"  
	};
	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	
	private JButton endbtn = new JButton("닫기");
	
	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.add(endbtn,BorderLayout.SOUTH);
		System.out.println("!!1");
		try {
			List<SellerListInfo> list = svi.printCousSeller();
			int linecol = list.size();
			for(int i=0;i<linecol;i++) {
				dtm.addRow(new Object[] {
					list.get(i).getId(),list.get(i).getSeq()
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
	
	public SellerList() {
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		this.setVisible(true);
	}
}
