package com.sc.exe;

import java.util.Scanner;

import com.bank.scaccount.ScAccountService;
import com.sc.Member.MemberService;

public class ManageMent {
	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();
	ScAccountService as = new ScAccountService();

	int menuNo = 0;

	public ManageMent() {
		scground();
	}

	private void scground() {
		while (true) {
			menuInfo();

			if (MemberService.memberInfo.getRole().equals("1")) {
				if (menuNo == 1) {
					// 회원 등록
					ms.registerCustomer();
				} else if (menuNo == 2) {
					//계좌등록
					as.maScAccount();
										
				} else if (menuNo == 3) {
					ms.getMember();
				} else if (menuNo == 4) {
					
				} else if (menuNo == 5) {

				} else if (menuNo == 6) {
					ms.deleteMemer();

				
				}
			} else if (MemberService.memberInfo.getRole().equals("0")) {
				if (menuNo == 1) {
					
				} else if (menuNo == 2) {
					as.meney();
					
					
				} else if (menuNo == 3) {
					
					
				} else if (menuNo == 4) {
					
				} else if (menuNo == 5) {
				}
			}
		}
		
	}

	private void menuInfo() {
		
		if (MemberService.memberInfo.getRole().equals("1")) {

			System.out.println("1.회원 등록 | 2. 관리자 계좌개설 | 3. 회원 조회 | 4. 회원 수정 | 5. 회원 삭제  | 6.  ");
		}
		
		else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("1.구장예약조회 | 2. 입금 | 3.  | 4. ");
		}
		System.out.println("입력 : ");
		menuNo = Integer.parseInt(scn.nextLine());

	}
}
