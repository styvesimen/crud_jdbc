package perso.simen.coursework.entity;

public class User {
	private int user_id;
	private String name;
	private String dob;
	private String email;
	private String tel;
	
	public User(){}
	
	public User(int userId, String nameU, String dobU, String emailU, String telU){
		this.user_id = userId;
		this.name = nameU;
		this.dob = dobU;
		this.email = emailU;
		this.tel = telU;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", dob=" + dob + ", email=" + email + ", tel=" + tel
				+ "]";
	}
	
	
	
}
