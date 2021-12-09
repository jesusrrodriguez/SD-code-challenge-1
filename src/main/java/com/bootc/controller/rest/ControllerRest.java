package com.bootc.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootc.service.MensajeService;

@RestController
@RequestMapping("/inversor")
public class ControllerRest {
	
	@Autowired
	MensajeService mensajeService;
	
	@GetMapping
	public ResponseEntity<String> invertirMensaje(@RequestParam("mensaje") String mensaje) {
		HttpHeaders headers = new HttpHeaders();
		String mensajeInvertido = "";
		try {
			if (mensaje.isEmpty() || mensaje.isBlank()) {
				headers.set("Message", "El mensaje no debe estar vacío");
				
				return ResponseEntity
						.status(HttpStatus.NOT_ACCEPTABLE)
						.headers(headers)
						.body(null);
			} else {
				mensajeInvertido = mensajeService.invertirString(mensaje);
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.headers(headers)
						.body(mensajeInvertido);
			}
		} catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.headers(headers)
					.body(null);
		}
	}
	
}
