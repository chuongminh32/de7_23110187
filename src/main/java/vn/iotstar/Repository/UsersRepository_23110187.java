package vn.iotstar.Repository;

import vn.iotstar.entity.Users_23110187;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository_23110187 extends JpaRepository<Users_23110187, String> {

    // Tìm user theo username (phục vụ login)
    Optional<Users_23110187> findByUsername(String username);

    // Lấy danh sách user theo quyền admin (true = admin, false = user) + phân trang
    Page<Users_23110187> findByAdmin(Boolean admin, Pageable pageable);

    // Lọc user theo trạng thái (active/inactive) + phân trang
    Page<Users_23110187> findByActive(Boolean active, Pageable pageable);

    // Tìm theo email
    Optional<Users_23110187> findByEmail(String email);

    // Tìm theo phone
    Optional<Users_23110187> findByPhone(String phone);
}
