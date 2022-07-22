package Main_Login;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Coin_Chart.Coin_List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LogInMenu {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldmsg;
	private MemberDAO dao;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInMenu window = new LogInMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 try {
			   UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

			  } catch (Exception e) {
			   e.printStackTrace();
			  }
	}

	public LogInMenu() {
		initialize();
	}

	
	public JFrame getFrame() {
		return frame;
	}
	private void initialize() {
		dao = new MemberDAO();
		frame = new JFrame();
		frame.setTitle("bit");
		frame.setBounds(100, 100, 550, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel LogIn_ID = new JLabel("ID");
		LogIn_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_ID.setBounds(126, 402, 20, 27);
		LogIn_ID.setForeground(Color.white);
		frame.getContentPane().add(LogIn_ID);
		
		JLabel LogIn_PW = new JLabel("PW");
		LogIn_PW.setForeground(Color.WHITE);
		LogIn_PW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_PW.setBounds(117, 462, 29, 27);
		frame.getContentPane().add(LogIn_PW);
		
		JLabel Label_Bit = new JLabel("bit");
		Label_Bit.setForeground(Color.WHITE);
		Label_Bit.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		Label_Bit.setBounds(237, 64, 114, 63);
		frame.getContentPane().add(Label_Bit);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldID.getText().equals("")) {
					textFieldmsg.setText("Enter your ID");
				} else if (passwordField.getText().equals("")) {
					textFieldmsg.setText("Enter your password.");
				} else {
					System.out.println(textFieldID.getText());
					System.out.println(passwordField.getText());

					MemberVo vo = new MemberVo(textFieldID.getText(), passwordField.getText());
					boolean b = dao.list(vo);
					if (b == true) {
						textFieldmsg.setText("Login success");
						frame.dispose();
						new Coin_List().getFrame().setVisible(true);
					} else {
						textFieldmsg.setText("Login failed");
					}
				}
			}
		});

		login.setBounds(398, 402, 82, 87);
		frame.getContentPane().add(login);
		
		textFieldID = new JTextField();
		textFieldID.setBackground(Color.WHITE);
		textFieldID.setBounds(209, 394, 171, 40);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setColumns(10);
		passwordField.setBounds(208, 455, 171, 40);
		frame.getContentPane().add(passwordField);
		
		textFieldmsg = new JTextField();
		textFieldmsg.setForeground(Color.BLACK);
		textFieldmsg.setBounds(171, 511, 209, 28);
		frame.getContentPane().add(textFieldmsg);
		textFieldmsg.setColumns(40);
		textFieldmsg.setEditable(false);
		textFieldmsg.setFocusable(false);
		textFieldmsg.setOpaque(false);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SignUp().getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(398, 511, 82, 27);
		frame.getContentPane().add(btnNewButton);
				
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\project\\LogIn.png"));
		lblNewLabel.setBounds(0, 0, 534, 611);
		frame.getContentPane().add(lblNewLabel);
		
		

	}
}
