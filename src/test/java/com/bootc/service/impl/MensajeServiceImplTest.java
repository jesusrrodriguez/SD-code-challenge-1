package com.bootc.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootc.service.MensajeService;

@SpringBootTest
public class MensajeServiceImplTest {
	
	@Autowired
	MensajeService mensajeService;
	
	private String mensaje;
	private char signo;
	
    @Test
	void isSignoPuntuacionTest() {
		signo = '?';
		boolean isSigno = mensajeService.isSignoPuntuacion(signo);
		
		assertEquals(true, isSigno, "Son iguales");
	}
	
    @Test
	void invertirStringTest() {
		mensaje = "Hello world!";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("world Hello!", mensajeInvertido, "Son iguales");
	}
}
