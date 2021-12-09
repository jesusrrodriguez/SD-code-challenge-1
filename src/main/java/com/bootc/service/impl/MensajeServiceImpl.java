package com.bootc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bootc.service.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService{

	private String todosLosSignos = "!¡¿?.";
	private String[] todosLosSignosArray = {"!", "¡", "¿", "?", "."};
	
	private Map<String, String> tieneSignoPuntuacion(String str, int index) {
		
		Map<String, String> map = null;
		
		if(StringUtils.containsAny(str, todosLosSignos)) {
			map = new HashMap<String, String>();
			
			map = addSignos(map, str);
		}
		
		return map;
	}

	private Map<String, String> addSignos(Map<String, String> map, String str) {
		
		String izquierda = getSignosIzquierdaString(str);
		String derecha = getSignosDerechaString(str);
					
		if(!izquierda.isBlank() || !izquierda.isEmpty()) {
			map.put("signosIzq", izquierda);
		}
		if (!derecha.isBlank() || !derecha.isEmpty()) {
			map.put("signosDer", derecha);
		}
		
		return map;
	}
	
	private String getSignosIzquierdaString(String str) {
		str = RegExUtils.removePattern(str, "[\\?¿!¡\\.]+$");		
		String signos = RegExUtils.removePattern(str, "[^\\?¿!¡\\.]+");
		
		return signos;
	}
	
	private String getSignosDerechaString(String str) {
		str = RegExUtils.removePattern(str, "^[\\?¿!¡\\.]+");		
		String signos = RegExUtils.removePattern(str, "[^\\?¿!¡\\.]+");
		
		return signos;
	}

	@Override
	public String invertirString(String string) {
		
		List<Map<String, String>> signos = new ArrayList<>();
		Map<String, String> map;
		
		String[] stringArray = string.split(" ");
		
		for (int i = 0; i < stringArray.length; i++) {

			map = tieneSignoPuntuacion(stringArray[i], i);
			
			if(map != null) {
				stringArray[i] = RegExUtils.removePattern(stringArray[i], "[\\?¿!¡\\.]*");
				
				while(signos.size() < i) {
					signos.add(null);
				}
				
				signos.add(i, map);
			}
		}
		
		String[] aux = new String[stringArray.length];
		
		int j = stringArray.length -1;
		for(int i = 0; i < stringArray.length; i++) {
			aux[j] = stringArray[i];
			
			if(signos.size()-1 >= j) {
				if(signos.get(j) != null) {
					aux[j] = StringUtils.prependIfMissing(aux[j], signos.get(j).get("signosIzq"));
					aux[j] = StringUtils.appendIfMissing(aux[j], signos.get(j).get("signosDer"));
				}	
			}
			
			j--;
		} 
		
		return StringUtils.join(aux, " ");
	}
}
