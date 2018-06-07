package displayMain;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RentManage extends JFrame{
	
	RentManage self = this;
	
	private JLabel labelTitle = new JLabel("RENT MANAGEMENT");
	private JButton rentlist = new JButton("RENTLIST");
	private JButton MNSBtn = new JButton("memidSerRent");
	private JButton BNSBtn = new JButton("BooknameRent");
	private JButton DelBook = new JButton("AddRent");
	private JButton close = new JButton("Close");
	
	private void eventInit() {
		this.rentlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.MNSBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.BNSBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.DelBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
			}
		});
	}
	
	private void compInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.add(labelTitle, gbc);
		gbc.gridx = 0; gbc.gridy =1;
		this.rentlist.setPreferredSize(new Dimension(100, 27));
		this.add(rentlist, gbc);
		gbc.gridx = 0; gbc.gridy =2;
		this.MNSBtn.setPreferredSize(new Dimension(100, 27));
		this.add(MNSBtn, gbc);
		gbc.gridx = 0; gbc.gridy =3;
		this.BNSBtn.setPreferredSize(new Dimension(100, 27));
		this.add(BNSBtn, gbc);
		gbc.gridx = 0; gbc.gridy =4;
		this.DelBook.setPreferredSize(new Dimension(100, 27));
		this.add(DelBook, gbc);
		gbc.gridx = 0; gbc.gridy =5;
		this.close.setPreferredSize(new Dimension(100, 27));
		this.add(close, gbc);
	}
	
	public RentManage(MainProgram mg) {
		super("메인프로그램");
		this.setSize(350, 500);
		this.setLayout(new GridBagLayout());
		setLocationRelativeTo(null);
		WindowListener exit = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				self.dispose();
				new MainProgram();
			}
		};
		this.addWindowListener(exit);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Thread() {
			@Override
			public void run() {
				
			}
		});
	}
}
