package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "email", length = 500)
    private String email;

    @Column(name = "phone", length = 500)
    private String phone;

    @Column(name = "avatar", length = 500)
    private String avatar;

    @Column(name = "password", length = 500)
    private String password;

}
