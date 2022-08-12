package com.sc.Ground;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sc.Member.MemberService;
import com.sc.common.DAO;

public class GroundDAO extends DAO {

	private static GroundDAO groundDao = null;

	private GroundDAO() {

	}

	public static GroundDAO getInstance() {
		return groundDao == null ? groundDao = new GroundDAO() : groundDao;
	}

	Calendar cal = Calendar.getInstance();
//9시부터 저녁 9시까지 	

	public int reserveGround(Ground ground, Date date) {
		int result = 0;
		try {
			conn();
			String sql = "insert into ground(ground_name,ground_time,scmember_id,ground_date) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ground.getGroundName());
			pstmt.setString(2, ground.getGroundTime());
			pstmt.setString(3, MemberService.memberInfo.getScmemberId());
			pstmt.setDate(4, date);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	public boolean checkGround(Ground ground, Date date) {
		try {
			conn();
			String sql = "select * from ground where ground_time = ? and ground_date = ? and ground_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ground.getGroundTime());
			pstmt.setDate(2, date);
			pstmt.setString(3, ground.getGroundName());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return true;
	}

	public List<Ground> getList1() {
		List<Ground> list = new ArrayList<>();
		Ground ground1 = null;
		try {
			conn();
			String sql = "SELECT * from ground order by ground_date asc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ground1 = new Ground();
				ground1.setScmemberId(rs.getString("scmember_Id"));
				ground1.setGroundDate(rs.getDate("ground_date"));
				ground1.setGroundTime(rs.getString("ground_time"));
				ground1.setGrBall(rs.getString("gr_Ball"));
				ground1.setgrVest(rs.getString("gr_vest"));
				ground1.setGrPrise(rs.getString("gr_Prise"));
				ground1.setGroundName(rs.getString("ground_name"));
				ground1.setScmemberName(rs.getString("scmember_Name"));
				ground1.setGrPrise(sql);
				list.add(ground1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<Ground> getList() {
		List<Ground> list = new ArrayList<>();
		Ground ground = null;
		try {
			conn();
			String sql = "SELECT * from ground where scmember_id = ? order by ground_date asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getScmemberId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ground = new Ground();
				ground.setScmemberId(rs.getString("scmember_Id"));
				ground.setGroundDate(rs.getDate("ground_date"));
				ground.setGroundTime(rs.getString("ground_time"));
				ground.setGrBall(rs.getString("gr_Ball"));
				ground.setgrVest(rs.getString("gr_vest"));
				ground.setGrPrise(rs.getString("gr_Prise"));
				ground.setGroundName(rs.getString("ground_name"));
				ground.setScmemberName(rs.getString("scmember_Name"));
				list.add(ground);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<Ground> adminGetList() {
		List<Ground> list = new ArrayList<>();
		Ground ground = null;
		try {
			conn();
			String sql = "SELECT * from ground";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ground = new Ground();
				ground.setGroundName(rs.getString("ground_name"));
				ground.setGroundTime(rs.getNString("ground_time"));
				ground.setScmemberId(rs.getString("scmember_id"));
				list.add(ground);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public int getMonthlySum(int month) {
		String strMonth = String.valueOf(month);
		if (strMonth.length() == 1) {
			strMonth = "0" + strMonth;
		}
		String strStartDate = "2022-" + strMonth + "-01";
		Date startDate = Date.valueOf(strStartDate);

		cal.set(2022, month - 1, 1);
		int intGetEndDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		String strGetEndDate = String.valueOf(intGetEndDate);
		String strEndDate = "2022-" + strMonth + "-" + strGetEndDate;
		Date endDate = Date.valueOf(strEndDate);
		int sum = 0;
		try {
			conn();
			String sql = "select balance from scaccount where (credate > ? and credate < ?) or credate = ? or credate = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			pstmt.setDate(3, startDate);
			pstmt.setDate(4, endDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sum += rs.getInt("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return sum;
	}

	public List<Sales> getMonthlyDailySum(String month) {
		List<Sales> list = new ArrayList<>();
		Sales sales = null;

//		if (month.length() == 1) {
//			month = "0" + month;
//		}

		Date startDate = Date.valueOf(month);

//		cal.set(2022, month, 1);
//		int intGetEndDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//		String strGetEndDate = String.valueOf(intGetEndDate);
//		String strEndDate = "2022-" + strMonth + "-"+strGetEndDate;
//		Date endDate = Date.valueOf(strEndDate);

		try {
			conn();
			String sql = "select sum(balance) sum from scaccount where to_char(credate,'yyyy-mm-dd') = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, startDate);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				sales = new Sales();

				sales.setSum(rs.getInt("sum"));
				list.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}
}
