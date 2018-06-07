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

import memberDisplay.AllMemberList;
import memberDisplay.AllMemberListId;
import memberDisplay.AllMemberListName;

public class MemberManage extends JFrame {
	MemberManage self =this;
	
	private JLabel labelTitle = new JLabel("Member Managerment");
	private JButton memberBtn = new JButton("Member serach list");
	private JButton nameBtn = new JButton("Name serach");
	private JButton idBtn = new JButton("Id serach");
	private JButton signMem = new JButton("sign up");
	private JButton fixMem = new JButton("Fix info");
	private JButton delMem = new JButton("out member");
	private JButton close = new JButton("Close");
	
	private void eventInit() {
		this.memberBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllMemberList();
			}
		});
		this.nameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllMemberListName();
			}
		});
		this.idBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllMemberListId();
			}
		});
		this.signMem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.fixMem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.delMem.addActionListener(new ActionListener() {
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
		this.memberBtn.setPreferredSize(new Dimension(100, 27));
		this.add(memberBtn, gbc);
		gbc.gridx = 0; gbc.gridy =2;
		this.nameBtn.setPreferredSize(new Dimension(100, 27));
		this.add(nameBtn, gbc);
		gbc.gridx = 0; gbc.gridy =3;
		this.idBtn.setPreferredSize(new Dimension(100, 27));
		this.add(idBtn, gbc);
		gbc.gridx = 0; gbc.gridy =4;
		this.signMem.setPreferredSize(new Dimension(100, 27));
		this.add(signMem, gbc);
		gbc.gridx = 0; gbc.gridy =5;
		this.fixMem.setPreferredSize(new Dimension(100, 27));
		this.add(fixMem, gbc);
		gbc.gridx = 0; gbc.gridy =6;
		this.delMem.setPreferredSize(new Dimension(100, 27));
		this.add(delMem, gbc);
		gbc.gridx = 0; gbc.gridy =7;
		this.close.setPreferredSize(new Dimension(100, 27));
		this.add(close, gbc);
	}
	public MemberManage(MainProgram mg) {
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
