package com.securitas.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.service.SecuritasService;

@RestController
@RequestMapping("/inversor")
public class SecuritasRestController {

	
	@Autowired SecuritasService securitasService;
	
	@GetMapping
	public ResponseEntity<String> inversor (@RequestParam("mensaje") String mensaje){
		String mensajeInvertido = "";
		
		mensajeInvertido = securitasService.inversor(mensaje);
		
		return new ResponseEntity<>( mensajeInvertido, HttpStatus.OK);
	}
}
