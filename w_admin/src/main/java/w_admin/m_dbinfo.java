package w_admin;

import java.sql.Connection;
import java.sql.DriverManager;


public class m_dbinfo {
	public static Connection db_info() {
		String db = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://kbsn.or.kr:3306/chang_a"; 
		String db_user = "chang_a"; 
		String db_pass = "aclass2025"; 
		Connection con = null;
		try {
			Class.forName(db); //라이브러리 사용
			con = DriverManager.getConnection(db_url, db_user, db_pass);
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Database 연결실패!");
		}
		return con;
	}
}