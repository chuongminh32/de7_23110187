package vn.iotstar.controller.admin;

import vn.iotstar.Services.VideoService_23110187;
import vn.iotstar.entity.Video_23110187;
import vn.iotstar.entity.Category_23110187;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin/video")
public class AdminVideoController_23110187 {

    @Autowired
    private VideoService_23110187 videoService;

    private static final String UPLOAD_DIR = "G:\\uploads";

    // 👉 Redirect khi vào /admin/video → /admin/video/list
    @GetMapping("")
    public String redirectToList() {
        return "redirect:/admin/video/list";
    }

    // 👉 Hiển thị danh sách Video (có phân trang + tìm kiếm)
    @GetMapping("/list")
    public String listVideos(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "6") int size,
                             @RequestParam(required = false) String keyword,
                             Model model) {

        Page<Video_23110187> videoPage;

        if (keyword != null && !keyword.isEmpty()) {
            videoPage = videoService.searchByTitle(keyword, page, size);
            model.addAttribute("keyword", keyword);
        } else {
            videoPage = videoService.findAll(page, size);
        }

        model.addAttribute("videos", videoPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",
                videoPage.getTotalPages() > 0 ? videoPage.getTotalPages() : 1);

        return "admin/videolist"; // sẽ render file /WEB-INF/views/admin/videolist.jsp
    }

    // 👉 Hiển thị form thêm mới Video
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("video", new Video_23110187());
        return "admin/videoform"; // /WEB-INF/views/admin/videoform.jsp
    }

    // 👉 Hiển thị form sửa Video
    @GetMapping("/edit")
    public String editForm(@RequestParam String videoId, Model model) {
        Video_23110187 v = videoService.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found: " + videoId));
        model.addAttribute("video", v);
        return "admin/videoform";
    }

    // 👉 Lưu Video (thêm mới hoặc update)
    @PostMapping("/save")
    public String saveVideo(@RequestParam(required = false) String videoId,
                            @RequestParam String title,
                            @RequestParam(defaultValue = "false") Boolean active,
                            @RequestParam(required = false) String description,
                            @RequestParam("file") MultipartFile file,
                            @RequestParam(required = false) Integer categoryId
    ) throws IOException {

        // Nếu có id → lấy ra video cũ, ngược lại tạo mới
        Video_23110187 v = (videoId != null && !videoId.isEmpty())
                ? videoService.findById(videoId).orElse(new Video_23110187())
                : new Video_23110187();

        // Nếu là video mới → gán id + mặc định lượt xem
        if (v.getVideoId() == null || v.getVideoId().isEmpty()) {
            v.setVideoId(UUID.randomUUID().toString());
            v.setViews(0);
        }

        v.setTitle(title);
        v.setActive(active);
        v.setDescription(description);

        // Upload poster mới nếu có
        if (!file.isEmpty()) {
            new File(UPLOAD_DIR).mkdirs();
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(UPLOAD_DIR, fileName));
            v.setPoster(fileName);
        }

        // 👉 Có thể gán Category nếu cần
        // v.setCategory(categoryService.findById(categoryId).orElse(null));

        videoService.save(v);

        return "redirect:/admin/video/list";
    }

    // 👉 Xóa Video theo id
    @GetMapping("/delete")
    public String deleteVideo(@RequestParam String videoId) {
        videoService.deleteById(videoId);
        return "redirect:/admin/video/list";
    }
}
