package com.sc.Member;

import com.sc.common.DAO;

public class MemberDAO extends DAO {
	
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDao == null ? memberDao = new MemberDAO() : memberDao;
		
	}

	//회원 수정
	public int updateTel(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update scmember set scmember_tel = ? where scmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getScmemberTel());
			pstmt.setString(2, member.getScmemberId());
			
			result = pstmt.executeUpdate();
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//회원 정보 삭제
	public int deleteMember(String scmemberId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from scmember where scmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scmemberId);
			
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		return result;
	}
	
}
