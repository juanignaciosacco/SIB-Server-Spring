package com.juanignacio.sibServer.controller;

import com.juanignacio.sibServer.dto.NewPreferenceDTO;
import com.juanignacio.sibServer.services.MpPreferenceService;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MercadoPagoController {

    @Autowired
    private MpPreferenceService service;

    @PostMapping("/create_preference")
    public String createPreference(@RequestBody NewPreferenceDTO newPreferenceDTO) throws MPException {
       return service.create(newPreferenceDTO);
    }

}
