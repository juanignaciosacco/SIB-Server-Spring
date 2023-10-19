package com.juanignacio.sibServer.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record SinStockDTO(

        @NotBlank(message = "El nombre del producto es requerido!")
        String nombreProdSinStock,

        @NotBlank(message = "El color del producto es requerido!")
        String colorProdSinStock,

        List talleProdSinStock,

        @NotBlank(message = "El stock del producto es requerido!")
        String stockProdSinStock
) {
}
