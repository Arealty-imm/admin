package w_admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";	//Query문법
	//int result = 0; //글 내용을 수정할때는 필수, 보여주기만 할때는 필요없음
	m_dbinfo db = new m_dbinfo(); //database 정보
	
	ArrayList<String> db_data = null; //한개의 데이터 그룹만 저장시킴
	
	public void viewcount(int nidx) {
		try {
			this.con = this.db.db_info();
			//해당 컬럼에 값을 +1씩 증가시키는 Query문
			this.sql = "update notice set nview=nview+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx); //setInt : nidx 자료형이 int 이므로 
			this.ps.executeUpdate(); //Query문을 실행!!
			
			//해당 테이블에 맞는 컬럼 값을 SELECT
			this.sql = "SELECT * from notice where nidx=? order by nidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) { //해당 조건에 맞는 데이터가 있을 경우
				this.db_data = new ArrayList<String>();
				this.db_data.add(this.rs.getString("nidx"));
				this.db_data.add(this.rs.getString("ncheck"));
				this.db_data.add(this.rs.getString("subject"));
				this.db_data.add(this.rs.getString("writer"));
				this.db_data.add(this.rs.getString("texts"));
				this.db_data.add(this.rs.getString("filenm"));
				this.db_data.add(this.rs.getString("nfile"));
				this.db_data.add(this.rs.getString("nview"));
				this.db_data.add(this.rs.getString("ndate"));
			}
			else {
				System.out.println("데이터없음");
			}
		}catch(Exception e) {
			
		}finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
	}
}
