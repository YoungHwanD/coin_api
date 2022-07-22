package Coin_Chart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import Main_Login.LogInMenu;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Coin_List {

	private JFrame frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coin_List window = new Coin_List();
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

	public Coin_List() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Coin List");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 600, 700);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton Button_Back = new JButton();
		Button_Back.setIcon(new ImageIcon("E:\\project\\back.png"));
		Button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LogInMenu().getFrame().setVisible(true);
			}
		});
		Button_Back.setBorderPainted(false);
		Button_Back.setContentAreaFilled(false);
		Button_Back.setBounds(12, 10, 35, 35);
		frame.getContentPane().add(Button_Back);
		Button_Back.setBorderPainted(false);

		JLabel List_Of_Coin = new JLabel("화폐 목록");
		List_Of_Coin.setFont(new Font("새굴림", Font.BOLD, 21));
		List_Of_Coin.setBounds(252, 7, 103, 52);
		frame.getContentPane().add(List_Of_Coin);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(0, 151, 584, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(0, 208, 584, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.GRAY);
		separator_2.setBounds(0, 263, 584, 2);
		frame.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.GRAY);
		separator_3.setBounds(0, 318, 584, 2);
		frame.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.GRAY);
		separator_4.setBounds(0, 373, 584, 2);
		frame.getContentPane().add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.GRAY);
		separator_5.setBounds(0, 428, 584, 2);
		frame.getContentPane().add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBounds(0, 483, 584, 2);
		frame.getContentPane().add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setBounds(0, 541, 584, 2);
		frame.getContentPane().add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.GRAY);
		separator_8.setBounds(0, 599, 584, 2);
		frame.getContentPane().add(separator_8);

		JLabel BTC_Logo = new JLabel("");
		BTC_Logo.setIcon(new ImageIcon("E:\\project\\BTC.png"));
		BTC_Logo.setBounds(57, 109, 30, 30);
		frame.getContentPane().add(BTC_Logo);

		JLabel ETH_Logo = new JLabel("");
		ETH_Logo.setIcon(new ImageIcon("E:\\project\\ETH.png"));
		ETH_Logo.setBounds(57, 165, 30, 30);
		frame.getContentPane().add(ETH_Logo);

		JLabel XRP_Logo = new JLabel("");
		XRP_Logo.setIcon(new ImageIcon("E:\\project\\XRP.png"));
		XRP_Logo.setBounds(57, 221, 30, 30);
		frame.getContentPane().add(XRP_Logo);

		JLabel MATIC_Logo = new JLabel("");
		MATIC_Logo.setIcon(new ImageIcon("E:\\project\\MATIC.jpg"));
		MATIC_Logo.setBounds(57, 275, 30, 30);
		frame.getContentPane().add(MATIC_Logo);

		JLabel SOL_Logo = new JLabel("");
		SOL_Logo.setIcon(new ImageIcon("E:\\project\\SOL.jpg"));
		SOL_Logo.setBounds(57, 331, 30, 30);
		frame.getContentPane().add(SOL_Logo);

		JLabel BCH_Logo = new JLabel("");
		BCH_Logo.setIcon(new ImageIcon("E:\\project\\BCH.png"));
		BCH_Logo.setBounds(57, 386, 30, 30);
		frame.getContentPane().add(BCH_Logo);

		JLabel ADA_Logo = new JLabel("");
		ADA_Logo.setIcon(new ImageIcon("E:\\project\\ADA.png"));
		ADA_Logo.setBounds(52, 441, 40, 30);
		frame.getContentPane().add(ADA_Logo);

		JLabel AVAX_Logo = new JLabel("");
		AVAX_Logo.setIcon(new ImageIcon("E:\\project\\AVAX.png"));
		AVAX_Logo.setBounds(57, 498, 30, 30);
		frame.getContentPane().add(AVAX_Logo);

		JLabel AAVE_Logo = new JLabel("");
		AAVE_Logo.setIcon(new ImageIcon("E:\\project\\AAVE.jpg"));
		AAVE_Logo.setBounds(57, 555, 30, 30);
		frame.getContentPane().add(AAVE_Logo);

		JLabel TRX_Logo = new JLabel("");
		TRX_Logo.setIcon(new ImageIcon("E:\\project\\TRX.png"));
		TRX_Logo.setBounds(57, 616, 30, 30);
		frame.getContentPane().add(TRX_Logo);

		JPanel panel = new JPanel();
		panel.setBounds(0, 62, 584, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel Coin_Name = new JLabel("\uD654\uD3D0\uBA85");
		Coin_Name.setFont(new Font("Dialog", Font.PLAIN, 12));
		Coin_Name.setBounds(117, 5, 47, 25);
		panel.add(Coin_Name);

		JLabel View_Details = new JLabel("\uC0C1\uC138\uBCF4\uAE30");
		View_Details.setFont(new Font("Dialog", Font.PLAIN, 12));
		View_Details.setBounds(475, 5, 65, 25);
		panel.add(View_Details);

		JLabel Rank_1_Coin = new JLabel("\uBE44\uD2B8\uCF54\uC778");
		Rank_1_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_1_Coin.setBounds(109, 107, 80, 34);
		frame.getContentPane().add(Rank_1_Coin);

		JLabel Rank_2_Coin = new JLabel("\uC774\uB354\uB9AC\uC6C0");
		Rank_2_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_2_Coin.setBounds(109, 164, 80, 34);
		frame.getContentPane().add(Rank_2_Coin);

		JLabel Rank_3_Coin = new JLabel("\uB9AC\uD50C");
		Rank_3_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_3_Coin.setBounds(109, 219, 80, 34);
		frame.getContentPane().add(Rank_3_Coin);

		JLabel Rank_4_Coin = new JLabel("\uD3F4\uB9AC\uACE4");
		Rank_4_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_4_Coin.setBounds(109, 273, 80, 34);
		frame.getContentPane().add(Rank_4_Coin);

		JLabel Rank_5_Coin = new JLabel("\uC194\uB77C\uB098");
		Rank_5_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_5_Coin.setBounds(109, 329, 80, 34);
		frame.getContentPane().add(Rank_5_Coin);

		JLabel Rank_6_Coin = new JLabel("\uBE44\uD2B8\uCF54\uC778\uCE90\uC2DC");
		Rank_6_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_6_Coin.setBounds(109, 384, 80, 34);
		frame.getContentPane().add(Rank_6_Coin);

		JLabel Rank_7_Coin = new JLabel("\uC5D0\uC774\uB2E4");
		Rank_7_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_7_Coin.setBounds(109, 438, 80, 34);
		frame.getContentPane().add(Rank_7_Coin);

		JLabel Rank_8_Coin = new JLabel("\uC544\uBC1C\uB780\uCCB4");
		Rank_8_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_8_Coin.setBounds(109, 496, 80, 34);
		frame.getContentPane().add(Rank_8_Coin);

		JLabel Rank_9_Coin = new JLabel("\uC5D0\uC774\uBE0C");
		Rank_9_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_9_Coin.setBounds(109, 553, 80, 34);
		frame.getContentPane().add(Rank_9_Coin);

		JLabel Rank_10_Coin = new JLabel("\uD2B8\uB860");
		Rank_10_Coin.setFont(new Font("Dialog", Font.BOLD, 12));
		Rank_10_Coin.setBounds(109, 613, 80, 34);
		frame.getContentPane().add(Rank_10_Coin);

		JLabel Coin_Code_BTC = new JLabel("KRW/BTC");
		Coin_Code_BTC.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_BTC.setBounds(206, 108, 80, 30);
		frame.getContentPane().add(Coin_Code_BTC);

		JLabel Coin_Code_ETH = new JLabel("KRW/ETH");
		Coin_Code_ETH.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_ETH.setBounds(206, 164, 80, 30);
		frame.getContentPane().add(Coin_Code_ETH);

		JLabel Coin_Code_XRP = new JLabel("KRW/XRP");
		Coin_Code_XRP.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_XRP.setBounds(206, 219, 80, 30);
		frame.getContentPane().add(Coin_Code_XRP);

		JLabel Coin_Code_MATIC = new JLabel("KRW/MATIC");
		Coin_Code_MATIC.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_MATIC.setBounds(206, 274, 80, 30);
		frame.getContentPane().add(Coin_Code_MATIC);

		JLabel Coin_Code_SOL = new JLabel("KRW/SOL");
		Coin_Code_SOL.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_SOL.setBounds(206, 328, 80, 30);
		frame.getContentPane().add(Coin_Code_SOL);

		JLabel Coin_Code_BCH = new JLabel("KRW/BCH");
		Coin_Code_BCH.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_BCH.setBounds(206, 384, 80, 30);
		frame.getContentPane().add(Coin_Code_BCH);

		JLabel Coin_Code_ADA = new JLabel("KRW/ADA");
		Coin_Code_ADA.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_ADA.setBounds(206, 441, 80, 30);
		frame.getContentPane().add(Coin_Code_ADA);

		JLabel Coin_Code_AVAX = new JLabel("KRW/AVAX");
		Coin_Code_AVAX.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_AVAX.setBounds(206, 496, 80, 30);
		frame.getContentPane().add(Coin_Code_AVAX);

		JLabel Coin_Code_AAVE = new JLabel("KRW/AAVE");
		Coin_Code_AAVE.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_AAVE.setBounds(206, 554, 80, 30);
		frame.getContentPane().add(Coin_Code_AAVE);

		JLabel Coin_Code_TRX = new JLabel("KRW/TRX");
		Coin_Code_TRX.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_TRX.setBounds(206, 613, 80, 30);
		frame.getContentPane().add(Coin_Code_TRX);

		JButton Button_BTC = new JButton("현재가");
		Button_BTC.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_BTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BTC_Chart().getFrame().setVisible(true);
			}
		});
		Button_BTC.setBounds(453, 109, 90, 32);
		frame.getContentPane().add(Button_BTC);

		JButton Button_ETH = new JButton("현재가");
		Button_ETH.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_ETH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ETH_Chart().getFrame().setVisible(true);
			}
		});
		Button_ETH.setBounds(453, 163, 90, 32);
		frame.getContentPane().add(Button_ETH);

		JButton Button_XRP = new JButton("현재가");
		Button_XRP.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_XRP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new XRP_Chart().getFrame().setVisible(true);
			}
		});
		Button_XRP.setBounds(453, 220, 90, 32);
		frame.getContentPane().add(Button_XRP);

		JButton Button_MATIC = new JButton("현재가");
		Button_MATIC.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_MATIC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MATIC_Chart().getFrame().setVisible(true);
			}
		});
		Button_MATIC.setBounds(453, 275, 90, 32);
		frame.getContentPane().add(Button_MATIC);

		JButton Button_SOL = new JButton("현재가");
		Button_SOL.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_SOL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SOL_Chart().getFrame().setVisible(true);
			}
		});
		Button_SOL.setBounds(453, 330, 90, 32);
		frame.getContentPane().add(Button_SOL);

		JButton Button_BCH = new JButton("현재가");
		Button_BCH.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_BCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BCH_Chart().getFrame().setVisible(true);
			}
		});
		Button_BCH.setBounds(453, 385, 90, 32);
		frame.getContentPane().add(Button_BCH);

		JButton Button_ADA = new JButton("현재가");
		Button_ADA.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_ADA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ADA_Chart().getFrame().setVisible(true);
			}
		});
		Button_ADA.setBounds(453, 440, 90, 32);
		frame.getContentPane().add(Button_ADA);

		JButton Button_AVAX = new JButton("현재가");
		Button_AVAX.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_AVAX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AVAX_Chart().getFrame().setVisible(true);
			}
		});
		Button_AVAX.setBounds(453, 495, 90, 32);
		frame.getContentPane().add(Button_AVAX);

		JButton Button_AAVE = new JButton("현재가");
		Button_AAVE.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_AAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AAVE_Chart().getFrame().setVisible(true);
			}
		});
		Button_AAVE.setBounds(453, 553, 90, 32);
		frame.getContentPane().add(Button_AAVE);

		JButton Button_TRX = new JButton("현재가");
		Button_TRX.setFont(new Font("굴림", Font.PLAIN, 11));
		Button_TRX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new TRX_Chart().getFrame().setVisible(true);
			}
		});
		Button_TRX.setBounds(453, 611, 90, 32);
		frame.getContentPane().add(Button_TRX);
		
		JLabel Label_Rank_1 = new JLabel("  1");
		Label_Rank_1.setForeground(new Color(255, 102, 102));
		Label_Rank_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_1.setBounds(0, 96, 584, 56);
		frame.getContentPane().add(Label_Rank_1);

		JLabel Label_Rank_2 = new JLabel("  2");
		Label_Rank_2.setForeground(new Color(255, 102, 102));
		Label_Rank_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_2.setBounds(0, 153, 584, 56);
		frame.getContentPane().add(Label_Rank_2);
		
		JLabel Label_Rank_3 = new JLabel("  3");
		Label_Rank_3.setForeground(new Color(255, 102, 102));
		Label_Rank_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_3.setBounds(0, 208, 584, 56);
		frame.getContentPane().add(Label_Rank_3);
		
		JLabel Label_Rank_4 = new JLabel("  4");
		Label_Rank_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_4.setBounds(0, 263, 584, 56);
		frame.getContentPane().add(Label_Rank_4);

		JLabel Label_Rank_5 = new JLabel("  5");
		Label_Rank_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_5.setBounds(0, 318, 584, 56);
		frame.getContentPane().add(Label_Rank_5);
		
		JLabel Label_Rank_6 = new JLabel("  6");
		Label_Rank_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_6.setBounds(0, 373, 584, 56);
		frame.getContentPane().add(Label_Rank_6);
		
		JLabel Label_Rank_7 = new JLabel("  7");
		Label_Rank_7.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_7.setBounds(0, 428, 584, 56);
		frame.getContentPane().add(Label_Rank_7);

		JLabel Label_Rank_8 = new JLabel("  8");
		Label_Rank_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_8.setBounds(0, 486, 584, 56);
		frame.getContentPane().add(Label_Rank_8);

		JLabel Label_Rank_9 = new JLabel("  9");
		Label_Rank_9.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_9.setBounds(0, 543, 584, 56);
		frame.getContentPane().add(Label_Rank_9);

		JLabel Label_Rank_10 = new JLabel(" 10");
		Label_Rank_10.setFont(new Font("Dialog", Font.PLAIN, 15));
		Label_Rank_10.setBounds(0, 603, 584, 56);
		frame.getContentPane().add(Label_Rank_10);


	}
}
