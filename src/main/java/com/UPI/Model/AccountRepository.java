/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UPI.Model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author saura
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    
}
