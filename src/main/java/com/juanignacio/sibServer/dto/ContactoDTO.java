package com.juanignacio.sibServer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactoDTO(

        @NotBlank(message = "El nombre es requerido!")
        String nombre,

        @NotBlank(message = "El apellido es requerido!")
        String apellido,

        @NotBlank(message = "El email es requerido!")
        @Email(message = "Debe ingresar un email valido!")
        String email,

        @NotBlank(message = "El asunto es requerido!")
        String asunto,

        @NotBlank(message = "El mensaje es requerido!")
        String mensaje
) {
}
