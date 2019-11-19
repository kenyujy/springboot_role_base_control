package SpringBootAsync.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import SpringBootAsync.Service.AsyncService;

@Controller
public class AsyncController {

	@Autowired
	AsyncService asyncService;
	
	@ResponseBody
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		asyncService.hello();
		return "success";
	}
}
