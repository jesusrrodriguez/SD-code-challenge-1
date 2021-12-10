package com.securitas.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.app.service.MessageService;

@RestController
@RequestMapping("/inversor")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@GetMapping
	public ResponseEntity<String> getMessage(@RequestParam("mensaje") String message) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus httpStatus;
		
		String messageInverse="";
		try {
			
			if(message.equals("") || message.equals(" ")) {
				headers.set("Message", "Please, send a valid message. Not Empty.");
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
			}else {
				headers.set("Message","Message send");
				messageInverse = messageService.getInverseMessage(message);
				httpStatus = HttpStatus.OK;
			}
			
		}catch(Exception ex) {
			headers.set("Message","Message ERR");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		
		}
		
		return new ResponseEntity<>(messageInverse, headers, httpStatus);
		
	}

}
