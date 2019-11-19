package SpringBootAsync.LoginUserEntity;

import javax.validation.constraints.NotEmpty;

//LoginUser 即数据库spring_test 里面的 spring_user
public class LoginUser {
	
	private int userid;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private int AccountStatus;
	private int Level1_auth;
	private int Level2_auth;
	private int Level3_auth;

	private int user_role;
	
	public LoginUser(int userid, String username, String password, int AccountStatus, int Level1_auth, int Level2_auth, int Level3_auth, int user_role) {
		this.userid=userid;
		this.username=username;
		this.password=password;
		this.AccountStatus=AccountStatus;
		this.Level1_auth= Level1_auth;
		this.Level2_auth= Level2_auth;
		this.Level3_auth= Level3_auth;
		this.user_role= user_role;
	}
	
	public LoginUser (String username, String password) {
		this.username=username;
		this.password=password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		AccountStatus = accountStatus;
	}

	public int getLevel1_auth() {
		return Level1_auth;
	}

	public void setLevel1_auth(int level1_auth) {
		Level1_auth = level1_auth;
	}

	public int getLevel2_auth() {
		return Level2_auth;
	}

	public void setLevel2_auth(int level2_auth) {
		Level2_auth = level2_auth;
	}

	public int getLevel3_auth() {
		return Level3_auth;
	}

	public void setLevel3_auth(int level3_auth) {
		Level3_auth = level3_auth;
	}

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "UserID: " + userid +",UserName: " + username + ",Passwd: " + password + ",AccountStatus: " + AccountStatus
				+",Level1_auth: "+Level1_auth+",Level2_auth: "+Level2_auth+",Level3_auth: "+Level3_auth;
	}
}