package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Mainemp extends JFrame {
	private Mainemp self = this;

	JButton btn1 = new JButton("부서별 급여");
	JButton btn2 = new JButton("직급별 급여");
	private void compInit() {
		// TODO Auto-generated method stub
		this.add(btn1);
		this.add(btn2);
	}
	
	private void eventInit() {
		this.btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SalaryMap();
				
			}
		});
		this.btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JobSalary();
				
			}
		});
	}
	
	public Mainemp() {
		this.setLayout(new GridBagLayout());
		this.setSize(300,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Mainemp();
	}
}
