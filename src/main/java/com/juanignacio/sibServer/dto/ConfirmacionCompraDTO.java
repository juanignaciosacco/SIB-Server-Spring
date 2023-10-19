/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanignacio.sibServer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author juanchi
 */
public record ConfirmacionCompraDTO(
        
        @NotBlank(message = "El nombre es requerido!")
        String idOrden,
        
        @NotBlank(message = "El tipo de envio es requerido!")
        String tipoDeEnvio,
        
        @NotNull(message = "El precio total es requerido!")
        Integer precioTotal,
        
        @NotBlank(message = "El email es requerido!")
        @Email(message = "Debe ingresar un email valido!")
        String userMail
        
) {
    
}
