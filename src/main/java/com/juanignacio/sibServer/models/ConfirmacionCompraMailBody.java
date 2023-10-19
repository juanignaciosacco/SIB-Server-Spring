/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanignacio.sibServer.models;

import com.juanignacio.sibServer.dto.ConfirmacionCompraDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juanchi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmacionCompraMailBody {
    
    private String idOrden;
    private String tipoDeEnvio;
    private Integer precioTotal;
    private String userMail;
    
    public ConfirmacionCompraMailBody(ConfirmacionCompraDTO confirmacionCompraDTO) {
        this.idOrden = confirmacionCompraDTO.idOrden();
        this.tipoDeEnvio = confirmacionCompraDTO.tipoDeEnvio();
        this.precioTotal = confirmacionCompraDTO.precioTotal();
        this.userMail = confirmacionCompraDTO.userMail();
    }
    
}
