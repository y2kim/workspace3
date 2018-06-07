package exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kh_dao.CustomerDBMA;
import kh_infos.PuacherListInfo;

public class BuyInfoList extends JDialog {
	BuyInfoList self = this;
	CustomerDBMA cdbma = new CustomerDBMA();
	private String[] columnHeaders = new String[] {
			"구매번호","구매자","상품 ID","판매제품","가격","판매자"
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
		//this.pan.add(buyBtn);
		this.pan.add(endbtn);
		this.add(pan,BorderLayout.SOUTH);
		try {
			List<PuacherListInfo> list = cdbma.selectPurcherList();
			int linecol = list.size();
			for(int i=0;i<linecol;i++) {
				dtm.addRow(new Object[] {
					list.get(i).getPurchase_no(),list.get(i).getId()
					,list.get(i).getPid(),list.get(i).getPname()
					,list.get(i).getPrice(),list.get(i).getSeller_id()
	
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
//		this.buyBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DeliverInfo dio = new DeliverInfo();
//				int row = table.getSelectedRow();
//				int a1 = (int)table.getModel().getValueAt(row, 0);//핵심 getPurchase_no
//				String a2 = (String)table.getModel().getValueAt(row, 1);//핵심getId
//				int a3 = (int)table.getModel().getValueAt(row, 2);//핵심 getPid
//				String a4 = (String)table.getModel().getValueAt(row, 3);//핵심 getPname
//				int a5 = (int)table.getModel().getValueAt(row, 4);//핵심 getPrice
//				String a6 = (String)table.getModel().getValueAt(row, 5);//핵심 getSeller_id
//				dio.setPid(a3);
//				dio.setPname(a4);
//				dio.setSeller_id(a6);
//				dio.setBuyer_id("1001");
//				try {
//					int abc = cdbma.insertDliverInfo(dio);
//					if(abc>0) {
//						JOptionPane.showMessageDialog(null, "입력에 성공하였습니다");
//					}else {
//						System.out.println("실패하였습니다.");
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}	
//		});
	}
	public BuyInfoList() {
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		this.setVisible(true);
	}
}
