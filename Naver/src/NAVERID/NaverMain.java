package NAVERID;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		NaverSQL nsql = new NaverSQL();
		NMember nmember = new NMember(); // NMember 클래스  자체다
		
		boolean run = true;
		int menu = 0;
		
		do {
			System.out.println("==========================");
			System.out.println("1.DB접속    2.DB접속해체     3.회원가입");
			System.out.println("4.회원조회   5.회원정보수정   6.회원삭제");
			System.out.println("7.종료  ");
			System.out.println("==========================");
			System.out.print("메뉴 선택>>");
			
			menu = sc.nextInt();
			
			switch(menu){
			
			case 1 :
				// DB 접속
				nsql.connect();
				break;
			case 2 :
				// DB 접속 해제
				nsql.conClose();
				break;
			case 3 :
				// 회원가입
				System.out.println("회원정보를 입력해주세요.");
				System.out.print("아이디>> ");
				String n_id = sc.next();
				
				System.out.print("비밀번호>> ");
				String n_pw = sc.next();
				
				System.out.print("이름>> ");
				String n_name = sc.next();
				
				System.out.println("생년월일 ");
				System.out.print("년도(4자리)>> ");
				String year = sc.next();
				
				System.out.print("월>> ");
				int month = sc.nextInt();
				
				System.out.print("일>> ");
				int day = sc.nextInt();
				
				System.out.print("성별>> ");
				String n_gender = sc.next();
				
				System.out.print("이메일>> ");
				String n_email = sc.next();
				
				System.out.print("전화번호>> ");
				String n_phone = sc.next();
				
				// 1월부터 9월 사이에는 0을 붙히겠다
				String month1; // 전역변수
				String day1;
				
				if(month >=10 ) {
					month1 = Integer.toString(month); // 숫자를 문자로 바꾸겠다!!
				}else {
					month1 = "0" + Integer.toString(month);
				}
				// Integer.toString(num) ==> int num을 String num1로 바꾼다
				
				if(day >=10 ) {
					day1 = Integer.toString(day); 
				}else {
					day1 = "0" + Integer.toString(day);
				}
				
				// 지역변수	
				String n_birth = year + month1 + day1;
				// 	  20210722   2021 +   7   + 22
				
				nmember.setN_id(n_id);
				nmember.setN_pw(n_pw);
				nmember.setN_name(n_name);
				nmember.setN_birth(n_birth);
				nmember.setN_gender(n_gender);
				nmember.setN_email(n_email);
				nmember.setN_phone(n_phone);
				
				// System.out.println(nmember); 
				
				nsql.memberJoin(nmember); // NaverSQL에 보냄

				break;
			case 4 :
				// 회원조회
				nsql.select();
				break;
			case 5 :
				// 회원 정보 수정
				System.out.println("아이디 비밀번호 조회 ");
				System.out.print("아이디 >> ");
				String id = sc.next();
				System.out.print("비밀번호 >> ");
				String pw = sc.next();
				
				boolean check = nsql.idCheck(id,pw);
				
				if(check) { // 아이디와 비밀번호가 일치할 때
					System.out.println(id + "님의 회원정보를 수정해주세요.");
					
					System.out.print("비밀번호>> ");
					 String n_pw1 = sc.next();
					
					System.out.print("이름>> ");
					 String n_name1= sc.next();
					
					System.out.println("생년월일 ");
					System.out.print("년도(4자리)>> ");
					String year1 = sc.next();
					
					System.out.print("월>> ");
					 int month3 = sc.nextInt();
					
					System.out.print("일>> ");
					 int day3 = sc.nextInt();
					
					System.out.print("성별>> ");
					String n_gender1 = sc.next();
					
					System.out.print("이메일>> ");
					String n_email1 = sc.next();
					
					System.out.print("전화번호>> ");
					String n_phone1 = sc.next();
					
					
					String month4;
					String day4;
					
	
					if(month3 >=10 ) {
						 month4 = Integer.toString(month3); // 숫자를 문자로 바꾸겠다!!
					}else {
						 month4 = "0" + Integer.toString(month3);
					}
					// Integer.toString(num) ==> int num을 String num1로 바꾼다
					
					if(day3 >=10 ) {
						 day4 = Integer.toString(day3); 
					}else {
						 day4 = "0" + Integer.toString(day3);
					}
					
					// 지역변수	
					String n_birth1 = year1 + month4 + day4;
					// 	  20210722   2021 +   7   + 22
					
					nmember.setN_id(id);
					nmember.setN_pw(n_pw1);
					nmember.setN_name(n_name1);
					nmember.setN_birth(n_birth1);
					nmember.setN_gender(n_gender1);
					nmember.setN_email(n_email1);
					nmember.setN_phone(n_phone1);
					
					nsql.modify(nmember);
					
					
				}else {		// 일치하지 않을 때 
					System.out.println("아이디와 비밀번호가 일치하지 않습니다!!");
				}
							
				break;
			case 6 :
				// 회원 삭제
				System.out.println("아이디 비밀번호 조회 ");
				System.out.print("아이디 >> ");
				String id1 = sc.next();
				System.out.print("비밀번호 >> ");
				String pw1 = sc.next();
				
				boolean check1 = nsql.idCheck(id1,pw1);
				
				if(check1) { // 아이디 비밀번호 일치o
					nsql.delete(id1);
				}else { // 비밀번호가 일치x
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
					
				}
				
				
				break;
			case 7 :		// 음식 이름으로 찾기
				System.out.println("찾으실 음식 이름을 입력해 주세요!");
				String FName = sc.next();
				//boolean find = nsql.searchN(FName);

				break;
			default :
				System.out.println("잘못 입력했습니다. 다시 입력해주세요!");
				break;
					
			}
			

			
		}
		while(run);
	}

}
