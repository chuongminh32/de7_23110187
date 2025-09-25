package vn.iotstar.controller.admin;

import vn.iotstar.Services.CategoryService_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController_23110187 {

    @Autowired
    private CategoryService_23110187 categoryService;

    private static final String UPLOAD_DIR = "G:\\uploads"; // ✅ thư mục chứa ảnh upload

    // ✅ Danh sách + tìm kiếm + phân trang
    @GetMapping("/list")
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
        model.addAttribute("totalPages", categoryPage.getTotalPages());

        return "admin/home"; // /WEB-INF/views/admin/category-list.jsp
    }

    // ✅ Hiển thị form thêm mới
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("category", new Category_23110187());
        return "admin/category-form"; // /WEB-INF/views/admin/category-form.jsp
    }

    // ✅ Hiển thị form sửa
    @GetMapping("/edit")
    public String editForm(@RequestParam int categoryId, Model model) {
        Category_23110187 category = categoryService.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Category id=" + categoryId));
        model.addAttribute("category", category);
        return "admin/category-form"; // dùng chung JSP với thêm
    }

    // ✅ Lưu (thêm mới hoặc cập nhật)
    @PostMapping("/save")
    public String saveCategory(@RequestParam(required = false) Integer categoryId,
                               @RequestParam String categoryName,
                               @RequestParam(required = false) String categoryCode,
                               @RequestParam(required = false, defaultValue = "false") Boolean status,
                               @RequestParam("imgFile") MultipartFile file,
                               HttpSession session) throws IOException {

        Users_23110187 currentAdmin = (Users_23110187) session.getAttribute("user");

        Category_23110187 c = (categoryId != null)
                ? categoryService.findById(categoryId).orElse(new Category_23110187())
                : new Category_23110187();

        c.setCategoryName(categoryName);
        c.setCategoryCode(categoryCode);
        c.setStatus(status);

        // ✅ Upload ảnh
        if (!file.isEmpty()) {
            new File(UPLOAD_DIR).mkdirs();
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_DIR, fileName));
            c.setImages(fileName);
        }

        c.setUser(currentAdmin);
        categoryService.save(c);

        return "redirect:/admin/category/list";
    }

    // ✅ Xóa
    @GetMapping("/delete")
    public String deleteCategory(@RequestParam int categoryId) {
        categoryService.deleteById(categoryId);
        return "redirect:/admin/home";
    }
}
