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
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(headers)
				.body(mensajeInvertido);
	}
	
}
