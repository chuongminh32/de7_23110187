package vn.iotstar.controller;

import vn.iotstar.Services.UsersService_23110187;
import vn.iotstar.entity.Users_23110187;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController_23110187 {

    @Autowired
    private UsersService_23110187 usersService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "web/register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String fullname,
                                  @RequestParam String username,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String password,
                                  @RequestParam String confirm,
                                  HttpSession session,
                                  Model model) {

        // Kiểm tra nhập lại mật khẩu
        if (!password.equals(confirm)) {
            model.addAttribute("error", "Mật khẩu nhập lại không khớp!");
            return "web/register";
        }

        // Kiểm tra trùng username
        if (usersService.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "web/register";
        }

        // Tạo user mới (mặc định là user thường)
        Users_23110187 user = new Users_23110187();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        // Mặc định user thường → admin = false
        user.setAdmin(false);

        // Mặc định active = true khi đăng ký thành công
        user.setActive(true);

        usersService.save(user);

        // ✅ Sau khi đăng ký → tự động login
        session.setAttribute("user", user);

        // ✅ Chuyển thẳng vào trang user/home
        return "redirect:/user/home";
    }
}
