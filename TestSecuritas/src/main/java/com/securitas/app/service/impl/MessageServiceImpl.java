package com.securitas.app.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

import com.securitas.app.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	private static final String SIGNS = "?¿¡!.,:;";
	private static final String SYMB_EXP = "[?¿¡!.;]";
	
	@Override
	public String getInverseMessage(String message) {
		String[] mensajeArray = message.split(" ");
		String[] mensajeSinSignosArray = message.replaceAll(SYMB_EXP, "").split(" ");
		String[] mensajeSinSignosArrayInvertido = inversor(mensajeSinSignosArray.clone());

		
		List<String> result = new ArrayList<>();
		for(int i = 0; i<=mensajeArray.length-1; i++){

			String aux = mensajeArray[i];

			String endingSymbols = obtenerSignosAlFinal(aux);

			String startingSymbols = obtenerSignosAlInicio(aux);

			result.add(startingSymbols + mensajeSinSignosArrayInvertido[i] + endingSymbols);		
		   
		}
		return String.join(" ", result);
	}

	private String obtenerSignosAlInicio(String aux) {
		String startingSymbols = "";
		   boolean firstLetter = false;
		   for(int j = 0; j<=aux.length()-1; j++){
		      if(!firstLetter && SIGNS.contains(aux.substring(j, j+1))){
		         String pivot = startingSymbols;
		         startingSymbols = pivot + aux.substring(j, j+1);
		      } else {
		         firstLetter = true;
		      }
		   }
		return startingSymbols;
	}

	private String obtenerSignosAlFinal(String aux) {
		String endingSymbols = "";
		   boolean firstLetter = false;
		   for(int j = aux.length(); j>0; j--){
		      if(!firstLetter && SIGNS.contains(aux.substring(j-1, j))){
		         String pivot = endingSymbols;
		         endingSymbols = aux.substring(j-1, j) + pivot;
		      } else {
		         firstLetter = true;
		      }
		   }
		return endingSymbols;
	}
	
	private String[] inversor(String[] sourceArray) {
		   String aux;
		   for (int i = 0; i < sourceArray.length / 2; i++) {
		      aux = sourceArray[i];
		      sourceArray[i] = sourceArray[sourceArray.length - 1 - i];
		      sourceArray[sourceArray.length - 1 - i] = aux;
		   }

		   return sourceArray;
		}

}
