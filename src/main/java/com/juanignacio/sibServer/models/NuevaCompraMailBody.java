/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanignacio.sibServer.models;

import com.juanignacio.sibServer.dto.NuevaCompraDTO;
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
public class NuevaCompraMailBody {
    
    private String userMailName;
    private String userMailLastname;
    private String userMail;
    private String userPhone;
    private String userState;
    private String userAddress;
    private String userAddressNumber;
    private String userPaymentId;
    private String tipoDeEnvio;

    public NuevaCompraMailBody(NuevaCompraDTO nuevaCompraDTO) {
        this.userMailName = nuevaCompraDTO.userMailName();
        this.userMailLastname = nuevaCompraDTO.userMailLastname();
        this.userMail = nuevaCompraDTO.userMail();
        this.userPhone = nuevaCompraDTO.userPhone();
        this.userState = nuevaCompraDTO.userState();
        this.userAddress = nuevaCompraDTO.userAddress();
        this.userAddressNumber = nuevaCompraDTO.userAddressNumber();
        this.userPaymentId = nuevaCompraDTO.userPaymentId();
        this.tipoDeEnvio = nuevaCompraDTO.tipoDeEnvio();
    }

}
