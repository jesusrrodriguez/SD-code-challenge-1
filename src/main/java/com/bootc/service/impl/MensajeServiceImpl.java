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

	private final String todosLosSignos = "!¡¿?.";

	private Map<String, String> tieneSignoPuntuacion(String str, int index) {
		
		Map<String, String> informacionSignos = null;
		
		if(StringUtils.containsAny(str, todosLosSignos)) {
			informacionSignos = addSignos(new HashMap<String, String>(), str);

		}
		
		return informacionSignos;
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
		String strSinSignosALaDerecha = RegExUtils.removePattern(str, "[\\?¿!¡\\.]+$");

		return RegExUtils.removePattern(strSinSignosALaDerecha, "[^\\?¿!¡\\.]+");
	}
	
	private String getSignosDerechaString(String str) {
		String strSinSignosALaIzquierda = RegExUtils.removePattern(str, "^[\\?¿!¡\\.]+");

		return RegExUtils.removePattern(strSinSignosALaIzquierda, "[^\\?¿!¡\\.]+");
	}

	private String setSignos(List<Map<String, String>> signos, int index, String strACambiar) {
		if(signos.size()-1 >= index) {
			if(signos.get(index) != null) {
				strACambiar = StringUtils.prependIfMissing(strACambiar, signos.get(index).get("signosIzq"));
				strACambiar = StringUtils.appendIfMissing(strACambiar, signos.get(index).get("signosDer"));
			}
		}

		return strACambiar;
	}

	@Override
	public String invertirString(String string) {
		
		List<Map<String, String>> signos = new ArrayList<>();
		Map<String, String> informacionSignos;
		
		String[] stringArray = string.split(" ");
		
		for (int i = 0; i < stringArray.length; i++) {

			informacionSignos = tieneSignoPuntuacion(stringArray[i], i);
			
			if(informacionSignos != null) {
				stringArray[i] = RegExUtils.removePattern(stringArray[i], "[\\?¿!¡\\.]*");
				
				while(signos.size() < i) {
					signos.add(null);
				}
				
				signos.add(i, informacionSignos);
			}
		}
		
		String[] arrayInvertido = new String[stringArray.length];
		
		int j = stringArray.length -1;
		for(int i = 0; i < stringArray.length; i++) {
			arrayInvertido[j] = stringArray[i];

			arrayInvertido[j] = setSignos(signos, j, arrayInvertido[j]);
			
			j--;
		} 
		
		return StringUtils.join(arrayInvertido, " ");
	}
}
