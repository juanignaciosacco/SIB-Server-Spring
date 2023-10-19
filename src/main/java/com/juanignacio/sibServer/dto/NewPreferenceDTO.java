package com.juanignacio.sibServer.dto;

import com.juanignacio.sibServer.models.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewPreferenceDTO {

    private List<Item> items;

}
