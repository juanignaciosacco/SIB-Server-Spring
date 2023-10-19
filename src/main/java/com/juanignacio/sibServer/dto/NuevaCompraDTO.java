package com.juanignacio.sibServer.dto;

import com.thoughtworks.qdox.model.expression.Not;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NuevaCompraDTO(

        @NotBlank(message = "El nombre es requerido!")
        String userMailName,

        @NotBlank(message = "El apellido es requerido!")
        String userMailLastname,

        @NotBlank(message = "El email es requerido!")
        @Email(message = "Debe ingresar un email valido!")
        String userMail,

        @NotBlank(message = "El numero de telefono es requerido!")
        String userPhone,
        String userState,
        String userAddress,
        String userAddressNumber,
        @NotBlank(message = "El payment Id es requerido!")
        String userPaymentId,
        @NotBlank(message = "El tipo de envio es requerido!")
        String tipoDeEnvio
) {
}
