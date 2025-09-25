package vn.iotstar.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.Users_23110187;
@Component
public class RoleInterceptor_23110187 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return true; // 🔹 để AuthInterceptor xử lý
        }

        Users_23110187 user = (Users_23110187) session.getAttribute("user");
        String path = request.getServletPath();

        // map role từ DB (Admin = true → 2, còn lại → 0)
        int role = Boolean.TRUE.equals(user.getAdmin()) ? 2 : 0;

        if (path.startsWith("/admin/") && role == 2) return true;
        if (path.startsWith("/user/") && role == 0) return true;

        response.sendRedirect(request.getContextPath() + "/home");
        return false;
    }
}
