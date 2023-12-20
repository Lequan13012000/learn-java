package com.example.demo.entity;

import com.example.demo.constant.StatusCate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cate")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Cate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cd;
    private String name;
    private String val;
    private Integer ord;
    private StatusCate status;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @Column(name = "parent_id")
    private Integer parentId;
}
