package adr;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
	private Main self = this;
	DBManager dba = new DBManager();
	List<AddrInfo> infos = new ArrayList<>();
	private String[] columnHeaders = new String[] {
			"우편번호","시/도","구/군","동","리","번지"  
	};

	private DefaultTableModel dtm = new DefaultTableModel(columnHeaders,0);
	private JTable table = new JTable(dtm);
	private JScrollPane paneTable = new JScrollPane(table);
	private JPanel panel = new JPanel(new FlowLayout());
	private JLabel label = new JLabel("검색할 동을 입력하세요 ");
	private JTextField text = new JTextField();
	
	private void compInit() {
		this.add(paneTable);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.getTableHeader().setResizingAllowed(false);
		this.panel.add(label);
		this.panel.add(text);
		this.text.setPreferredSize(new Dimension(150, 25));
		this.add(panel,BorderLayout.SOUTH);
	}
	private void eventInit() {
		// TODO Auto-generated method stub
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dtm.setRowCount(0);
				String textfi = text.getText();
				System.out.println("엔터?");
				try {
					List<AddrInfo> infos = dba.selectDB(textfi);
					int listlength = infos.size();
					System.out.println("1차");
//					for(AddrInfo adr:infos) {
//						dtm.addRow(new Object[] {adr.getZipcode(),adr.getSido(),adr.getGugun()
//						,adr.getDong(),adr.getRi(),adr.getBunji()});
//					}
					try {
						for(int i=0;i<listlength;i++) {
							dtm.addRow(new Object[] {infos.get(i).getZipcode(),
									infos.get(i).getSido(),infos.get(i).getGugun()
									,infos.get(i).getDong(),infos.get(i).getRi(),infos.get(i).getBunji()});
							System.out.println(infos.get(i));
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public Main() {
		this.setSize(600,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new Main();

		//DBManager dba = new DBManager();
		//Scanner sc = new Scanner(System.in);
		//System.out.println("검색할 동 : ");
		//String name = sc.nextLine();

//		try {
//			List<AddrInfo> infos = dba.selectDB(name);
//			for(AddrInfo adr:infos) {
//				System.out.println(adr.getZipcode()+" : "+adr.getSido()+" : "+adr.getGugun()
//				+" : "+adr.getDong()+" : "+adr.getRi()+" : "+adr.getBunji());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
