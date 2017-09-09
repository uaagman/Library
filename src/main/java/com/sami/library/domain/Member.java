package com.sami.library.domain;

import com.sami.library.annotations.EmptyOrSize;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @EmptyOrSize(max = 30)
    private String fullName;

    @Email
    @Column(unique = true)
    private String email;
}
