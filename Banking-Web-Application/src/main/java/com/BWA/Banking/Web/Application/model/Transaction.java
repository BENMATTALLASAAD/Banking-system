package com.BWA.Banking.Web.Application.model;

import java.time.LocalDateTime;

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
@Table(name="transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loading for performance
    @JoinColumn(name = "fromAccount", nullable = false)  // Defines the foreign key to the 'account' table
    private Account fromAccount;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loading for performance
    @JoinColumn(name = "toAccount", nullable = false)  // Defines the foreign key to the 'account' table
    private Account toAccount;
    
    @Column(name="amount", nullable = false)
    private double amount;
   
    @Column(name="transaction_timestamp", nullable = false)
    private LocalDateTime timestamp;


}
