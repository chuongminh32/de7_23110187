package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video_23110187 {

    @Id
    @Column(name = "VideoId", length = 50, nullable = false)
    private String videoId;   // PK (nvarchar(50))

    @Column(name = "Title", length = 200, nullable = true)
    private String title;

    @Column(name = "Poster", length = 50, nullable = true)
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description", length = 500, nullable = true)
    private String description;

    @Column(name = "Active")
    private Boolean active;

    // Quan hệ n-1 với Category
    @ManyToOne
    @JoinColumn(name = "CategoryId") // FK trong bảng Videos
    private Category_23110187 category;
}
