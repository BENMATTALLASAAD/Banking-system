package com.BWA.Banking.Web.Application.model;


import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long id;

    @Column(name="user_Firstname", nullable = false)
    private String userFirstname;

    @Column(name="user_Lastname", nullable = false)
    private String userLastname;

    @Column(name="user_email", nullable = false)
    private String email;
    
    @Column(name="user_password", nullable = false)
    private String password;

    @Column(name="user_birthday", nullable = false)
    private Date birthday;

    @Column(name="user_gender", nullable = false)
    private String gender;
    
    @Column(name="user_adress", nullable = false)
    private String adress;
    
    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loading for performance
    @JoinColumn(name = "role", nullable = false)  // Defines the foreign key to the 'role' table
    private Role role;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updated_at;
    

}
