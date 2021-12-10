package com.securitas.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.securitas.service.MensajeService;
import com.securitas.service.impl.MensajeServiceImpl;

@SpringBootTest
class MensajeRestControllerTest {

	private String mensaje;
	
	@InjectMocks
	MensajeRestController restControllerMock;	
	
	@Mock
	MensajeService serviceMock;

	@Autowired
	MensajeService service;
	

	@Autowired
	MensajeRestController controller;

	
	@BeforeEach
	void setUp() throws Exception {
		mensaje= "Hola Mundo¡";

	}

	@AfterEach
	void tearDown() throws Exception {
		
		mensaje= "";

	}

	@Test
	void testMensajeException() throws Exception {
		//GIVEN:
		when (serviceMock.inversorPalabras(mensaje)).thenThrow(new Exception());

		//WHEN:
			ResponseEntity<String> re = restControllerMock.inversor(mensaje);
		
		//THEN:
			assertThat (re.getStatusCodeValue() ).isEqualTo(500);	
	}
	
	@Test
	void testMensajeVacio() throws Exception{
		//GIVEN:
			mensaje = "";
		//WHEN:
			ResponseEntity<String> re = controller.inversor(mensaje);
		
		//THEN:
			assertThat (re.getStatusCodeValue() ).isEqualTo(406);
	}

}
