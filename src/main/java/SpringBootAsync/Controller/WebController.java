package SpringBootAsync.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {
	
	String yongPrefix="/pages/";
	
	@RequestMapping(value= {"/","index"}, method=RequestMethod.GET)
	public String hello() {
		return "index";
	}
	
	@RequestMapping(value="user_login", method=RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		model.addAttribute("msg","");
		return new ModelAndView("user_login",model);
	}
	
	@RequestMapping(value="/pages/{path1}/{path2}", method=RequestMethod.GET)
	public String yong1(@PathVariable("path1") String path1, @PathVariable("path2") String path2, HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("role"));
		return yongPrefix+path1+"/"+path2;
	}

}
