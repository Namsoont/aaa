package com.sc.exe;

import java.util.Scanner;

import com.sc.Member.MemberService;

public class Application {
	Scanner scn = new Scanner(System.in);
	MemberService ss = new MemberService();

	int menuNo = 0;
	boolean a = true;

	public Application() {
		run();
	}

	private void run() {
		while (a) {
			System.out.println("1.로그인 | 2. 종료");
			menuNo = Integer.parseInt(scn.nextLine());
			switch (menuNo) {
			case 1:
				ss.doLogin();
				if (MemberService.memberInfo != null) {

					new ManageMent();
					break;
				}
			case 2:
				System.out.println("종료");
				ss.logout();
				a = false;
				break;
			}

		}
	}

}
