package admin_siteinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import w_admin.m_dbinfo;

public class insert_siteinfo {
	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	String sql;
	int result;
	
	public int insert_siteinfo(siteinfo_dto dto) {
		try {
			this.con = this.db.db_info();
			this.sql = "insert into siteinfo values ('0', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, dto.getPageName());
			this.ps.setString(2, dto.getAdminMail());
			this.ps.setString(3, dto.getUsePoint());
			this.ps.setInt(4, dto.getWelcomePoints());
			this.ps.setString(5, dto.getUserLevel());
			this.ps.setString(6, dto.getCorpName());
			this.ps.setString(7, dto.getBusinessNo());
			this.ps.setString(8, dto.getCeoName());
			this.ps.setString(9, dto.getCeoTel());
			this.ps.setString(10, dto.getLicenseNo());
			this.ps.setString(11, dto.getVasLicenseNo());
			this.ps.setString(12, dto.getCorpPost());
			this.ps.setString(13, dto.getCorpAddr());
			this.ps.setString(14, dto.getInfoMgr());
			this.ps.setString(15, dto.getInfoMgrEmail());
			this.ps.setString(16, dto.getBankName());
			this.ps.setString(17, dto.getAccountNum());
			this.ps.setString(18, dto.getUseCard());
			this.ps.setString(19, dto.getUsePhone());
			this.ps.setString(20, dto.getUseGiftcard());
			this.ps.setInt(21, dto.getMinUsePoint());
			this.ps.setInt(22, dto.getMaxUsePoint());
			this.ps.setString(23, dto.getCashReceipt());
			this.ps.setString(24, dto.getDeliveryCorp());
			this.ps.setInt(25, dto.getDeliveryPay());
			this.ps.setString(26, dto.getDeliveryDate());
			
			this.result = this.ps.executeUpdate();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return result;
	}
}
