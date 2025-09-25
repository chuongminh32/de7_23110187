package vn.iotstar.Repository;

import vn.iotstar.entity.Video_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository_23110187 extends JpaRepository<Video_23110187, String> {

    // ✅ Tìm video theo tiêu đề (có phân trang)
    Page<Video_23110187> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // ✅ Lấy video theo trạng thái (active/inactive)
    Page<Video_23110187> findByActive(Boolean active, Pageable pageable);

    // ✅ Lấy video theo category
    Page<Video_23110187> findByCategory(Category_23110187 category, Pageable pageable);

    // ✅ Lấy video theo user (thông qua category → user)
    Page<Video_23110187> findByCategory_User(Users_23110187 user, Pageable pageable);
}
