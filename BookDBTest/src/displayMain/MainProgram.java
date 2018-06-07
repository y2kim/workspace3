package displayMain;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainProgram extends JFrame{
	
	MainProgram self = this;
	private JLabel labelTitle = new JLabel("DB Practice");
	private JButton bookMan = new JButton("Book");
	private JButton memMan = new JButton("Member");
	private JButton rentMan = new JButton("Send");
	private JButton exit = new JButton("Exit");
	
	private void eventInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.add(labelTitle, gbc);
		gbc.gridx = 0; gbc.gridy =1;
		this.bookMan.setPreferredSize(new Dimension(100, 27));
		this.add(bookMan, gbc);
		gbc.gridx = 0; gbc.gridy =2;
		this.memMan.setPreferredSize(new Dimension(100, 27));
		this.add(memMan, gbc);
		gbc.gridx = 0; gbc.gridy =3;
		this.rentMan.setPreferredSize(new Dimension(100, 27));
		this.add(rentMan, gbc);
		gbc.gridx = 0; gbc.gridy =4;
		this.exit.setPreferredSize(new Dimension(100, 27));
		this.add(exit, gbc);
	}
	
	private void compInit() {
		this.bookMan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BookManage(self);
				self.dispose();
			}
		});
		this.memMan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MemberManage(self);
				self.dispose();
			}
		});
		this.rentMan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RentManage(self);
				self.dispose();
			}
		});
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("시스템 종료");
				System.exit(0);
			}
		});
		
	}
	
	public MainProgram() {
		super("메인프로그램");
		this.setSize(400, 300);
		this.setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Thread() {
			@Override
			public void run() {
				new MainProgram();
			}
		});
	}

}
