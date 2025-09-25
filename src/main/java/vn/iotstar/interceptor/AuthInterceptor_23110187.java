package vn.iotstar.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor_23110187 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        // ✅ Các đường dẫn public → luôn cho phép
        if (uri.equals("/") 
            || uri.startsWith("/home")
            || uri.startsWith("/login")
            || uri.startsWith("/register")
            || uri.startsWith("/css")
            || uri.startsWith("/js")
            || uri.startsWith("/images")
            || uri.startsWith("/video")) {
            return true;
        }

        // ❌ Các URL private (user/manager/admin) mà chưa login
        if ((uri.startsWith("/user") || uri.startsWith("/manager") || uri.startsWith("/admin"))
                && (session == null || session.getAttribute("user") == null)) {
            response.sendRedirect(request.getContextPath() + "/home");
            return false;
        }

        return true;
    }
}
