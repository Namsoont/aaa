package com.bank.scaccount;

import java.util.Scanner;

public class ScAccountService {
	Scanner scn = new Scanner(System.in);
	
	public void maScAccount() {
		ScAccount sa = new ScAccount();
		
		System.out.println("계좌 번호 : ");
		String scaccountId	= scn.nextLine();
		System.out.println("회원 ID : ");
		String customId	= scn.nextLine();
		
		sa.setScaccountId(scaccountId);
		sa.setScmemberId(customId);
		
		int result = ScAccountManage.getInstance().insertScAccount(sa);
		if(result == 1) {
			System.out.println("계좌 이체 완료");
		} else {
			System.out.println("계좌 이체 실패");
		}
	}
	
	
	public void meney() {
		System.out.println("1.계좌 이체 | 2. 현금 결제");
		int cmd = Integer.parseInt(scn.nextLine());
		if(cmd == 1) {
			System.out.println("계좌 이체 > ");
			System.out.println("입급 할 금액 : ");
			int money = Integer.parseInt(scn.nextLine());
			
			int result = ScAccountManage.getInstance().updateMoney(money);
			
			if(result == 1 ) {
				System.out.println("입금 완료");
			}
		} else if (cmd == 2) {
			System.out.println("현금 결제는 현장에서");
		}
		
		
	}
	
}
