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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Coin_Chart.Coin_List;

public class SignUp {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldPW;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private MemberDAO dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
		new SignUp();
	}

	public SignUp() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	private void initialize() {
		dao = new MemberDAO();
		frame = new JFrame();
		frame.setTitle("SignUp");
		frame.setBounds(100, 100, 550, 650);
		frame.getContentPane().setLayout(null);

		JLabel LogIn_ID = new JLabel("ID");
		LogIn_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_ID.setBounds(127, 362, 20, 27);
		LogIn_ID.setForeground(Color.white);
		frame.getContentPane().add(LogIn_ID);

		JLabel LogIn_PW = new JLabel("PW");
		LogIn_PW.setForeground(Color.WHITE);
		LogIn_PW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_PW.setBounds(118, 425, 29, 27);
		frame.getContentPane().add(LogIn_PW);

		JButton Button_Back = new JButton("");
		Button_Back.setIcon(new ImageIcon("E:\\project\\white.png"));
		Button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LogInMenu().getFrame().setVisible(true);
			}
		});
		Button_Back.setBorderPainted(false);
		Button_Back.setContentAreaFilled(false);
		Button_Back.setBounds(12, 10, 40, 40);
		frame.getContentPane().add(Button_Back);
		Button_Back.setBorderPainted(false);

		textFieldID = new JTextField();
		textFieldID.setBackground(Color.WHITE);
		textFieldID.setBounds(209, 357, 171, 40);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);

		textFieldPW = new JTextField();
		textFieldPW.setBackground(Color.WHITE);
		textFieldPW.setColumns(10);
		textFieldPW.setBounds(208, 418, 171, 40);
		frame.getContentPane().add(textFieldPW);

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBackground(Color.WHITE);
		textFieldName.setBounds(209, 476, 171, 40);
		frame.getContentPane().add(textFieldName);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setBounds(209, 537, 171, 40);
		frame.getContentPane().add(textFieldEmail);

		JLabel LogIn_PW_1 = new JLabel("Name");
		LogIn_PW_1.setForeground(Color.WHITE);
		LogIn_PW_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_PW_1.setBounds(101, 480, 46, 27);
		frame.getContentPane().add(LogIn_PW_1);

		JLabel LogIn_PW_2 = new JLabel("Email");
		LogIn_PW_2.setForeground(Color.WHITE);
		LogIn_PW_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogIn_PW_2.setBounds(100, 541, 47, 27);
		frame.getContentPane().add(LogIn_PW_2);

		JLabel Label_Bit = new JLabel("SignUp");
		Label_Bit.setForeground(Color.WHITE);
		Label_Bit.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		Label_Bit.setBounds(212, 64, 114, 63);
		frame.getContentPane().add(Label_Bit);

		JButton btnNewButton = new JButton("ID Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberVo vo = new MemberVo(textFieldID.getText());
				boolean b = dao.IDCheck(vo);

				if (b == true) {
					JOptionPane.showMessageDialog(null, "중복된 ID");
				} else {
					JOptionPane.showMessageDialog(null, "ID 사용 가능");
				}
			}
		});
		btnNewButton.setBounds(403, 357, 97, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberVo vo = new MemberVo(textFieldID.getText(), textFieldPW.getText(), textFieldName.getText(),
						textFieldEmail.getText());
				boolean b = dao.SignUp(vo);
				frame.dispose();
				new LogInMenu().getFrame().setVisible(true);
			}

		});
		btnSignup.setBounds(403, 476, 97, 101);
		frame.getContentPane().add(btnSignup);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("E:\\project\\SignUp.png"));
		lblNewLabel.setBounds(0, 0, 534, 611);
		frame.getContentPane().add(lblNewLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
