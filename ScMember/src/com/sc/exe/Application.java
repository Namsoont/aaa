package com.sc.exe;

import java.util.Scanner;

import com.sc.Member.MemberService;

public class Application {
	Scanner scn = new Scanner(System.in);
	MemberService ss = new MemberService();
	
	int menuNo = 0;
	
	public Application() {
		run();
	}
	private void run() {
		System.out.println("1.로그인 | 2. 종료");
		menuNo = Integer.parseInt(scn.nextLine());
		switch(menuNo) {
		case 1:
			ss.doLogin();
			if(MemberService.memberInfo != null) {
				
				new ManageMent();
				
			}
			break;
		}
	}
	
}
