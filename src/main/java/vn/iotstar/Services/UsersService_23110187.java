package vn.iotstar.Services;

import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UsersService_23110187 {

    // Lấy tất cả user (không phân trang)
    List<Users_23110187> findAll();

    // Lấy user có phân trang
    Page<Users_23110187> findAll(int page, int size);

    // Tìm user theo username (PK)
    Optional<Users_23110187> findById(String username);

    // Tìm user theo username (phục vụ login)
    Optional<Users_23110187> findByUsername(String username);

    // Lấy user theo quyền admin (true = admin, false = user) + phân trang
    Page<Users_23110187> findByAdmin(Boolean admin, int page, int size);

    // Lấy user theo trạng thái (active/inactive) + phân trang
    Page<Users_23110187> findByActive(Boolean active, int page, int size);

    // Thêm / cập nhật user
    Users_23110187 save(Users_23110187 user);

    // Xóa user theo username
    void deleteById(String username);
}
