package Main_Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	// 로그인
	public boolean list(MemberVo p) {
		try {
			connDB();
			
			String query = "SELECT * FROM login WHERE id='" + p.getId()
			+ "' AND password='" + p.getPassword() + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
				System.out.println("0 row selected...");
			}else {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean IDCheck(MemberVo p) {
		try {
			connDB();
			
			String query = "SELECT id FROM login WHERE id='" + p.getId()+"'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
				System.out.println("0 row selected...");
			}else {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean SignUp(MemberVo p) {
		try {
			connDB();
			
			String query = "INSERT INTO LOGIN VALUES('"+p.getId()+"','"+p.getPassword()+"','"+p.getName()+"','"+p.getEmail()+"')";
			
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
	
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
				System.out.println("0 row selected...");
			}else {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.\n");
		}catch(Exception e) {	
			e.printStackTrace();
		}
	}
	
}
