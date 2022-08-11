package com.bank.scaccount;

import java.util.ArrayList;
import java.util.List;

import com.sc.common.DAO;

public class ScAccountManage extends DAO {

	private static ScAccountManage sa = new ScAccountManage();

	private ScAccountManage() {

	}

	public static ScAccountManage getInstance() {
		return sa;
	}

	public int insertScAccount(ScAccount scaccount) {
		int result = 0;
		try {
			conn();
			String sql = "insert into scaccount (scaccount_id, scmember_id) values(?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, scaccount.getScaccountId());
			pstmt.setString(2, scaccount.getScmemberId());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	public int updateMoney(int money) {
		int result = 0;

		try {
			conn();
			if (money > 0) {
				String sql = "insert into scaccount(scaccount_id,scmember_id,balance) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "20220808-08");
				pstmt.setString(2, "knn");
				pstmt.setInt(3, money);
				int result2 = pstmt.executeUpdate();
				if (result2 == 1) {
					System.out.println("계좌 이체 완료");
				} else {
					System.out.println("계좌 이체 실패");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return result;
	}

	public List<ScAccount> getAccountList(String scmemberId) {
		List<ScAccount> list = new ArrayList<>();
		ScAccount scaccount = null;

		try {
			conn();
			String sql = "SELECT * FROM scaccount where scmember_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, scmemberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				scaccount = new ScAccount();
				scaccount.setScaccountId(rs.getString("scaccount_id"));
				scaccount.setScmemberId(rs.getString("scmember_id"));
				scaccount.setCredate(rs.getDate("creDate"));
				scaccount.setBalance(rs.getInt("balance"));
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
