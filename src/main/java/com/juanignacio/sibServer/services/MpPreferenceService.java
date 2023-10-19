package com.juanignacio.sibServer.services;

import com.juanignacio.sibServer.dto.NewPreferenceDTO;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MpPreferenceService {

    @Value("${spring.token}")
    private String token;

    public String create(NewPreferenceDTO preferenceDTO) throws MPException {

        MercadoPagoConfig.setAccessToken(token);

        PreferenceClient client = new PreferenceClient();

        List<PreferenceItemRequest> items = preferenceDTO.getItems().stream()
                .map(itemData ->
                        PreferenceItemRequest.builder()
                                .title(itemData.getName())
                                .quantity(itemData.getQuantity())
                                .unitPrice(BigDecimal.valueOf(itemData.getPrice()))
                                .build()
                )
                .collect(Collectors.toList());

        PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
                .failure("http://localhost:3000/#/feedback")
                .pending("http://localhost:3000/#/feedback")
                .success("http://localhost:3000/#/feedback/:false")
                .build();

        PreferenceRequest request = PreferenceRequest.builder().items(items).backUrls(backUrlsRequest).build();

        try {
            Preference preference = client.create(request);
            return preference.getId();
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }
}
