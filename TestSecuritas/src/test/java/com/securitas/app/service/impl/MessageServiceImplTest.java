package com.securitas.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.securitas.app.service.MessageService;

@SpringBootTest
class MessageServiceImplTest {

	private String message;
	private String messageWithoutSigns;
	private String largeMessage;
	private String emptyMessage;
	
	@Autowired
	private MessageService messageService;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyMessage=" ";
		message = "Hello everybody!!..";
		messageWithoutSigns = "Hello everybody";
		largeMessage = "...Hi kids and welcome to Ntt Data!!";
	}


	@Test
	void testGetSimpleMessageWithoutSigns() {
		//GIVEN - A message
		
		//WHEN
		String messageInverse = messageService.getInverseMessage(messageWithoutSigns);
		
		//THEN
		assertEquals("everybody Hello", messageInverse, "Compare");
	}
	
	@Test
	void testGetSimpleMessage() {
		//GIVEN - A message
		
		//WHEN
		String messageInverse = messageService.getInverseMessage(message);
		
		//THEN
		assertEquals("everybody Hello!!..", messageInverse, "Compare");
	}
	
	@Test
	void testGetEmptyMessage() {
		//GIVEN - A message
		
		//WHEN
		String messageInverse = messageService.getInverseMessage(emptyMessage);
		
		//THEN
		assertEquals("", messageInverse, "Compare");
	}
	
	@Test
	void testGetLargeMessage() {
		//GIVEN - A message
		
		//WHEN
		String messageInverse = messageService.getInverseMessage(largeMessage);
		
		//THEN
		assertEquals("...Data Ntt to welcome and kids Hi!!", messageInverse, "Compare");
	}
	
	

}
