package exam;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MenuListDisplay extends JFrame {
	
	private JButton sellList = new JButton("판매자 목록");
	private JButton itemInfo = new JButton("상품 정보");
	private JButton buyInfo = new JButton("구매 정보");
	private JButton deliver = new JButton("배송 정보");
	
	private JPanel panelCenter = new JPanel(new GridBagLayout());
	
	private void compInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.panelCenter.add(sellList, gbc);
		gbc.gridx = 1; gbc.gridy =0;
		this.panelCenter.add(itemInfo, gbc);
		gbc.gridx = 2; gbc.gridy =0;
		this.panelCenter.add(buyInfo, gbc);
		gbc.gridx = 3; gbc.gridy =0;
		this.panelCenter.add(deliver, gbc);
		
		this.add(panelCenter);
	}
	
	private void eventInit() {
		this.sellList.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new SellerList();
			}
		});
		
		this.itemInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList();
			}
		});
		this.buyInfo.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyInfoList();
			}
		});
		this.deliver.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeliverInfoList();
			}
		});

		
	}
	
	public MenuListDisplay() {
		super("로그인");
		this.setSize(600, 300);
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
				//new MenuListDisplay();
			}
		});
	}
}
