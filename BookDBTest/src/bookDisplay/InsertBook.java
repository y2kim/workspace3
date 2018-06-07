package bookDisplay;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbo.BookDBO;
import infos.BookInfos;

public class InsertBook extends JDialog {
	InsertBook self = this;
	BookDBO bdbo = new BookDBO();
	
	private JLabel btnId = new JLabel("Book_No");
	private JTextField fieldId = new JTextField();
	
	private JLabel btnName = new JLabel("Book_Name");
	private JTextField fieldName = new JTextField();
	
	private JLabel btnWrite = new JLabel("Book_Write");
	private JTextField fieldWrite = new JTextField();
	
	private JLabel btnPrice = new JLabel("Book_Price");
	private JTextField fieldPrice = new JTextField();
	
	private JLabel btnpub = new JLabel("Book_publisher");
	private JTextField fieldpub = new JTextField();
	
	private JLabel btngen = new JLabel("Book_genre");
	private JTextField fieldgen = new JTextField();
	
	
	private JPanel panelCenter = new JPanel(new GridBagLayout());
	
	private JButton signBtn = new JButton("SignUp");
	private JButton closeBtn = new JButton("Close");
	
	private JPanel panelButtons = new JPanel(new GridLayout());
	
	private void compInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.panelCenter.add(btnId, gbc);
		gbc.gridx = 1; gbc.gridy =0;
		this.fieldId.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldId, gbc);
		
		gbc.gridx = 0; gbc.gridy =1;
		this.panelCenter.add(btnName, gbc);
		gbc.gridx = 1; gbc.gridy =1;
		this.fieldName.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldName, gbc);
		
		gbc.gridx = 0; gbc.gridy =2;
		this.panelCenter.add(btnWrite, gbc);
		gbc.gridx = 1; gbc.gridy =2;
		this.fieldWrite.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldWrite, gbc);
		
		gbc.gridx = 0; gbc.gridy =3;
		this.panelCenter.add(btnPrice, gbc);
		gbc.gridx = 1; gbc.gridy =3;
		this.fieldPrice.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldPrice, gbc);
		
		gbc.gridx = 0; gbc.gridy =4;
		this.panelCenter.add(btnpub, gbc);
		gbc.gridx = 1; gbc.gridy =4;
		this.fieldpub.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldpub, gbc);
		
		gbc.gridx = 0; gbc.gridy =5;
		this.panelCenter.add(btngen, gbc);
		gbc.gridx = 1; gbc.gridy =5;
		this.fieldgen.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldgen, gbc);
		
		this.panelButtons.add(signBtn);
		this.panelButtons.add(closeBtn);
		
		this.add(panelCenter);
		this.add(panelButtons,BorderLayout.SOUTH);
	}
	
	private void eventInit() {
		this.signBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ids = Integer.parseInt(fieldId.getText());
				String names = fieldName.getText();
				String writer = fieldWrite.getText();
				int prices = Integer.parseInt(fieldPrice.getText());
				String publisher = fieldpub.getText();
				String gender = fieldgen.getText();
				String testing = fieldId.getText();
				if(names.equals(null) && writer==null && publisher.equals(null)&&(testing.equals(null))) {
					JOptionPane.showMessageDialog(null, "공백값이 있습니다");
				}else {
					BookInfos bif = new BookInfos();
					bif.setBNo(ids);
					bif.setBName(names);
					bif.setBWriter(writer);
					bif.setBPrice(prices);
					bif.setPublisher(publisher);
					bif.setGenre(gender);
					
					try {
						int abc = bdbo.insertBook(bif);
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
				
				
			}
		});
		this.closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				self.dispose();
			}
		});
		
	}
	
	public InsertBook() {
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}


}
