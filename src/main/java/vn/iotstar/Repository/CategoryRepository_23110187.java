package vn.iotstar.Repository;

import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository_23110187 extends JpaRepository<Category_23110187, Integer> {

    // ✅ Search theo tên category
    Page<Category_23110187> findByCategoryNameContainingIgnoreCase(String keyword, Pageable pageable);

    // ✅ Tìm tất cả category của 1 user (manager)
    List<Category_23110187> findByUser(Users_23110187 user);

    // ✅ Tìm category của 1 user có phân trang
    Page<Category_23110187> findByUser(Users_23110187 user, Pageable pageable);
    

    @Override
    @EntityGraph(attributePaths = "videos")
    List<Category_23110187> findAll();
}
