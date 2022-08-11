package com.sc.exe;

import java.util.Scanner;

import com.bank.scaccount.ScAccountService;
import com.sc.Ground.GroundManage;
import com.sc.Member.MemberManage;
import com.sc.Member.MemberService;

public class ManageMent {
	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();
	ScAccountService as = new ScAccountService();
	GroundManage gm = new GroundManage();
	int menuNo = 0;

	public ManageMent() {
		scground();
	}

	private void scground() {
		while (true) {
			menuInfo();

			if (MemberService.memberInfo.getRole().equals("1")) {
				if (menuNo == 1) {
					ms.registerCustomer();
				} else if (menuNo == 2) {
					as.maScAccount();
				} else if (menuNo == 3) {
					ms.getMember();
				} else if (menuNo == 4) {
					ms.updateTel();
				} else if (menuNo == 5) {
					ms.deleteMemer();
				} else if (menuNo == 6) {
					gm.adminGetGround();
				} else if (menuNo == 7) {
					sumMenuInfo();
					int selectNo = Integer.parseInt(scn.nextLine());
					if (selectNo == 1) {
						gm.getMonthlySum();
					} else if (selectNo == 2) {
						gm.getMonthlyDailySum();
					}
				} else if (menuNo == 9) {
					ms.logout();
					return;
				}
			} else if (MemberService.memberInfo.getRole().equals("0")) {
				if (menuNo == 1) {
					gm.reserveGround();
				} else if (menuNo == 2) {
					as.meney();

				} else if (menuNo == 3) {
					gm.getGround();

				} else if (menuNo == 4) {
					ms.logout();
					return;
				}
			}
		}

	}

	private void menuInfo() {

		if (MemberService.memberInfo.getRole().equals("1")) {

			System.out.println(
					"1.회원 등록 | 2. 관리자 계좌개설 | 3. 회원 조회 | 4. 회원 수정 | 5. 회원 삭제  | 6. 구장예약조회 | 7. 매출 조회 | 9. 로그인 아웃");
		}

		else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("1.구장예약 | 2. 입금 | 3. 예약조회 | 4. 로그인 아웃 ");
		}
		System.out.println("입력 : ");
		menuNo = Integer.parseInt(scn.nextLine());
	}

	private void sumMenuInfo() {
		System.out.println("1. 월 매출 | 2. 월 일별 조회  ");
		System.out.println("선택 하세요 : ");
	}

}
