package com.securitas.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
@SpringBootTest
class MensajeServiceImplTest {

private String mensaje, mensajeInvertido;
	
	@Autowired
	MensajeServiceImpl service;
	
	@BeforeEach
	void setUp() throws Exception {
		mensaje= "";
		mensajeInvertido= "";
	}

	@AfterEach
	void tearDown() throws Exception {
		
		mensaje= "";
		mensajeInvertido= "";
	}

	@Test
	void mensajeTresPalabrasConSigno() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		mensajeInvertido = service.inversorPalabras("Diego prueba solucion!");
		//THEN:
			assertEquals("solucion prueba Diego!", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeVariosSignos() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		 mensajeInvertido = service.inversorPalabras("Diego prueba la solución! Pero no funciona!");
		
		
		//THEN:
			assertEquals("funciona no Pero solución! la prueba Diego!", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeVariosSignosSeguidosDelanteYDetras() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		 mensajeInvertido = service.inversorPalabras("Esto es un... ¡¿Test?!");
		
		
		//THEN:
			assertEquals("Test un es... ¡¿Esto?!", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeVariosSignosSeguidosDelante() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		 mensajeInvertido = service.inversorPalabras("Esto es un ¡¿Test");
		
		
		//THEN:
			assertEquals("Test un es ¡¿Esto", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeVariosSignosSeguidosDetras() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		 mensajeInvertido = service.inversorPalabras("Esto es un Test?¡");
		
		
		//THEN:
			assertEquals("Test un es Esto?¡", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeTresPalabras() throws Exception {
		//GIVEN:
		//Hay mensaje:
	
		//WHEN:
		mensajeInvertido = service.inversorPalabras("Diego prueba solución!");
		//THEN:
			assertEquals("solución prueba Diego!", mensajeInvertido, "Son iguales");
	}

	@Test
	void mensajeConSignoPuntuacion() throws Exception {
		//GIVEN:
		//Hay mensaje:
		mensaje = "Hola Mundo¡";
		//WHEN:
		mensajeInvertido = service.inversorPalabras(mensaje);
		
		//THEN:
			assertEquals("Mundo Hola¡", mensajeInvertido, "Son iguales");
	}
	
	@Test
	void mensajeSinSignoPuntuacion() throws Exception {
		//GIVEN:
		//Hay mensaje:
			mensaje = "Hola Mundo";
					
		//WHEN:
		mensajeInvertido = service.inversorPalabras(mensaje);
		
		//THEN:
			assertEquals("Mundo Hola", mensajeInvertido, "Son iguales");
	}

}
