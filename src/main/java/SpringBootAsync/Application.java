package SpringBootAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 *  引入 spring-security
 *  配置 spring-security
 *  编写配置类，继承 WebSecurityConfigurerAdapter
 *  控制请求的访问权限
 */
@EnableAsync  //开启异步多线程
@EnableScheduling //开启定时任务
@SpringBootApplication (exclude={DataSourceAutoConfiguration.class})

public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
