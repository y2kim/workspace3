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
import kh_infos.DeliverInfo;
import kh_infos.ProductInfoList;
import kh_infos.PuacherListInfo;
import service.Service;

public class ProductList extends JDialog {
	ProductList self = this;
	Service svi = Service.getInstance();
	
	private String[] columnHeaders = new String[] {
			"상풍ID","상품명","상품 가격","판매업체"  
	};
	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	
	private JButton buyBtn = new JButton("구입");
	private JButton endbtn = new JButton("닫기");
	private JPanel pan = new JPanel(new GridLayout());
	
	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.pan.add(buyBtn);
		this.pan.add(endbtn);
		this.add(pan,BorderLayout.SOUTH);
		
		try {
			List<ProductInfoList> list = svi.productInfos();
			int linecol = list.size();
			for(int i=0;i<linecol;i++) {
				dtm.addRow(new Object[] {
					list.get(i).getPid(),list.get(i).getPname(),
					list.get(i).getPrice(),list.get(i).getSellId()
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
		this.buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PuacherListInfo pli = new PuacherListInfo();
				DeliverInfo dio = new DeliverInfo();
				int row = table.getSelectedRow();
				int a1 = (int)table.getModel().getValueAt(row, 0);//핵심 1 getPid
				int a2 = (int)table.getModel().getValueAt(row, 2);//핵 머니 getPrice
				String a3 = (String)table.getModel().getValueAt(row, 1);//핵 상품 pname
				String a4 = (String)table.getModel().getValueAt(row, 3);//핵심2 getSellId
				String an = null ;
				try {
					 an = svi.proSeaSels(a4);
				} catch (Exception e1) {
				}
				//int a2 = Integer.parseInt(a1);
				pli.setId("1001");
				pli.setPid(a1);
				pli.setSeller_id(an);
				pli.setPname(a3);
				pli.setPrice(a2);
				//
				dio.setPid(a1);
				dio.setPname(a3);
				dio.setSeller_id(an);
				dio.setBuyer_id("1001");
				try {
					int abc = svi.insertBuyDliver(pli, dio);
					if(abc>0) {
						JOptionPane.showMessageDialog(null, "입력에 성공하였습니다");
					}else {
						System.out.println("실패하였습니다.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	public ProductList() {
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
		this.setVisible(true);
	}
}
