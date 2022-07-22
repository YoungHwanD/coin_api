package Main_Login;

public class MemberVo {
	private String id;
	private String password;
	private String name;
	private String email;
	
	public MemberVo() {

	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public MemberVo(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	
	public MemberVo(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


}
