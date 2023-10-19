package com.juanignacio.sibServer.controller;

import com.juanignacio.sibServer.dto.ConfirmacionCompraDTO;
import com.juanignacio.sibServer.dto.ContactoDTO;
import com.juanignacio.sibServer.dto.NuevaCompraDTO;
import com.juanignacio.sibServer.dto.SinStockDTO;
import com.juanignacio.sibServer.models.ConfirmacionCompraMailBody;
import com.juanignacio.sibServer.models.ContactoMailBody;
import com.juanignacio.sibServer.models.NuevaCompraMailBody;
import com.juanignacio.sibServer.models.SinStockMailBody;
import com.juanignacio.sibServer.services.impl.ConfirmacionCompraImpl;
import com.juanignacio.sibServer.services.impl.NuevaCompraImpl;
import com.juanignacio.sibServer.services.impl.SinSockImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MailController {

    @Autowired
    private SinSockImpl emailSinStockService;

    @Autowired
    private NuevaCompraImpl emailNuevaCompraService;

    @Autowired
    private ConfirmacionCompraImpl emailConfirmacionCompraService;

    @PostMapping("/contacto")
    public ResponseEntity<?> sendContactMail(@RequestBody @Valid ContactoDTO contactoDTO) {

        ContactoMailBody contactoMailBody = new ContactoMailBody(contactoDTO);

        String message = "<b>Datos de contacto: </b>" + "<br/><br/><br/>" +
                "<b>Nombre: </b>" + contactoMailBody.getNombre() + "<br/>" +
                "<b>Apellido: </b>" + contactoMailBody.getApellido() + "<br/>" +
                "<b>E-mail: </b>" + contactoMailBody.getEmail() + "<hr/><br/>" +
                "<b>Mensaje: </b><br/>" + contactoMailBody.getMensaje();

        emailConfirmacionCompraService.sendContactoEmail(contactoMailBody.getAsunto(), message, contactoMailBody.getEmail());

        return ResponseEntity.ok("Correo de contacto enviado con exito!");
    }

    @PostMapping("/sin_stock")
    public ResponseEntity<?> sendSinStockMail(@RequestBody @Valid List<SinStockDTO> sinStockDTOList) {

        StringBuilder messageBuilder = new StringBuilder();

        for (SinStockDTO sinStockDTO : sinStockDTOList) {
            SinStockMailBody sinStockMailBody = new SinStockMailBody(sinStockDTO);
            String messageComponent = "<b>Nombre Producto: </b> <p>" + sinStockMailBody.getNombreProdSinStock() +
                    "</p> <br/> <b>Color Producto: </b> <p> " + sinStockMailBody.getColorProdSinStock() +
                    "</p> <br/> <b>Talle Producto: </b> <p> " + sinStockMailBody.getTalleProdSinStock() +
                    "</p> <br/> <b>Stock: </b> <p> " + sinStockMailBody.getStockProdSinStock() +
                    "</p> <br/><hr/>";
            messageBuilder.append(messageComponent);
        }

        String finalMessage = messageBuilder.toString();
        emailSinStockService.sendEmail(finalMessage);

        return ResponseEntity.ok("Correo sin stock enviado con exito");
    }

    @PostMapping("/confirmacion_compra")
    public ResponseEntity<?> sendConfirmacionCompraMail(@RequestBody @Valid ConfirmacionCompraDTO confirmacionCompraDTO) {

        StringBuilder tipoEnvio = new StringBuilder();

        ConfirmacionCompraMailBody confirmacionCompraMailBody = new ConfirmacionCompraMailBody(confirmacionCompraDTO);

        if (confirmacionCompraMailBody.getTipoDeEnvio().equals("Tienda")) {
            tipoEnvio.append("Retiro en tienda") ;
        } else if (confirmacionCompraMailBody.getTipoDeEnvio().equals("Domicilio")) {
            tipoEnvio.append("Envio a domicilio!");
        }

        String message = "<h1>Confirmación de compra en Sib Shop Uruguay</h1> " +
                "<p>Gracias por su compra!! En breves nos pondremos en contacto para notificarle del " +
                "envio o cuando este pronta para ser retirada por la tienda!</p> <br /> " +
                "<b>Numero Identificador de compra:</b>" +
				"<p>" + confirmacionCompraMailBody.getIdOrden() + "</p> <br/> " +
				"<b>Tipo de envio: </b>" + tipoEnvio +
				"<p> </p> <br/> " +
				"<b>Costo total: </b> " +
				"<p>$ " + confirmacionCompraMailBody.getPrecioTotal() + "</p> <br/> " +
                "<a href='http://localhost:3000/#/obtenerOrden/" + confirmacionCompraMailBody.getIdOrden() + "'>" +
					"<button style='width:100px;height:30px;font-size:16px'>Ver orden</button>" +
				"</a> <br/><hr/> " +
				"<p>Este es un email automatizado, por favor no responder.</p>";

        emailConfirmacionCompraService.sendEmail(message);

        return ResponseEntity.ok("Correo confirmacion de compra enviado con exito");
    }

    @PostMapping("/feedback")
    public ResponseEntity<?> sendNuevaCompraMail(@RequestBody @Valid NuevaCompraDTO nuevaCompraDTO) {

        NuevaCompraMailBody nuevaCompraMailBody = new NuevaCompraMailBody(nuevaCompraDTO);

        String message = "<b>Nombre completo: </b> <p>" + nuevaCompraMailBody.getUserMailName() + " " + nuevaCompraMailBody.getUserMailLastname() +
                "</p> <b>Email: </b> <p>" + nuevaCompraMailBody.getUserMail() +
                "</p> <b>Telefono: </b> <p>" +nuevaCompraMailBody.getUserPhone() +
                "</p> <b>Direccion: </b> <p>" + nuevaCompraMailBody.getUserAddress() +
                "</p> <b>Localidad: </b> <p>" + nuevaCompraMailBody.getUserState() +
                "</p> <b>Numero: </b> <p>" + nuevaCompraMailBody.getUserAddressNumber() +
                "<br/> <hr/> <b>Informacion de compra: </b> <br/> <br/> " +
                "<b>Payment ID: </b> <p>" + nuevaCompraMailBody.getUserPaymentId() + "</p> <br/> " +
                "<b>Tipo de compra: </b><p>" + nuevaCompraMailBody.getTipoDeEnvio() +
                "</p>";

        emailNuevaCompraService.sendEmail(message);

        return ResponseEntity.ok("Correo sin stock enviado con exito");
    }

}
