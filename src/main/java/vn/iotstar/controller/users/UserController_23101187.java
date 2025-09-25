package vn.iotstar.controller.users;

import vn.iotstar.Services.CategoryService_23110187;
import vn.iotstar.Services.VideoService_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Video_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController_23101187 {

    @Autowired
    private CategoryService_23110187 categoryService;

    @Autowired
    private VideoService_23110187 videoService;

    // ✅ Trang chủ: hiển thị tất cả category
    @GetMapping({"/home", "/category"})
    public String listCategories(Model model) {
        List<Category_23110187> list = categoryService.findAll()
                .stream()
                .filter(c -> Boolean.TRUE.equals(c.getStatus())) // lọc category active
                .toList();
        model.addAttribute("categories", list);
        return "web/home"; // JSP: /WEB-INF/views/web/home.jsp
    }

    // ✅ Trang video: chỉ hiển thị video đang active
    @GetMapping("/video")
    public String listVideos(Model model) {
        List<Video_23110187> list = videoService.findAll()
                .stream()
                .filter(v -> Boolean.TRUE.equals(v.getActive())) // lọc video active
                .toList();
        model.addAttribute("videos", list);
        return "web/videolist"; // JSP: /WEB-INF/views/web/videolist.jsp
    }
}
