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
	
    @Test
	void invertirStringSinSignosTest() throws Exception {
		mensaje = "Hello world";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("world Hello", mensajeInvertido, "Son iguales");
	}
	
    @Test
	void invertirStringConUnSignoTest() throws Exception {
		mensaje = "Hello world!";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("world Hello!", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConDosSignosTest() throws Exception {
		mensaje = "¡Hola mundo!";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("¡mundo Hola!", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConTresSignosTest() throws Exception {
		mensaje = "Hace mucho tiempo... En un lugar... ¿¡Lejano!?";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("Lejano lugar un... En tiempo mucho... ¿¡Hace!?", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConUnaPalabra() throws Exception {
		mensaje = "Hello";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("Hello", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConDosPalabras() throws Exception {
		mensaje = "Hello! World";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("World! Hello", mensajeInvertido, "Son iguales");
	}
    
    @Test
	void invertirStringConTresPalabras() throws Exception {
		mensaje = "Hola precioso... ¿Mundo?";
		String mensajeInvertido = mensajeService.invertirString(mensaje);
		
		assertEquals("Mundo precioso... ¿Hola?", mensajeInvertido, "Son iguales");
	}
}
