package com.juanignacio.sibServer.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String name;
    private Integer quantity;
    private Integer price;

}
