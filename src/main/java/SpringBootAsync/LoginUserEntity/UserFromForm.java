package SpringBootAsync.LoginUserEntity;

import javax.validation.constraints.NotEmpty;

public class UserFromForm {
	@NotEmpty 
	private String username;
	@NotEmpty
	private String password;
	
	//public UserFromForm() {};
	
	public UserFromForm (String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUserName() {
		return username;
	}
	
	public void setName(String username) {
		this.username=username;
	}
	
	public String getPasswd() {
		return password;
	}
	
	public void setPasswd(String password) {
		this.password=password;
	}
	
	@Override
	public String toString() {
		return "username: " + username + ", password: " + password;
	}
}
