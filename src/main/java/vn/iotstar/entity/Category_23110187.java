package vn.iotstar.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Category")
public class Category_23110187 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")   // map với cột CategoryId
    private int categoryId;

    @Column(name = "Categoryname", length = 100, nullable = true)
    private String categoryName;

    @Column(name = "Categorycode", length = 100, nullable = true)
    private String categoryCode;

    @Column(name = "Images", length = 500, nullable = true)
    private String images;

    @Column(name = "Status", nullable = true)
    private Boolean status;

    // ✅ Mỗi Category thuộc về 1 User (manager tạo ra)
    @ManyToOne
    @JoinColumn(name = "Username") // FK trong bảng Category tham chiếu Users.Username
    private Users_23110187 user;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video_23110187> videos;
}
