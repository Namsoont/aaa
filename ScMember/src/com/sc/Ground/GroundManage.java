package com.sc.Ground;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.sc.common.DAO;

public class GroundManage extends DAO {
	Scanner scn = new Scanner(System.in);
	public static Ground groundInfo = null;

	public void reserveGround() {
		Ground ground = new Ground();
		System.out.println("구장 이름을 적으시오 ('A','B','C')");
		System.out.print("★★★★★★★구장비: 30000원★★★★★★★ \n구장 선택: ");
		String groundName = scn.nextLine();
		System.out.println("| 1.9~11 | 2.11~13 | 3.13~15 | 4.15~17 | 5.17~19 | 6.19~21 |");
		System.out.println("이용 시간을 적으시오");
		System.out.print("입력 > ");
		int intGroundTime = Integer.parseInt(scn.nextLine());
		String groundTime = "";
		switch (intGroundTime) {
		case 1:
			groundTime = "09:00~11:00";
			break;
		case 2:
			groundTime = "11:00~13:00";
			break;
		case 3:
			groundTime = "13:00~15:00";
			break;
		case 4:
			groundTime = "15:00~17:00";
			break;
		case 5:
			groundTime = "17:00~19:00";
			break;
		case 6:
			groundTime = "19:00~21:00";
			break;
		}
		System.out.print("이용 날짜를 입력하시오 > ");
		// EX) 2022-08-11
		String strDate = scn.nextLine();
		Date date = Date.valueOf(strDate);
		ground.setGroundName(groundName);
		ground.setGroundTime(groundTime);
		if (GroundDAO.getInstance().checkGround(ground, date)) {
			int result2 = GroundDAO.getInstance().reserveGround(ground, date);
			System.out.println(result2 == 1 ? "예약이 완료되었습니다" : "예약에 실패하였습니다");
		} else {
			System.out.println("이미 예약된 구장입니다");
		}
	}

	public void adminGetGround() {
		List<Ground> list = GroundDAO.getInstance().getList1();
		for (Ground ground : list) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("예약자 ID : " + ground.getScmemberId() + " 구장이름:" + ground.getGroundName() + " 이용시간:"
					+ ground.getGroundTime() + " 예약 날짜 : " + ground.getGroundDate());
			
			
		}
	}

	public void getGround() {
		List<Ground> list = GroundDAO.getInstance().getList();
		for (Ground ground : list) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦구장이름: " + ground.getGroundName() + "이용시간:" + ground.getGroundTime() + " 이용 날짜 : "
					+ ground.getGroundDate()+" ▦");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦ 대   여  비 ▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦ 공:10000원 ▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦ 조끼:15000원 ▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		}
	}

	public void getMonthlySum() {
		System.out.print("확인하고자 하는 년도 와 월을 입력하시오 > ");
		// String 값으로 받고 substring써서
		String strMonth = scn.nextLine();
		String subStrMonth = strMonth.substring(strMonth.length() - 2, strMonth.length());
		int a = Integer.parseInt(subStrMonth);

		int result = GroundDAO.getInstance().getMonthlySum(a);
		System.out.println(a + "월의 매출은 " + result + "원 입니다.");
	}

	public void getMonthlyDailySum() {
		System.out.print("년 월 일 을 적으시오 : ");
		String month = scn.nextLine();
		List<Sales> list = GroundDAO.getInstance().getMonthlyDailySum(month);
		for (Sales sales : list) {
			System.out.println(month + " : " + sales.getSum() + "원");
		}
	}
}
