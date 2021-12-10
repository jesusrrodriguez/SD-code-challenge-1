package com.securitas.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.securitas.app.service.MessageService;

@SpringBootTest
class MessageServiceImplTest {


	@InjectMocks
	private MessageServiceImpl messageService;
	
	@Test
	void testGetSimpleMessageWithoutSigns() {
		//GIVEN - A message
		String messageWithoutSigns = "Hello everybody";
		//WHEN
		String messageInverse = messageService.getInverseMessage(messageWithoutSigns);
		
		//THEN
		assertEquals("everybody Hello", messageInverse, "Compare");
	}
	
	@Test
	void testGetSimpleMessage() {
		//GIVEN - A message
		String message = "Hello everybody!!..";
		//WHEN
		String messageInverse = messageService.getInverseMessage(message);
		
		//THEN
		assertEquals("everybody Hello!!..", messageInverse, "Compare");
	}
	
	@Test
	void testGetEmptyMessage() {
		//GIVEN - A message
		String emptyMessage=" ";
		//WHEN
		String messageInverse = messageService.getInverseMessage(emptyMessage);
		
		//THEN
		assertEquals("", messageInverse, "Compare");
	}
	
	@Test
	void testGetLargeMessage() {
		//GIVEN - A message
		String largeMessage = "...Hi kids and welcome to Ntt Data!!";
		//WHEN
		String messageInverse = messageService.getInverseMessage(largeMessage);
		
		//THEN
		assertEquals("...Data Ntt to welcome and kids Hi!!", messageInverse, "Compare");
	}

	@Test
	void testWithInnerSymbols() {
		//GIVEN - A message
		String innerSymbolsMessage = "...Hi kids! and welcome? to Ntt Data!!";
		//WHEN
		String messageInverse = messageService.getInverseMessage(innerSymbolsMessage);
		
		//THEN
		assertEquals("...Data Ntt! to welcome? and kids Hi!!", messageInverse, "Compare");
	}
	
	@Test
	void testRepeatedSignsInWords() {
		// GIVEN - A message
		String innerSymbolsMessage = "I am impressive!!!! You are welcome!!!";
		// WHEN
		String messageInverse = messageService.getInverseMessage(innerSymbolsMessage);

		// THEN
		assertEquals("welcome are You!!!! impressive am I!!!", messageInverse, "Compare");
	}
	

	
	

}
