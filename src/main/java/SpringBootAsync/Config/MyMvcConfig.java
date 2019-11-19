package SpringBootAsync.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@EnableWebMvc
@Component
public class MyMvcConfig implements WebMvcConfigurer {
	
	//@Autowired
	//LoginHandlerInterceptor loginHandlerInterceptor; //inject loginHandlerInterceptor

	/*  add view resolver
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	*/

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/Lab/**").
				addResourceLocations("/WEB-INF/Assets/Lab/");
		registry.addResourceHandler("/Res/**").
				addResourceLocations("/WEB-INF/Assets/Res/");
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/permission_error").setViewName("permission_error");
	}


	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
			.excludePathPatterns("/user_login","/user_login*","/index","/","/home","/loginaction","/css/**","/i18n/**","/templates/**"); //必须把静态资源都排除,把登录页的login排除，否则stack overflow

		registry.addInterceptor(new AdminHandlerInterceptor()).addPathPatterns("/pages/management/*")  //将管理员页面加入控制
				.excludePathPatterns("/css/**","/i18n/**","/templates/**"); //必须把静态资源都排除,把登录页的login排除，否则stack overflow
		//在管理员页面需要判断是否管理员
	}
}
