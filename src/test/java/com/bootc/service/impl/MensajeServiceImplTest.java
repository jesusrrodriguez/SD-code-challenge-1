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
	void invertirStringSinSignosTest() {
		mensaje = "Hello world";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("world Hello", mensajeInvertido, "Son iguales");
	}
	
    @Test
	void invertirStringConUnSignoTest() {
		mensaje = "Hello world!";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("world Hello!", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConDosSignosTest() {
		mensaje = "¡Hola mundo!";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("¡mundo Hola!", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConTresSignosTest() {
		mensaje = "Hace mucho tiempo... En un lugar... ¿¡Lejano!?";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("Lejano lugar un... En tiempo mucho... ¿¡Hace!?", mensajeInvertido, "Son iguales");
	}
}
