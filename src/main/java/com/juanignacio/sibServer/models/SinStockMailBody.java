/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanignacio.sibServer.models;

import com.juanignacio.sibServer.dto.SinStockDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author juanchi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinStockMailBody {
    
    private String nombreProdSinStock;
    private String colorProdSinStock;
    private List talleProdSinStock;
    private String stockProdSinStock;

    public SinStockMailBody(SinStockDTO sinStockDTO) {
        this.nombreProdSinStock = sinStockDTO.nombreProdSinStock();
        this.colorProdSinStock = sinStockDTO.colorProdSinStock();
        this.talleProdSinStock = sinStockDTO.talleProdSinStock();
        this.stockProdSinStock = sinStockDTO.stockProdSinStock();
    }
    
}
