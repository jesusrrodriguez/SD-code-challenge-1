package com.bootc.controller.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.bootc.service.MensajeService;

@SpringBootTest
public class ControllerRestTest {

    @InjectMocks
    ControllerRest controllerRestMock;

    @Mock
    MensajeService mensajeServiceMock;
    
    @Test
    void invertirMensajeExcepcion() throws Exception {
    	String mensaje = "Hello world!";
    	
    	when (mensajeServiceMock.invertirString(mensaje)).thenThrow(new Exception());
    	
    	ResponseEntity<String> re = controllerRestMock.invertirMensaje(mensaje);
        assertThat( re.getStatusCodeValue() ).isEqualTo(500);
    }
    
    @Test
    void invertirMensajeVacio() {
    	String mensaje = "";
    	ResponseEntity<String> re = controllerRestMock.invertirMensaje(mensaje);
    	
        assertThat( re.getStatusCodeValue() ).isEqualTo(406);
    }
    
    @Test
    void invertirMensajeValido() {
    	String mensaje = "Hello? World...";
    	ResponseEntity<String> re = controllerRestMock.invertirMensaje(mensaje);
    	
        assertThat( re.getStatusCodeValue() ).isEqualTo(200);
    }
}
