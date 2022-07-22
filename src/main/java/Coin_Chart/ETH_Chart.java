package Coin_Chart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ETH_Chart {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ETH_Chart window = new ETH_Chart();
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

	public ETH_Chart() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("ETH_Chart");
		frame.setBounds(100, 100, 600, 700);
		frame.getContentPane().setLayout(null);

		JLabel ETH_Logo = new JLabel();
		ETH_Logo.setIcon(new ImageIcon("E:\\project\\ETH.png"));
		ETH_Logo.setBounds(17, 64, 30, 30);
		frame.getContentPane().add(ETH_Logo);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 108, 584, 2);
		frame.getContentPane().add(separator_1);

		JLabel Rank_2_Coin = new JLabel("이더리움");
		Rank_2_Coin.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		Rank_2_Coin.setBounds(63, 64, 83, 30);
		frame.getContentPane().add(Rank_2_Coin);

		JLabel Coin_Code_ETH = new JLabel("KRW/ETH");
		Coin_Code_ETH.setFont(new Font("돋움", Font.PLAIN, 10));
		Coin_Code_ETH.setBounds(136, 65, 80, 30);
		frame.getContentPane().add(Coin_Code_ETH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(420, 11, 139, 33);
		frame.getContentPane().add(btnNewButton);

		JLabel Label_high_price = new JLabel("고가");
		Label_high_price.setBounds(380, 133, 43, 21);
		frame.getContentPane().add(Label_high_price);

		JLabel Label_low_price = new JLabel("저가");
		Label_low_price.setBounds(380, 174, 43, 21);
		frame.getContentPane().add(Label_low_price);

		JSeparator separator = new JSeparator();
		separator.setBounds(363, 162, 196, 2);
		frame.getContentPane().add(separator);

		JButton Button_Back = new JButton("");
		Button_Back.setIcon(new ImageIcon("E:\\project\\back.png"));
		Button_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Coin_List().getFrame().setVisible(true);
			}
		});
		Button_Back.setBorderPainted(false);
		Button_Back.setContentAreaFilled(false);
		Button_Back.setBounds(12, 6, 35, 35);
		frame.getContentPane().add(Button_Back);
		Button_Back.setBorderPainted(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 54);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_3 = new JLabel("현재 시각");
		lblNewLabel_3.setBounds(355, 64, 64, 30);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel Label_Menu_1 = new JLabel();
		Label_Menu_1.setFont(new Font("HY중고딕", Font.PLAIN, 16));
		Label_Menu_1.setText("전일 종가");
		Label_Menu_1.setBounds(12, 223, 187, 38);
		frame.getContentPane().add(Label_Menu_1);

		JLabel Label_Menu_3 = new JLabel();
		Label_Menu_3.setText("24시간 누적 거래량");
		Label_Menu_3.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_3.setBounds(12, 318, 187, 38);
		frame.getContentPane().add(Label_Menu_3);

		JLabel Label_Menu_4 = new JLabel();
		Label_Menu_4.setText("24시간 누적 거래대금");
		Label_Menu_4.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_4.setBounds(12, 367, 187, 38);
		frame.getContentPane().add(Label_Menu_4);

		JLabel Label_Menu_5 = new JLabel();
		Label_Menu_5.setText("누적 거래대금(UTC 0시 기준)");
		Label_Menu_5.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_5.setBounds(12, 415, 202, 38);
		frame.getContentPane().add(Label_Menu_5);

		JLabel Label_Menu_6 = new JLabel();
		Label_Menu_6.setText("52주 최고가");
		Label_Menu_6.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_6.setBounds(12, 462, 187, 38);
		frame.getContentPane().add(Label_Menu_6);

		JLabel Label_Menu_7 = new JLabel();
		Label_Menu_7.setText("52주 신고가 달성");
		Label_Menu_7.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_7.setBounds(12, 511, 187, 38);
		frame.getContentPane().add(Label_Menu_7);

		JLabel Label_Menu_8 = new JLabel();
		Label_Menu_8.setText("52주 신저가");
		Label_Menu_8.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_8.setBounds(12, 559, 187, 38);
		frame.getContentPane().add(Label_Menu_8);

		JLabel Label_Menu_9 = new JLabel();
		Label_Menu_9.setText("52주 신저가 달성일");
		Label_Menu_9.setFont(new Font("HY중고딕", Font.PLAIN, 14));
		Label_Menu_9.setBounds(12, 613, 187, 38);
		frame.getContentPane().add(Label_Menu_9);

		JButton BTC_Button = new JButton("비트코인 (BTC/KRW)");
		BTC_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		BTC_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BTC_Chart().getFrame().setVisible(true);
			}
		});
		BTC_Button.setBounds(411, 218, 173, 48);
		frame.getContentPane().add(BTC_Button);

		JButton XRP_Button = new JButton("리플 (XRP/KRW)");
		XRP_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		XRP_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new XRP_Chart().getFrame().setVisible(true);
			}
		});
		XRP_Button.setBounds(411, 266, 173, 48);
		frame.getContentPane().add(XRP_Button);

		JButton MATIC_Button = new JButton("폴리곤 (MATIC/KRW)");
		MATIC_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		MATIC_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MATIC_Chart().getFrame().setVisible(true);
			}
		});
		MATIC_Button.setBounds(411, 314, 173, 48);
		frame.getContentPane().add(MATIC_Button);

		JButton SOL_Button = new JButton("솔라나 (SOL/KRW)");
		SOL_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		SOL_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SOL_Chart().getFrame().setVisible(true);
			}
		});
		SOL_Button.setBounds(411, 362, 173, 48);
		frame.getContentPane().add(SOL_Button);

		JButton BCH_Button = new JButton("비트코인캐시 (BCH/KRW)");
		BCH_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		BCH_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BCH_Chart().getFrame().setVisible(true);
			}
		});
		BCH_Button.setBounds(411, 410, 173, 48);
		frame.getContentPane().add(BCH_Button);

		JButton ADA_Button = new JButton("에이다 (ADA/KRW)");
		ADA_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		ADA_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ADA_Chart().getFrame().setVisible(true);
			}
		});
		ADA_Button.setBounds(411, 458, 173, 48);
		frame.getContentPane().add(ADA_Button);

		JButton AVAX_Button = new JButton("아발란체 (AVAX/KRW)");
		AVAX_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		AVAX_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AVAX_Chart().getFrame().setVisible(true);
			}
		});
		AVAX_Button.setBounds(411, 506, 173, 48);
		frame.getContentPane().add(AVAX_Button);

		JButton AAVE_Button = new JButton("에이브 (AAVE/KRW)");
		AAVE_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		AAVE_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AAVE_Chart().getFrame().setVisible(true);
			}
		});
		AAVE_Button.setBounds(411, 554, 173, 48);
		frame.getContentPane().add(AAVE_Button);

		JButton TRX_Button = new JButton("트론 (TRX/KRW)");
		TRX_Button.setFont(new Font("굴림", Font.PLAIN, 11));
		TRX_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new TRX_Chart().getFrame().setVisible(true);
			}
		});
		TRX_Button.setBounds(411, 604, 173, 52);
		frame.getContentPane().add(TRX_Button);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBounds(-1, 265, 400, 2);
		frame.getContentPane().add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.LIGHT_GRAY);
		separator_2_1.setBounds(-1, 313, 400, 2);
		frame.getContentPane().add(separator_2_1);

		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setForeground(Color.LIGHT_GRAY);
		separator_2_2.setBounds(-1, 361, 400, 2);
		frame.getContentPane().add(separator_2_2);

		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setForeground(Color.LIGHT_GRAY);
		separator_2_3.setBounds(-1, 409, 400, 2);
		frame.getContentPane().add(separator_2_3);

		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setForeground(Color.LIGHT_GRAY);
		separator_2_4.setBounds(-1, 457, 400, 2);
		frame.getContentPane().add(separator_2_4);

		JSeparator separator_2_5 = new JSeparator();
		separator_2_5.setForeground(Color.LIGHT_GRAY);
		separator_2_5.setBounds(-1, 505, 400, 2);
		frame.getContentPane().add(separator_2_5);

		JSeparator separator_2_6 = new JSeparator();
		separator_2_6.setForeground(Color.LIGHT_GRAY);
		separator_2_6.setBounds(-1, 553, 400, 2);
		frame.getContentPane().add(separator_2_6);

		JSeparator separator_2_7 = new JSeparator();
		separator_2_7.setForeground(Color.LIGHT_GRAY);
		separator_2_7.setBounds(-1, 601, 400, 2);
		frame.getContentPane().add(separator_2_7);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(1, 216, 582, 5);
		frame.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 655, 585, 2);
		frame.getContentPane().add(separator_4);

		JLabel lblNewLabel_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1.setFont(new Font("굴림체", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(24, 174, 64, 21);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		 SimpleDateFormat time_kst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date now = new Date();
		JLabel lblNewLabel = new JLabel(time_kst.format(now));
		lblNewLabel.setBounds(434, 64, 128, 30);
		frame.getContentPane().add(lblNewLabel);
		



		String coin[] = { "KRW-BTC", "KRW-ETH", "KRW-XRP", "KRW-MATIC", "KRW-SOL", 
				"KRW-BCH", "KRW-ADA", "KRW-AVAX", "KRW-AAVE", "KRW-TRX" };

		try {
			OkHttpClient client = new OkHttpClient();

			Request request = new Request
					.Builder()
					.url("https://api.upbit.com/v1/ticker?markets=" + coin[1])
					.get()
					.addHeader("Accept", "application/json").build();

			Response response = client.newCall(request).execute();

			String jsonData = response.body().string();

			JSONArray jsonArr = new JSONArray(jsonData);

			if (jsonArr.length() > 0) {
				for (int i = 0; i < jsonArr.length(); i++) {
					JSONObject jsonObject = jsonArr.getJSONObject(i);

					int TP = jsonObject.getInt("trade_price");
					double D_SCP = jsonObject.getDouble("signed_change_price");
					int HP = jsonObject.getInt("high_price");
					int LP = jsonObject.getInt("low_price");
					int PCP = jsonObject.getInt("prev_closing_price");
					double D_TV = jsonObject.getDouble("trade_volume");
					int ATV = jsonObject.getInt("acc_trade_volume_24h");
					int ATP = jsonObject.getInt("acc_trade_price_24h");
					int ATP_U = jsonObject.getInt("acc_trade_price");
					int HWP = jsonObject.getInt("highest_52_week_price");
					String Highest_52_Week_Date = jsonObject.getString("highest_52_week_date");
					int LWP = jsonObject.getInt("lowest_52_week_price");
					String Lowest_52_Week_Date = jsonObject.getString("lowest_52_week_date");


					double D_TP = jsonObject.getDouble("trade_price");
					double D_PCP = jsonObject.getDouble("prev_closing_price");
					double D_CP = ((D_TP-D_PCP)/D_PCP)*100;
					int I_TV =(int)(D_TP * D_TV);


					DecimalFormat decFormat = new DecimalFormat("###,###");
					String Trade_Price = decFormat.format(TP);
					String Signed_Change_Price = decFormat.format(D_SCP);
					String High_Price = decFormat.format(HP);
					String Low_Price = decFormat.format(LP);
					String Prev_Closing_Price = decFormat.format(PCP);
					String Trade_Volume = decFormat.format(I_TV);
					String Acc_Trade_Volume_24h = decFormat.format(ATV);
					String Acc_Trade_Price_24h = decFormat.format(ATP);
					String Acc_Trade_Price = decFormat.format(ATP_U);
					String Highest_52_Week_Price = decFormat.format(HWP);
					String Lowest_52_Week_Price = decFormat.format(LWP);
					

					JLabel label_TP = new JLabel(Trade_Price + " KRW");
					label_TP.setFont(new Font("맑은 고딕", Font.BOLD, 30));
					label_TP.setBounds(24, 120, 327, 53);
					frame.getContentPane().add(label_TP);
					if (D_SCP > 0) {
						label_TP.setForeground(Color.RED);
					} else if (D_SCP < 0) {
						label_TP.setForeground(Color.BLUE);
					} else {
						label_TP.setForeground(Color.BLACK);
					}


					JLabel Label_Compare = new JLabel();
					Label_Compare.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					Label_Compare.setBounds(83, 173, 237, 21);
					frame.getContentPane().add(Label_Compare);
					if(D_CP > 0) {
						Label_Compare.setForeground(Color.RED);
						Label_Compare.setText(String.format("%.2f ▲ %s", D_CP, Signed_Change_Price));
					} else if (D_CP < 0) {
						Label_Compare.setForeground(Color.BLUE);
						Label_Compare.setText(String.format("%.2f ▼ %s", D_CP, Signed_Change_Price));
					} else {
						Label_Compare.setForeground(Color.BLACK);
					}
						
					
					JLabel Label_High_Price = new JLabel();
					Label_High_Price.setText(High_Price);
					Label_High_Price.setForeground(Color.RED);
					Label_High_Price.setBounds(448, 136, 95, 15);
					frame.getContentPane().add(Label_High_Price);

					JLabel Label_Low_Price = new JLabel();
					Label_Low_Price.setText(Low_Price);
					Label_Low_Price.setForeground(Color.BLUE);
					Label_Low_Price.setBounds(448, 177, 95, 15);
					frame.getContentPane().add(Label_Low_Price);

					JPanel panel_1 = new JPanel();
					panel_1.setBounds(0, 218, 400, 438);
					frame.getContentPane().add(panel_1);
					panel_1.setLayout(null);

					JLabel Label_Prev_Closing_Price = new JLabel(Prev_Closing_Price);
					Label_Prev_Closing_Price.setText(Prev_Closing_Price + " KRW");
					Label_Prev_Closing_Price.setBounds(223, 7, 165, 33);
					panel_1.add(Label_Prev_Closing_Price);
					Label_Prev_Closing_Price.setFont(new Font("굴림", Font.PLAIN, 11));

					JLabel Label_Trade_Volume = new JLabel();
					Label_Trade_Volume.setText(Trade_Volume + " KRW");
					Label_Trade_Volume.setBounds(223, 55, 165, 33);
					panel_1.add(Label_Trade_Volume);
					Label_Trade_Volume.setFont(new Font("굴림", Font.PLAIN, 11));
					
					JLabel Label_Acc_Trade_Volume_24h = new JLabel();
					Label_Acc_Trade_Volume_24h.setText(Acc_Trade_Volume_24h + " 건");
					Label_Acc_Trade_Volume_24h.setBounds(223, 103, 165, 33);
					panel_1.add(Label_Acc_Trade_Volume_24h);
					Label_Acc_Trade_Volume_24h.setFont(new Font("굴림", Font.PLAIN, 11));

					JLabel Label_Acc_Trade_Price_24h = new JLabel();
					Label_Acc_Trade_Price_24h.setText(Acc_Trade_Price_24h + " KRW");
					Label_Acc_Trade_Price_24h.setBounds(223, 151, 165, 33);
					panel_1.add(Label_Acc_Trade_Price_24h);
					Label_Acc_Trade_Price_24h.setFont(new Font("굴림", Font.PLAIN, 11));
					if(ATP > 0) {
						Label_Acc_Trade_Price_24h.setForeground(Color.RED);
					} else if (ATP < 0) {
						Label_Acc_Trade_Price_24h.setForeground(Color.BLUE);
					} else {
						Label_Acc_Trade_Price_24h.setForeground(Color.BLACK);
					}

					JLabel Label_Acc_Trade_Price = new JLabel();
					Label_Acc_Trade_Price.setText(Acc_Trade_Price + " KRW");
					Label_Acc_Trade_Price.setBounds(223, 199, 165, 33);
					panel_1.add(Label_Acc_Trade_Price);
					Label_Acc_Trade_Price.setFont(new Font("굴림", Font.PLAIN, 11));
					if(ATP_U > 0) {
						Label_Acc_Trade_Price.setForeground(Color.RED);
					} else if (ATP_U < 0) {
						Label_Acc_Trade_Price.setForeground(Color.BLUE);
					} else {
						Label_Acc_Trade_Price.setForeground(Color.BLACK);
					}

					JLabel Label_Highest_52_Week_Price = new JLabel();
					Label_Highest_52_Week_Price.setText(Highest_52_Week_Price + " KRW");
					Label_Highest_52_Week_Price.setBounds(223, 247, 165, 33);
					panel_1.add(Label_Highest_52_Week_Price);
					Label_Highest_52_Week_Price.setFont(new Font("굴림", Font.PLAIN, 11));

					JLabel Label_Highest_52_Week_Date = new JLabel();
					Label_Highest_52_Week_Date.setText(Highest_52_Week_Date);
					Label_Highest_52_Week_Date.setBounds(223, 296, 165, 33);
					panel_1.add(Label_Highest_52_Week_Date);
					Label_Highest_52_Week_Date.setFont(new Font("굴림", Font.PLAIN, 11));

					JLabel Label_Lowest_52_Week_Price = new JLabel();
					Label_Lowest_52_Week_Price.setText(Lowest_52_Week_Price + " KRW");
					Label_Lowest_52_Week_Price.setBounds(223, 343, 165, 33);
					panel_1.add(Label_Lowest_52_Week_Price);
					Label_Lowest_52_Week_Price.setFont(new Font("굴림", Font.PLAIN, 11));

					JLabel Label_Lowest_52_Week_Date = new JLabel();
					Label_Lowest_52_Week_Date.setText(Lowest_52_Week_Date);
					Label_Lowest_52_Week_Date.setBounds(223, 397, 165, 33);
					panel_1.add(Label_Lowest_52_Week_Date);
					Label_Lowest_52_Week_Date.setFont(new Font("굴림", Font.PLAIN, 11));

		JLabel Label_Menu_2 = new JLabel();
		Label_Menu_2.setBounds(12, 52, 187, 38);
		panel_1.add(Label_Menu_2);
		Label_Menu_2.setText("가장 최근 거래가");
		Label_Menu_2.setFont(new Font("HY중고딕", Font.PLAIN, 14));
				}
			}

			System.out.println(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
