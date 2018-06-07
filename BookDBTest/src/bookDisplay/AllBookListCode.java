package bookDisplay;

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

import dbo.BookDBO;
import infos.BookInfos;

public class AllBookListCode extends JDialog {
	AllBookListCode self =this;
	BookDBO bdbo = new BookDBO();
	
	private String[] columnHeaders = new String[] {
			"ID","제목","작가","가격","출판사","장르"
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
				String ser = search.getText();
				try {
					List<BookInfos> list = bdbo.printBookListCode(ser);
					int linecol = list.size();
					for(int i=0;i<linecol;i++) {
						dtm.addRow(new Object[] {
							 list.get(i).getBNo(),list.get(i).getBName(),
							 list.get(i).getBWriter(),list.get(i).getBPrice(),
							 list.get(i).getPublisher(),list.get(i).getGenre()
						});
					}
				} catch (Exception e1) {
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
	
	public AllBookListCode () {
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
