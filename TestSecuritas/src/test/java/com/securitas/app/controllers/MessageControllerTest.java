package com.securitas.app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageControllerTest {

	private String message;
	private String messageWithoutSigns;
	
	@Autowired
	private MessageController messageController;
	
	@BeforeEach
	void setUp() throws Exception {
		message = "Hello World!!!!!....";
		messageWithoutSigns = "Hello World";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMessage() {
		//fail("Not yet implemented");
		
		//GIVEN
			
		//WHEN
		String messageInverse = messageController.getMessage(message);
		
		//THEN
		assertEquals("World Hello!!!!!....", messageInverse, "Son iguales");
		//assertEquals(message, messageInverse);
	}
	
	@Test
	void testGetMessageWithoutSigns() {
		//fail("Not yet implemented");
		
		//GIVEN
			
		//WHEN
		String messageInverse = messageController.getMessage(messageWithoutSigns);
		
		//THEN
		assertEquals("World Hello", messageInverse, "Son iguales");
		//assertEquals(message, messageInverse);
	}

}
