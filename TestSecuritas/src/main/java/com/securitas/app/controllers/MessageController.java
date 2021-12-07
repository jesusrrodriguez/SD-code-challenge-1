package com.securitas.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
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
	public String getMessage(@RequestParam("mensaje") String message) {
		return messageService.getInverseMessage(message);
	}

}
