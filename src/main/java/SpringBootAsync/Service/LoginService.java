package SpringBootAsync.Service;

import SpringBootAsync.LoginUserEntity.LoginUser;
import SpringBootAsync.Mapper.LoginMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	public LoginUser getUserByAuth(String loginName, String passwd) {
		LoginUser loginUser= loginMapper.getUserByAuth(loginName, passwd);
		return loginUser;
	}

	public String getUserRole(int role){
		String userRole= loginMapper.getUserRole(role);
		return userRole;
	}
}
