package SpringBootAsync.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
@Configuration
@EnableWebSecurity //开启 web security
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	List<String> list= new ArrayList<String>();
	String username;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//定制请求的授权规则
		http.authorizeRequests().antMatchers("/","/css/**").permitAll()
			.antMatchers("/pages/yong/**").hasRole("level1")
			.antMatchers("/pages/premium/**").hasRole("level2")
			.antMatchers("/pages/extra/**").hasRole("level3");
		
		//开启登录功能
		http.formLogin().loginPage("/user_login");
		//自动生成登录页面，/login 请求
		//如果登录失败，重定向到 /login?error
	}
	
	public void getprivilege(HttpServletRequest request) {
		list=  (List<String>) request.getSession().getAttribute("authorization");
		username= (String) request.getSession().getAttribute("username");
	}
	
	@Override //登录验证, 定义认证规则
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		for (String level:list) {
			auth.jdbcAuthentication().withUser("username").roles(level);
		}
	}

}
*/