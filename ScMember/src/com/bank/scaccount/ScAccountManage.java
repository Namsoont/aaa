package com.bank.scaccount;

import java.util.ArrayList;
import java.util.List;


import com.sc.common.DAO;

public class ScAccountManage extends DAO{
	
	private static ScAccountManage sa = new ScAccountManage();
	
	private ScAccountManage() {
		
	}
	
	public static ScAccountManage getInstance() {
		return sa;
	}
	//계좌 개설
	public int insertScAccount(ScAccount scaccount) {
		int result = 0;
		try {
			conn();
			String sql = "insert into scaccount (scaccount_id, scmember_id) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scaccount.getScaccountId());
			pstmt.setString(2, scaccount.getScmemberId());
			result = pstmt.executeUpdate();
	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//입금
	public int updateMoney(ScAccount scaccount, int cmd) {
		int result = 0;
		
		try {
			conn();
			String sql2 = "select blance from scaccount where scaccount_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, scaccount.getScaccountId());
			rs = pstmt.executeQuery();
			
			int balance = 0;
			if(rs.next()) {
				balance = rs.getInt("blance");
			}
			if (cmd == 1) {
				scaccount.setBalance(balance + scaccount.getBalance());
	
				String sql = "update scaccount set blance = ? where scaccount_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, scaccount.getBalance());
				pstmt.setString(2, scaccount.getScaccountId());
				int result2 = pstmt.executeUpdate();
				if(result2 == 1) {
					System.out.println("계좌 이체 완료");
				} else {
					System.out.println("계좌 이체 실패");
					
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return result;
	}
	public List<ScAccount> getAccountList(String scmemberId)	{
		List<ScAccount> list = new ArrayList<>();
		ScAccount scaccount = null;
		
		try {
			conn();
			String sql = "SELECT * FROM scaccount where scmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scmemberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				scaccount = new ScAccount();
				scaccount.setScaccountId(rs.getString("scaccount_id"));
				scaccount.setScmemberId(rs.getString("scmember_id"));
				scaccount.setCredate(rs.getDate("creDate"));
				scaccount.setBalance(rs.getInt("balancr"));
				list.add(scaccount);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	
}




