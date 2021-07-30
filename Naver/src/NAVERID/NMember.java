package NAVERID;

public class NMember {
	
	// 데이터베이스에 있는 컬럼들을(테이블에 만든 컬럼) 클래스의 필드로 선언

	/*
	
    N_ID        NVARCHAR2(20),
    N_PW        NVARCHAR2(16),
    N_NAME      NVARCHAR2(5),
    N_BIRTH     DATE,
    N_GENDER    NVARCHAR2(2),
    N_EMAIL     NVARCHAR2(50),
    N_PHONE     NVARCHAR2(20)


	 */
	
	private String N_id;
	private String N_pw;
	private String N_name;
	private String N_birth ;
	private String N_gender;
	private String N_email ;
	private String N_phone;
	
	
	// getter, setter
	
	public String getN_id() {
		return N_id;
	}
	public void setN_id(String n_id) {
		this.N_id = n_id;
	}
	public String getN_pw() {
		return N_pw;
	}
	public void setN_pw(String n_pw) {
		this.N_pw = n_pw;
	}
	public String getN_name() {
		return N_name;
	}
	public void setN_name(String n_name) {
		this.N_name = n_name;
	}
	public String getN_birth() {
		return N_birth;
	}
	public void setN_birth(String n_birth) {
		this.N_birth = n_birth;
	}
	public String getN_gender() {
		return N_gender;
	}
	public void setN_gender(String n_gender) {
		this.N_gender = n_gender;
	}
	public String getN_email() {
		return N_email;
	}
	public void setN_email(String n_email) {
		this.N_email = n_email;
	}
	public String getN_phone() {
		return N_phone;
	}
	public void setN_phone(String n_phone) {
		this.N_phone = n_phone;
	}
	
	
	// toString
	
	@Override
	public String toString() {
		return "NMember [N_id=" + N_id + ", N_pw=" + N_pw + ", N_name=" + N_name + ", N_birth=" + N_birth
				+ ", N_gender=" + N_gender + ", N_email=" + N_email + ", N_phone=" + N_phone + "]";
	}
	
	
	//constructor
	
	public NMember() {
		super();
	}
	
	public NMember(String n_id, String n_pw, String n_name, String n_birth, String n_gender, String n_email,
			String n_phone) {
		super();
		this.N_id = n_id;
		this.N_pw = n_pw;
		this.N_name = n_name;
		this.N_birth = n_birth;
		this.N_gender = n_gender;
		this.N_email = n_email;
		this.N_phone = n_phone;
	}
	

	
	
	
	
	
	
	

}
