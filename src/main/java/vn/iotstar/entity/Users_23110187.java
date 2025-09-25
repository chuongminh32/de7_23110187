package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class Users_23110187 {

    @Id
    @Column(name = "Username", length = 50, nullable = false)
    private String username;   // PK

    @Column(name = "Password", length = 50, nullable = true)
    private String password;

    @Column(name = "Phone", length = 15, nullable = true)
    private String phone;

    @Column(name = "Fullname", length = 50, nullable = true)
    private String fullname;

    @Column(name = "Email", length = 150, nullable = true)
    private String email;

    @Column(name = "Admin")
    private Boolean admin;   // dùng Boolean để nhận null

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Images", length = 500, nullable = true)
    private String images;

    // Quan hệ 1-nếu-1 user có thể tạo nhiều category (nếu cần)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category_23110187> categories;
}
