package NAVERID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NaverSQL {
	// 쿼리문을 모아 놓은 클래스 NaverSQL
	
	// DB 접속을 위한 변수 선언
	Connection con = null;
	
	// DB로 쿼리문 전송을 위한 변수 선언
	Statement stmt = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : ? 를 문자로 인식!, 정보를 가지고 와서 정보를 담아서 DB에 넘긴다 
	
	// 조회(SELECT)의 결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	// 1.DB접속 메소드!!
	public void connect() {
		con = DBC.DBConnect();
	}
	
	// 2.DB접속 해제 메소드!!
	// con.close -> 기본 메소드이다.
	public void conClose() {
		try {
			con.close();
			System.out.println("DB 접속 해제!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 3. 회원가입 메소드
	public void memberJoin(NMember nmember) {
		//System.out.println("3.회원가입 메소드로 잘 넘어왔나?");
		//System.out.println(nmember);
		//System.out.println("con : " +con);
		
		String sql = "INSERT INTO NAVER VALUES(?,?,?,TO_DATE(?),?,?,?)";
												 // 문자를 날짜로 바꾼다!!
		
		try {
			// DB로 보내기!!
			pstmt = con.prepareStatement(sql); // 작성하면 빨간줄에 try catch문 자동생성
			//pstmt.setString(parameterIndex, x);
							// 몇번째 물음표에 어떤 값을 넣을건지
			pstmt.setString(1, nmember.getN_id());
			pstmt.setString(2, nmember.getN_pw());
			pstmt.setString(3, nmember.getN_name());
			pstmt.setString(4, nmember.getN_birth());
			pstmt.setString(5, nmember.getN_gender());
			pstmt.setString(6, nmember.getN_email());
			pstmt.setString(7, nmember.getN_phone());
			
			int result = pstmt.executeUpdate(); // 값 넣은 것을 실행하라!! *int result를 뺴도된다.

			if(result>0) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패!");
			}
	
		} catch (SQLException e) {
			System.out.println("SQLException 발생!!");
			e.printStackTrace();
		} finally {	// 무조건 발생한다.
			try {
				pstmt.close(); // 닫아준다.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	// 4. 회원 조회 메소드
	public void select() {
		
		// SQL문 작성
		String sql = " SELECT *FROM NAVER ";
		
		try {
			stmt = con.createStatement();	
			rs = stmt.executeQuery(sql); // sql문을 실행하면 정보들을 담아서 rs에 넣겠다.
			// stmt는 sql을 넣어줘야 하지만, pstmt는 sql을 넣으면 안된다.
			while(rs.next()) { // rs.next() : 데이터의 갯수 만큼 true값, 지나면 false
							  // 레코드(저장된값)가 더 이상 존재하지 않을때까지 반복
				
				// rs.getString(컬럼순서 ) : rs.getString(1)
				// rs.getString("컬럼이름") : rs.getString("N_ID)
				System.out.println();
				System.out.println("아이디 : " + rs.getString(1));				
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("연락처 : " + rs.getString(7));
				System.out.println();
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	// 5-1.,6-1 아아디,비밀번호 체크 메소드

	public boolean idCheck(String id, String pw) {
		
		// (1) 메소드 데이터타입과 같은 변수 만들고 초기 값 선언하기!
		boolean checkResult = false;
		
		String sql = "SELECT N_ID FROM NAVER WHERE N_ID = ? AND N_PW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			
			// SELECT문의 짝꿍 RESULTSET RS
			rs = pstmt.executeQuery();
			if(rs.next()) { // 결과 값이 존재o
				checkResult = true;
				
			}else {// 결과 값이 존재x
				checkResult = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		// (2) 만들어준 변수를 return 하기!
		return checkResult;
	}

	
	// 5-2 회원정보 수정 메소드
	public void modify(NMember nmember) {
		
		String sql = "UPDATE NAVER SET N_PW = ?, N_NAME = ?, N_BIRTH=TO_DATE(?),N_GENDER=?,N_EMAIL =?,N_PHONE = ? WHERE N_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, nmember.getN_pw());
			pstmt.setString(2, nmember.getN_name());
			pstmt.setString(3, nmember.getN_birth());
			pstmt.setString(4, nmember.getN_gender());
			pstmt.setString(5, nmember.getN_email());
			pstmt.setString(6, nmember.getN_phone());
			pstmt.setString(7, nmember.getN_id());
			
			
			// INSERT,UPDATE,DELETE문의 짝꿍 int result
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원 정보 수정 성공!");
			}else {
				System.out.println("회원 정보 수정 실패!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	// 6. 회원삭제 메소드

	public void delete(String id1) {
		String sql = "DELETE NAVER WHERE N_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id1);
			
			int result = pstmt.executeUpdate(); // db 실행
			
			if(result>0){
				System.out.println("회원정보 삭제 성공!");
			}else {
				System.out.println("회원정보 삭제 실패!");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

		public void searchN(String fName) {
			// TODO Auto-generated method stub
			
		
			String sql = "SELECT * FROM FOOD";

				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
	}
	
	
	
	
	
	
	
	
	
}
