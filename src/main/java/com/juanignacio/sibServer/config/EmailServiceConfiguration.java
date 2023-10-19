package com.juanignacio.sibServer.config;

import com.juanignacio.sibServer.services.EmailService;
import com.juanignacio.sibServer.services.impl.ConfirmacionCompraImpl;
import com.juanignacio.sibServer.services.impl.NuevaCompraImpl;
import com.juanignacio.sibServer.services.impl.SinSockImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailServiceConfiguration {

    @Bean
    public SinSockImpl emailSinStockService() {
        return new SinSockImpl();
    }

    @Bean
    public NuevaCompraImpl emailNuevaCompraService() {
        return new NuevaCompraImpl();
    }

    @Bean
    public ConfirmacionCompraImpl emailConfirmacionCompraService() {
        return new ConfirmacionCompraImpl();
    }
}
