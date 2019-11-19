package SpringBootAsync.Mapper;

import SpringBootAsync.LoginUserEntity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Mapper
@Component
public interface LoginMapper {
	
	@Select ("select * from spring_users where userName = #{username}")
	LoginUser findUserByName(String username);
	
	//get User Passwd for login authentication, assert AccountStatus >0"
	//2个参数的时候注意，好多坑!!!!
	@Select ("select * from spring_users where username=#{fieldA} and password=#{fieldB} and accountstatus >0")
	LoginUser getUserByAuth(@Param("fieldA") String username, @Param("fieldB") String password);

	@Select ("select role from user_roles where role_id=#{fieldA}")
	String getUserRole(@Param("fieldA") int role);
}
