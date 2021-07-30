package BANK;

public class Client {
	private String accountno;	// 계좌번호
	private int clientNo;		// 회원번호
	private String cName;		// 회원이름
	private int balance;		// 잔액
	
	// getter, setter
	public int getClientNo() {
		return clientNo;
	}
	public void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// toString
	@Override
	public String toString() {
		return "Client [clientNo=" + clientNo + ", cName=" + cName + ", accountno=" + accountno + ", balance=" + balance
				+ "]";
	}
	
	
	public Client() {
		super();
	}
	public Client(String accountno, int clientNo, String cName, int balance) {
		super();
		this.accountno = accountno;
		this.clientNo = clientNo;
		this.cName = cName;
		this.balance = balance;
	}

	
	// Constructor
	

	
	// 데이터베이스에 BANK테이블
	// 필드값을 컬럼으로 지정해서 만들기!
	// 회원번호를 pk로 지정

}
