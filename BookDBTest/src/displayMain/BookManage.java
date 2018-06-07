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

import bookDisplay.AllBookList;
import bookDisplay.AllBookListCode;
import bookDisplay.DeleteBook;
import bookDisplay.InsertBook;

public class BookManage extends JFrame {
	BookManage self = this;
	private JLabel labelTitle = new JLabel("BOOOOOOK MANAGEMENT");
	private JButton serBtn = new JButton("AllBookSearch");
	private JButton codeBtn = new JButton("CodeBookSearch");
	private JButton addBook = new JButton("AddBook");
	private JButton DelBook = new JButton("DelBook");
	private JButton close = new JButton("Close");
	
	private void eventInit(MainProgram mg) {
		this.serBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllBookList();
			}
		});
		this.codeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AllBookListCode();
			}
		});
		this.addBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InsertBook();
			}
		});
		this.DelBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteBook();
			}
		});
		this.close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
				new MainProgram();
			}
		});
	}
	
	private void compInit() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0; gbc.gridy =0;
		this.add(labelTitle, gbc);
		gbc.gridx = 0; gbc.gridy =1;
		this.serBtn.setPreferredSize(new Dimension(100, 27));
		this.add(serBtn, gbc);
		gbc.gridx = 0; gbc.gridy =2;
		this.codeBtn.setPreferredSize(new Dimension(100, 27));
		this.add(codeBtn, gbc);
		gbc.gridx = 0; gbc.gridy =3;
		this.addBook.setPreferredSize(new Dimension(100, 27));
		this.add(addBook, gbc);
		gbc.gridx = 0; gbc.gridy =4;
		this.DelBook.setPreferredSize(new Dimension(100, 27));
		this.add(DelBook, gbc);
		gbc.gridx = 0; gbc.gridy =5;
		this.close.setPreferredSize(new Dimension(100, 27));
		this.add(close, gbc);
	}
	
	public BookManage(MainProgram mg) {
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
		this.eventInit(mg);
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
