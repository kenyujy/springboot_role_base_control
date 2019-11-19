package SpringBootAsync.Controller;


import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import SpringBootAsync.LoginUserEntity.LoginUser;
import SpringBootAsync.LoginUserEntity.UserFromForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@Autowired
	private SpringBootAsync.Service.LoginService loginService;
	
	//SpringMVC自动将表单请求参数和入参对象封装，要求请求参数的名字和入参对象里面的属性名一样
	@RequestMapping(value={"/user_login"}, method=RequestMethod.POST)
    public ModelAndView loginAuthenticate(@ModelAttribute UserFromForm user, ModelMap model, HttpServletRequest request) {
		LoginUser loginUser= loginService.getUserByAuth(user.getUserName(), user.getPasswd());
		//比较2个String是否相等 String.equals(Object)方法
		System.out.println("--------------------------");
		Map<String, String[]> paramMap= request.getParameterMap();
		for(String key: paramMap.keySet()) {
			System.out.print(key+": ");
			for (String value: paramMap.get(key)) {
				System.out.println(value);
			}
		}
		System.out.println("--------------------------");
		HttpSession session= request.getSession();
		
		Enumeration<String> attributeNames =session.getAttributeNames(); //每次登录先把之前的session清空
		while (attributeNames.hasMoreElements()){
			session.removeAttribute(attributeNames.nextElement());
		}

		if (loginUser!= null && loginUser.getPassword().equals(user.getPasswd())) {
			// 取出user_role，并加进session属性
			String userRole= loginService.getUserRole(loginUser.getUser_role());
			session.setAttribute("role",userRole);

			if (loginUser.getLevel1_auth()>0) {
				session.setAttribute("level1",1);
			}
			if (loginUser.getLevel2_auth()>0) {
				session.setAttribute("level2",1);
			}
			if (loginUser.getLevel3_auth()>0) {
				session.setAttribute("level3",1);
			}
			session.setAttribute("username", loginUser.getUsername());
			return new ModelAndView ("redirect:index");
		}else {
			model.addAttribute("msg", "用户名或密码错误!");
			return new ModelAndView("user_login", model);
		}
	}

	@RequestMapping(value={"/logout"}, method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:user_login";
	}
}
