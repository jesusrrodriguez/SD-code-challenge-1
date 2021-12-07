package com.securitas.app.service.impl;


import org.springframework.stereotype.Service;

import com.securitas.app.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public String getInverseMessage(String message) {
		
		String regExSplitSigns = "[?!.,:;]";
		String regExSplit = "[ ]";
		String [] messageSplit = message.split(regExSplit);
		
		String messageInverse = "";
		String signs = "";
		
				
		
		for(int i=messageSplit.length-1; i>=0; i--) {
			
			String [] messageSplitWithSigns = messageSplit[i].split(regExSplitSigns);
			if(i==messageSplit.length-1) {
				signs = signs.concat(messageSplit[i].substring(messageSplitWithSigns[0].length()));	
			}
		
			for(int j=0; j<messageSplitWithSigns.length; j++) {
				messageInverse = messageInverse.concat(messageSplitWithSigns[j]).concat(" ");
			}
		}
		messageInverse = messageInverse.substring(0,messageInverse.length()-1);
		messageInverse = messageInverse.concat(signs);
		
		return messageInverse;

	}

}
