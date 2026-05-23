/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UPI.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author saura
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeshPacket {
    
     @NotBlank
    private String packetId; // UUID, used by intermediates for gossip dedup

    @Min(0)
    private int ttl; // Hops remaining; intermediates decrement it

    @NotNull
    private Long createdAt; // epoch millis, when sender created the packet

    @NotBlank
    private String ciphertext; 
    
}
