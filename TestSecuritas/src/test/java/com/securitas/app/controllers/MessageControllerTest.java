package com.securitas.app.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MessageControllerTest {

	
	@Autowired
	private MessageController messageMockController;
	
	@Test
	void testGetMessage() {
	
		//GIVEN - A message
		String message = "Hello World!!..";
		//WHEN
		ResponseEntity<String> messageInverse = messageMockController.getMessage(message);
		
		//THEN
		assertEquals("World Hello!!..", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}
	
	@Test
	void testGetMessageWithoutSigns() {

		//GIVEN
		String messageWithoutSigns = "Hello World";
		//WHEN
		ResponseEntity<String> messageInverse = messageMockController.getMessage(messageWithoutSigns);
		
		//THEN
		assertEquals("World Hello", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}
	
	@Test
	void testGetEmptyMessage() {
		//GIVEN - A message
		String emptyMessage="";
		//WHEN
		ResponseEntity<String> messageInverse = messageMockController.getMessage(emptyMessage);
		
		//THEN
		assertEquals("", messageInverse.getBody(), "Equals");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(406);
	}
	
	@Test
	void testGetLargeMessage() {
		//GIVEN - A message
		String largeMessage = "...Hi kids and welcome to Ntt Data!!";
		//WHEN
		ResponseEntity<String> messageInverse = messageMockController.getMessage(largeMessage);
		
		//THEN
		assertEquals("...Data Ntt to welcome and kids Hi!!", messageInverse.getBody(), "Compare");
		assertThat(messageInverse.getStatusCodeValue() ).isEqualTo(200);
	}

}
