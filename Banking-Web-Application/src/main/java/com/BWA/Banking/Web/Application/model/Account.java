package com.BWA.Banking.Web.Application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id", nullable = false)
    private Long id;

    @Column(name="account_number", nullable = false)
    private Long accountNumber;

    @Column(name="account_balance", nullable = false)
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updated_at;
}
