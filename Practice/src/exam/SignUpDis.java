package exam;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kh_dao.DBManager;
import kh_infos.MemberInfo;

public class SignUpDis extends JDialog {
	DBManager dbo = new DBManager();

	
	private boolean cekdob = false;
	private JLabel labelId = new JLabel("ID");
	private JTextField fieldId = new JTextField();
	
	private JLabel labelPw = new JLabel("PW");
	private JTextField fieldPw = new JTextField();
	
	private JLabel labelName = new JLabel("Name");
	private JTextField fieldName = new JTextField();
	
	private JLabel labelGender = new JLabel("Gender");
	private JTextField fieldGender = new JTextField();
	private JRadioButton genderChk1 = new JRadioButton("남");
	private JRadioButton genderChk2 = new JRadioButton("여");
	private ButtonGroup bg = new ButtonGroup();
	
	private JLabel labelAdd = new JLabel("ADR");
	private JTextField fieldAdd = new JTextField();
	
	private JPanel panelCenter = new JPanel(new GridBagLayout());
	
	private JButton signBtn = new JButton("SignUp");
	private JButton chkBtn = new JButton("Check");
	private JButton closeBtn = new JButton("Close");
	
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
		
		gbc.gridx = 0; gbc.gridy =2;
		this.panelCenter.add(labelName, gbc);
		gbc.gridx = 1; gbc.gridy =2;
		this.fieldName.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldName, gbc);
		
		gbc.gridx = 0; gbc.gridy =3;
		this.panelCenter.add(labelGender, gbc);
		gbc.gridx = 1; gbc.gridy =3;
		bg.add(genderChk1);
		bg.add(genderChk2);
		this.fieldGender.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(genderChk1, gbc);
		gbc.gridx = 2; gbc.gridy =3;
		this.panelCenter.add(genderChk2, gbc);
		
		gbc.gridx = 0; gbc.gridy =4;
		this.panelCenter.add(labelAdd, gbc);
		gbc.gridx = 1; gbc.gridy =4;
		this.fieldAdd.setPreferredSize(new Dimension(100, 27));
		this.panelCenter.add(fieldAdd, gbc);
		
		this.panelButtons.add(signBtn);
		this.panelButtons.add(chkBtn);
		this.panelButtons.add(closeBtn);
		
		this.add(panelCenter);
		this.add(panelButtons,BorderLayout.SOUTH);
	}
	
	private void eventInit() {
		this.signBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String ids = fieldId.getText();
				String pws = fieldPw.getText();
				String names = fieldName.getText();
				String genders = null ;
				if(genderChk1.isSelected()) {
					genders = "남";
				}else if(genderChk2.isSelected()) {
					genders = "여";
				}
				String Adrs = fieldAdd.getText();
				if(cekdob==false) {
					JOptionPane.showMessageDialog(null, "중복체크 해주세요");
				}else if (cekdob==true) {
					
					MemberInfo mif = new MemberInfo();
					mif.setId(ids);
					mif.setPw(pws);
					mif.setName(names);
					mif.setGender(genders);
					mif.setAddress(Adrs);
					
					try {
						int abc = dbo.insertData(mif);
						if(abc>0) {
							JOptionPane.showMessageDialog(null, "입력에 성공하였습니다");
						}else {
							System.out.println("실패하였습니다.");
						}
					} catch (NullPointerException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "값을 제대로 넣어주세요");
					} catch (Exception e2){
						JOptionPane.showMessageDialog(null, "값이 제대로 넣어졌는지 확인해주세요");
					}
				}
				
			
				
			}
		});
		
		this.chkBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String ids = fieldId.getText();
				
				try {
					boolean ck = dbo.checkData(ids);
					if(ck==true) {
						System.out.println("중복");
						JOptionPane.showMessageDialog(null, "중복이 되었습니다");
						cekdob=false;
					}else {
						System.out.println("중복 안됨");
						JOptionPane.showMessageDialog(null, "사용가능 합니다");
						cekdob=true;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public SignUpDis() {
		this.setSize(500, 400);
		setLocationRelativeTo(null);
		this.compInit();
		this.eventInit();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
