package com.securitas.app.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.securitas.app.service.MessageService;

@SpringBootTest
class MessageControllerTest {

	private String message;
	private String messageWithoutSigns;
	private String largeMessage;
	private String emptyMessage;
	
	@InjectMocks
	private MessageController messageMockController;
	
	@Mock
	private MessageService messageMockService;
	
	@Autowired
	private MessageController messageController;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyMessage="";
		message = "Hello World!!..";
		messageWithoutSigns = "Hello World";
		largeMessage = "...Hi kids and welcome to Ntt Data!!";
	}

	@Test
	void testGetMessage() {
	
		//GIVEN - A message
			
		//WHEN
		ResponseEntity<String> messageInverse = messageController.getMessage(message);
		
		//THEN
		assertEquals("World Hello!!..", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}
	
	@Test
	void testGetMessageWithoutSigns() {
		//fail("Not yet implemented");
		
		//GIVEN
			
		//WHEN
		ResponseEntity<String> messageInverse = messageController.getMessage(messageWithoutSigns);
		
		//THEN
		assertEquals("World Hello", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}
	
	@Test
	void testGetEmptyMessage() {
		//GIVEN - A message
		
		//WHEN
		ResponseEntity<String> messageInverse = messageController.getMessage(emptyMessage);
		
		//THEN
		assertEquals("", messageInverse.getBody(), "Equals");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(406);
	}
	
	@Test
	void testGetLargeMessage() {
		//GIVEN - A message
		
		//WHEN
		ResponseEntity<String> messageInverse = messageController.getMessage(largeMessage);
		
		//THEN
		assertEquals("...Data Ntt to welcome and kids Hi!!", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}

}
