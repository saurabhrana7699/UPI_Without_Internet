/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UPI.Model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author saura
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
     List<Transaction> findTop20ByOrderByIdDesc();
    boolean existsByPacketHash(String packetHash);
}
  