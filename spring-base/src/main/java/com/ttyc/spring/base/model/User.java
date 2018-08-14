package com.ttyc.spring.base.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Target;

@Data
@Builder
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;
}
