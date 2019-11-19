package SpringBootAsync.Config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String role= (String) request.getSession().getAttribute("role"); //从session中取出admin属性
        if ("admin".equals(role)) {
            //是admin
            return true;
        } else{
            //不是admin
            request.setAttribute("msg", "你不是管理员");
            request.getRequestDispatcher("/permission_error").forward(request, response);;
            return false;
        }
    }
}
