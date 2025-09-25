package vn.iotstar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iotstar.Services.CategoryService_23110187;
import vn.iotstar.entity.Category_23110187;

@Controller
@RequestMapping("/admin")
public class AdminHomeController_23110187 {

    @Autowired
    private CategoryService_23110187 categoryService;

    @GetMapping("/home")
    public String listCategories(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 @RequestParam(required = false) String keyword,
                                 Model model) {

        Page<Category_23110187> categoryPage;

        if (keyword != null && !keyword.isEmpty()) {
           
            categoryPage = categoryService.searchByCategoryName(keyword, page, size);
            model.addAttribute("keyword", keyword);
        } else {
            categoryPage = categoryService.findAll(page, size);
        }

        model.addAttribute("categories", categoryPage.getContent());
        model.addAttribute("currentPage", page);

        // fix end < 0 khi không có dữ liệu
        int totalPages = categoryPage.getTotalPages();
        model.addAttribute("totalPages", totalPages > 0 ? totalPages : 1);

        return "admin/home"; // => /WEB-INF/views/admin/home.jsp
    }
}
