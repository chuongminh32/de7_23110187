package vn.iotstar.Services;

import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService_23110187 {

    // Lấy tất cả category (không phân trang)
    List<Category_23110187> findAll();

    // Lấy category có phân trang
    Page<Category_23110187> findAll(int page, int size);

    // Tìm category theo id
    Optional<Category_23110187> findById(int id);

    // Tìm category theo tên + phân trang
    Page<Category_23110187> searchByCategoryName(String keyword, int page, int size);

    // Lưu hoặc cập nhật category
    Category_23110187 save(Category_23110187 category);

    // Xóa category theo id
    void deleteById(int id);

    // Tìm category theo User
    List<Category_23110187> findByUser(Users_23110187 user);

    // Tìm category theo User (có phân trang)
    Page<Category_23110187> findByUser(Users_23110187 user, int page, int size);
    
    List<Category_23110187> findAllCategoriesWithVideos();
}
