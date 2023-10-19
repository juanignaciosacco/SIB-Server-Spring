/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanignacio.sibServer.models;

import com.juanignacio.sibServer.dto.ContactoDTO;
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
public class ContactoMailBody {
    
    private String nombre;
    private String apellido;
    private String email;
    private String asunto;
    private String mensaje;

    public ContactoMailBody(ContactoDTO contactoDTO) {
        this.nombre = contactoDTO.nombre();
        this.apellido = contactoDTO.apellido();
        this.asunto = contactoDTO.asunto();
        this.email = contactoDTO.email();
        this.mensaje = contactoDTO.mensaje();
    }
    
}
