package exam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import kh_dao.DBManager;
import service.Service;

public class Client extends JFrame{
	//DBManager dba = new DBManager();
	Service svi = Service.getInstance();
	Client self = this;
	private JLabel labelTitle = new JLabel("DB Login Practice");
	
	private JLabel labelId = new JLabel("ID");
	private JTextField fieldId = new JTextField();
	
	private JLabel labelPw = new JLabel("PW");
	private JPasswordField fieldPw = new JPasswordField();
	
	private JPanel panelCenter = new JPanel(new GridBagLayout());
	
	private JButton loginBtn = new JButton("Login");
	private JButton joinBtn = new JButton("SignUp");
	
	private JPanel panelButtons = new JPanel(new GridLayout());
	
	private void compInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.panelCenter.add(labelId, gbc);
		gbc.gridx = 1; gbc.gridy =0;
		this.fieldId.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldId, gbc);
		
		gbc.gridx = 0; gbc.gridy =1;
		this.panelCenter.add(labelPw, gbc);
		gbc.gridx = 1; gbc.gridy =1;
		this.fieldPw.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldPw, gbc);
		
		this.panelButtons.add(loginBtn);
		this.panelButtons.add(joinBtn);
		
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(labelTitle,BorderLayout.NORTH);
		this.add(panelCenter);
		this.add(panelButtons,BorderLayout.SOUTH);
	}
	
	private void eventInit() {
		this.joinBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUpDis();
			}
		});
		this.loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String chkid = fieldId.getText();
				String chkpw = new String(fieldPw.getPassword());
				try {
					boolean succ = svi.login(chkid, chkpw);
					if(succ) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
						self.dispose();
						new MenuListDisplay();
						
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public Client() {
		super("로그인");
		this.setSize(400, 300);
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
				new Client();
			}
		});
	}
}
