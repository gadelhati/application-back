package br.eti.gadelha.controller;

import br.eti.gadelha.services.ServiceQRCodeGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	16/07/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@RestController
public class ControllerQRCode {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @GetMapping(value = "/downloadQRCode/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        ServiceQRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/QRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(ServiceQRCodeGenerator.getQRCodeImage(codeText, width, height));
    }

    @RequestMapping(value = "/qrcode/{id}", method = RequestMethod.GET)
    public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(ServiceQRCodeGenerator.getQRCodeImage(id, 200, 200));
        outputStream.flush();
        outputStream.close();
    }
}