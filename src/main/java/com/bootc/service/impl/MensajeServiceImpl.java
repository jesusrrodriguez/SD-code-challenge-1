package com.bootc.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.bootc.service.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService{

	@Override
	public boolean isSignoPuntuacion(char signo) {
		boolean ok = false;
		
		switch(signo) {
			case '!':
			case '.':	
			case '?':
				ok = true;
				break;
		}
		return ok;
	}

	@Override
	public String invertirString(String string) {
		String stringInvertido;
		char signo = string.charAt(string.length()-1);
		boolean tieneSignoPuntuacion = false;
	
		
		if(isSignoPuntuacion(signo)) {
			string = string.substring(0, string.length()-1);
			tieneSignoPuntuacion = true;
		}
		
		String[] stringArray = string.split(" ");
		String[] aux = new String[stringArray.length];
		
		int j = stringArray.length -1;
		for(int i = 0; i < stringArray.length; i++) {
			aux[j] = stringArray[i];
			j--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < aux.length; i++) {
		    sb.append(aux[i]);
		    
		    if (i != aux.length - 1) {
		        sb.append(" ");
		    }
		}
		
		stringInvertido = sb.toString();
		
		if(tieneSignoPuntuacion) {
			stringInvertido += signo;
		}
		
		return stringInvertido;
	}
	
}
