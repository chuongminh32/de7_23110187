package vn.iotstar.controller;

import vn.iotstar.Services.UsersService_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController_23110187 {

    @Autowired
    private UsersService_23110187 usersService;

    // Hiển thị form login
    @GetMapping("/login")
    public String showLoginForm() {
        return "/web/login"; // JSP: /WEB-INF/views/web/login.jsp
    }

    // Xử lý login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        return usersService.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    session.setAttribute("user", user);

                    // ✅ Mapping role: admin=true → admin, còn lại → user
                    if (Boolean.TRUE.equals(user.getAdmin())) {
                        return "redirect:/admin/home";
                    } else {
                        return "redirect:/user/home";
                    }
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Sai username hoặc password");
                    return "web/login";
                });
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
