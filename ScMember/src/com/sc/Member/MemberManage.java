package com.sc.Member;

import java.util.ArrayList;
import java.util.List;

import com.sc.common.DAO;

public class MemberManage extends DAO {

	private static MemberManage mm = new MemberManage();

	private MemberManage() {

	}

	public static MemberManage getInstance() {
		return mm;
	}

	// 로그인
	public Member loginInfo(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from scmember where scmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setScmemberId(rs.getString("scmember_id"));
				member.setScmemberPw(rs.getString("scmember_pw"));
				member.setScmemberName(rs.getString("scmember_name"));
				member.setRole(rs.getString("role"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;

	}

	// 회원 등록
	public int registCustomer(Member member) {
		int result = 0;

		try {
			conn();

			String sql = "insert into scmember (scmember_id, scmember_pw, scmember_name, role) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getScmemberId());
			pstmt.setString(2, member.getScmemberPw());
			pstmt.setString(3, member.getScmemberName());
			pstmt.setString(4, member.getRole());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 회원 정보조회
	public List<Member> getList(String scmemberId) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT * from scmember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				member = new Member();
				member.setScmemberId(rs.getString("scmember_id"));
				member.setScmemberName(rs.getString("scmember_name"));
				member.setScmemberTel(rs.getNString("scmember_tel"));
				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
