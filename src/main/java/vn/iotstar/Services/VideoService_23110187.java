package vn.iotstar.Services;
import vn.iotstar.entity.Video_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VideoService_23110187 {

    // Lấy tất cả video (không phân trang)
    List<Video_23110187> findAll();

    // Lấy tất cả video có phân trang
    Page<Video_23110187> findAll(int page, int size);

    // Tìm video theo id (PK: String)
    Optional<Video_23110187> findById(String videoId);

    // Tìm video theo tiêu đề (có phân trang)
    Page<Video_23110187> searchByTitle(String keyword, int page, int size);

    // Lấy video theo trạng thái (active/inactive)
    Page<Video_23110187> findByActive(Boolean active, int page, int size);

    // Lấy video theo category
    Page<Video_23110187> findByCategory(Category_23110187 category, int page, int size);

    // Lấy video theo user (thông qua category → user)
    Page<Video_23110187> findByUser(Users_23110187 user, int page, int size);

    // Lưu hoặc cập nhật video
    Video_23110187 save(Video_23110187 video);

    // Xóa video theo id (String)
    void deleteById(String videoId);
}
