package com.sc.Member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner scn = new Scanner(System.in);

	public static Member memberInfo = null;

	public void doLogin() {
		Member member = new Member();
		System.out.println("ID : ");
		String id = scn.nextLine();
		System.out.println("PW : ");
		String pw = scn.nextLine();

		member = MemberManage.getInstance().loginInfo(id);
		if (member.getScmemberPw().equals(pw)) {
			memberInfo = member;
		} else {
			System.out.println("로그인 실패");
		}
	}

	// 로그아웃
	public void logout() {
		if (memberInfo != null)
			memberInfo = null;
	}

	// 회원 등록
	public void registerCustomer() {
		Member member = new Member();
		System.out.println("회원 ID : ");
		String id = scn.nextLine();
		System.out.println("회원 PW : ");
		String pw = scn.nextLine();
		System.out.println("회원 이름 : ");
		String name = scn.nextLine();

		member.setScmemberId(id);
		member.setScmemberPw(pw);
		member.setScmemberName(name);
		member.setRole("0");

		int result = MemberManage.getInstance().registCustomer(member);

		if (result == 1) {
			System.out.println("회원 등록 완료");
		} else {
			System.out.println("회원 등록 실패");
		}

	}
	public void updateTel() {
		Member member = new Member();
		System.out.println("수정할 회원 ID : ");
		String memberId = scn.nextLine();
		
		System.out.println("Tel 변경 : ");
		String membertel = scn.nextLine();
		
		member.setScmemberId(memberId);
		member.setScmemberTel(membertel);
		
		int result = MemberDAO.getInstance().updateTel(member);
		
		
				
		
		
		
	}
	
	// 회원 정보 조회
	public void getMember() {
		List<Member> list = MemberManage.getInstance().getList(memberInfo.getScmemberId());
		for (Member member : list) {
			System.out.println("이름 " + member.getScmemberName() + ", ID : " + member.getScmemberId() + ", 전화번호 : "
					+ member.getScmemberTel());
		}

	}

	// 회원 삭제
	public void deleteMemer() {
		System.out.println("삭제 할 회원 ID : ");
		String memberId = scn.nextLine();

		int result = MemberDAO.getInstance().deleteMember(memberId);

		if (result == 1) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
