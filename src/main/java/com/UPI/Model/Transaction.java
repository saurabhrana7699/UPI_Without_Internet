/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UPI.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

/**
 *
 * @author saura
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions",
        indexes = { @Index(name = "idx_packet_hash", columnList = "packetHash", unique = true) })
public class Transaction {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String packetHash; // SHA-256 hex of the encrypted packet

    @Column(nullable = false)
    private String senderVpa;

    
    @Column(nullable = false)
    private String receiverVpa;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private Instant signedAt; // When the sender originally signed it (offline)

    @Column(nullable = false)
    private Instant settledAt; // When the backend actually processed it

    @Column(nullable = false)
    private String bridgeNodeId; // Which mesh node finally delivered it

    @Column(nullable = false)
    private int hopCount; // How many devices it passed through

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status { SETTLED, REJECTED }
}
