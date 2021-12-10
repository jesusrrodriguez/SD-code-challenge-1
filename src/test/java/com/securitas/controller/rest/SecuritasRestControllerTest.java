package com.securitas.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class SecuritasRestControllerTest {

	private String mensaje;
	
	@Autowired
	SecuritasRestController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		
		mensaje = "Hola Mundo¡";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void mensajeConSignoPuntuacion() {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		ResponseEntity<String> mensajeInvertido = controller.inversor(mensaje);
		
		//THEN:
			assertEquals("Mundo Hola¡", mensajeInvertido.getBody(), "Son iguales");
	}
	
	@Test
	void mensajeSinSignoPuntuacion() {
		//GIVEN:
		//Hay mensaje:
			mensaje = "Hola Mundo";
					
		//WHEN:
		ResponseEntity<String> mensajeInvertido = controller.inversor(mensaje);
		
		//THEN:
			assertEquals("Mundo Hola", mensajeInvertido.getBody(), "Son iguales");
	}

}
