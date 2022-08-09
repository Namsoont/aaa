package com.sc.Member;

import java.sql.Date;

/*
 * 
SCMEMBER_ID   NOT NULL VARCHAR2(20) 
SCMEMBER_PW            VARCHAR2(20) 
SCMEMBER_NAME          VARCHAR2(20) 
SCPRISE                NUMBER       
ROLE                   CHAR(1)  
 */
public class Member {

		private String scmemberId; //회원 아이디
		private String scmemberPw; // 회원 패스워드
		private String scmemberName; //회원 이름
		private String scmemberTel; //회원 전화번호
		private String Role; // 관리자
		private Date scmemberdate;
		
		
		
		public Date getScmemberdate() {
			return scmemberdate;
		}
		public void setScmemberdate(Date scmemberdate) {
			this.scmemberdate = scmemberdate;
		}
		public String getScmemberTel() {
			return scmemberTel;
		}
		public void setScmemberTel(String scmemberTel) {
			this.scmemberTel = scmemberTel;
		}
		@Override
		public String toString() {
			return "회원아이디 : [scmemberId=" + scmemberId + ", 회원 이름 : =" + scmemberName + ", 회원 전화 번호 : ="
					+ scmemberTel + "]";
		}
		public String getScmemberId() {
			return scmemberId;
		}
		public void setScmemberId(String scmemberId) {
			this.scmemberId = scmemberId;
		}
		public String getScmemberPw() {
			return scmemberPw;
		}
		public void setScmemberPw(String scmemberPw) {
			this.scmemberPw = scmemberPw;
		}
		public String getScmemberName() {
			return scmemberName;
		}
		public void setScmemberName(String scmemberName) {
			this.scmemberName = scmemberName;
		}
		
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		
		
		
		
		
}
