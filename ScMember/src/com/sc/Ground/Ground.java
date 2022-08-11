package com.sc.Ground;
/*
 * 
GROUND_NAME NOT NULL VARCHAR2(50)  
GROUND_TIME          VARCHAR2(100) 
GR_PRISE             VARCHAR2(20)  
GR_BALL              VARCHAR2(20)  
GR_VEST              VARCHAR2(20) 
 */

public class Ground {

	private String groundName; // 구장이름
	private String groundTime; // 구장 시간
	private String grPrise; // 구장 가격
	private String grBall; // 공가격
	private String Vest; // 조끼 가격
	private String scmemberId; // 예약자ID
	private String scmemberName; //예약자 이름

	
	public String getScmemberName() {
		return scmemberName;
	}

	public void setScmemberName(String scmemberName) {
		this.scmemberName = scmemberName;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public String getGroundTime() {
		return groundTime;
	}

	public void setGroundTime(String groundTime) {
		this.groundTime = groundTime;
	}

	public String getGrPrise() {
		return grPrise;
	}

	public void setGrPrise(String grPrise) {
		this.grPrise = grPrise;
	}

	public String getGrBall() {
		return grBall;
	}

	public void setGrBall(String grBall) {
		this.grBall = grBall;
	}

	public String getVest() {
		return Vest;
	}

	public void setVest(String vest) {
		Vest = vest;
	}

	public String getScmemberId() {
		return scmemberId;
	}

	public void setScmemberId(String scmemberId) {
		this.scmemberId = scmemberId;
	}

	@Override
	public String toString() {
		return "Ground [구장이름 : =" + groundName + ", 구장 시간 : =" + groundTime + "]";
	}

}
