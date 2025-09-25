package vn.iotstar.controller.admin;

import vn.iotstar.Services.UsersService_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController_23110187 {

    @Autowired
    private UsersService_23110187 usersService;

    // ✅ List user
    @GetMapping("/list")
    public String listUsers(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size,
                            @RequestParam(required = false) String keyword,
                            Model model) {

        Page<Users_23110187> userPage;

        if (keyword != null && !keyword.isEmpty()) {
            // TODO: viết thêm hàm search trong UsersService (VD: searchByUsernameOrEmail)
            userPage = usersService.findAll(page, size); // tạm thời lấy all
            model.addAttribute("keyword", keyword);
        } else {
            userPage = usersService.findAll(page, size);
        }

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());

        return "admin/listUser"; // JSP
    }

    // ✅ Save (add/edit)
    @PostMapping("/save")
    public String saveUser(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String fullname,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam(defaultValue = "false") boolean admin,
                           @RequestParam(defaultValue = "true") boolean active) {

        Users_23110187 u = usersService.findByUsername(username).orElse(new Users_23110187());

        u.setUsername(username);
        u.setPassword(password);
        u.setFullname(fullname);
        u.setEmail(email);
        u.setPhone(phone);

        // ✅ thay role bằng admin
        u.setAdmin(admin);

        // ✅ thay status bằng active
        u.setActive(active);

        usersService.save(u);

        return "redirect:/admin/user/list";
    }

    // ✅ Delete
    @GetMapping("/delete")
    public String deleteUser(@RequestParam String username) {
        usersService.deleteById(username);
        return "redirect:/admin/user/list";
    }
}
