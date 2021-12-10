package com.securitas.app.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.securitas.app.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	private static final String REGEX_SPLIT = "[ ]";
	private static final String REGEX_SPLIT_SIGNS = "[?¿¡!.,:;]";
	
	
	@Override
	public String getInverseMessage(String message) {
		
		String messageInverse = "";
		
		Map<Integer, String> mapSigns = getSigns(message);
		Map<Integer, String> mapStrings = getMessageWithoutSigns(message);
		
		mapChangeOrder(mapStrings);
		
		mapInsertSigns(mapStrings,mapSigns);
		
		
		ArrayList<Integer> keys = new ArrayList<Integer>(mapStrings.keySet());
		for(int i=0; i<keys.size();i++){
			messageInverse = messageInverse.concat(mapStrings.get(keys.get(i)));
            
        }
				
		return messageInverse;

	}
	
	private void mapInsertSigns(Map<Integer, String> map, Map<Integer, String> mapSigns) {
		map.putAll(mapSigns);

	}
	
	private void mapChangeOrder(Map<Integer, String> map){
		
		
		int j;
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
        for(int i=0; i<keys.size()/2+1;i++){
        	String valor = map.get(keys.get(i));
        	if(!valor.equals("")) {
        		for(j=keys.size()-1;j>=keys.size()/2+1;j--) {
        			String valor2 = map.get(keys.get(j));
        			if(!valor2.equals("")) {
        				map.replace(i, valor2);
        				map.replace(j, valor);
        			}
        		}
        		
        	}
            
        }
	}
	
	private Map<Integer, String> getSigns(String message){
		Map<Integer, String> mapSigns = new TreeMap<>();

		String [] messageSplit = message.split(REGEX_SPLIT);
		int k=0;
		int posMessage=0;
		
		if(messageSplit.length>0) {
			
			for(int i=0; i<messageSplit.length; i++) {
				
			
				String [] messageSplitWithSigns = StringUtils.splitPreserveAllTokens(messageSplit[i],REGEX_SPLIT_SIGNS);
	
			
				for(int j=0; j<messageSplitWithSigns.length; j++) {
					if(messageSplitWithSigns[j].equals("") 
							|| messageSplitWithSigns[j].isBlank() 
							|| messageSplitWithSigns[j].isEmpty()) {
						
						mapSigns.put(posMessage, messageSplit[i].substring(k,k+1));
						k++;
						posMessage++;
					}else {
						
						k=messageSplitWithSigns[j].length();
						posMessage+=k;
						
					}
						
				}
				posMessage++;
				
				
			}
		
		}
		
		return mapSigns;	
	}
	
	

	
	private String getStringInverse(String message){
		
		String messageInverse="";
		String [] messageArray = message.split(REGEX_SPLIT);
		for(int i=messageArray.length-1;i>=0;i--) {
			messageInverse = messageInverse.concat(messageArray[i]).concat(" ");
		}
		
		return messageInverse;
	}
	
	private Map<Integer, String> getMessageWithoutSigns(String message) {

		String [] messageArr = message.split(REGEX_SPLIT_SIGNS);

	
		Map<Integer, String> mapStrings = new TreeMap<>();
		int pos=0;
		
		for(int i=0; i<messageArr.length; i++) {
			
			mapStrings.put(pos, getStringInverse(messageArr[i]).trim());
			pos++;
			
		}
		
		return mapStrings;
	}
	
	

}
