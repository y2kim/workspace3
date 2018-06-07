package exam;

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

import kh_dao.CustomerDBMA;
import kh_infos.DeliverInfo;

public class DeliverInfoList extends JDialog {
	DeliverInfoList self = this;
	CustomerDBMA cdbma = new CustomerDBMA();
	
	private String[] columnHeaders = new String[] {
			"배송번호","상품번호","상품명","판매자","구매자","구매날짜"
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
			List<DeliverInfo> list = cdbma.selectDeliver();
			int linecol = list.size();
			for(int i=0;i<linecol;i++) {
				dtm.addRow(new Object[] {
					list.get(i).getDelibery_no(),list.get(i).getPid(),
					list.get(i).getPname(),list.get(i).getSeller_id(),
					list.get(i).getBuyer_id(),list.get(i).getPurchase_date()
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
	
	public DeliverInfoList() {
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		this.setVisible(true);
	}
}
