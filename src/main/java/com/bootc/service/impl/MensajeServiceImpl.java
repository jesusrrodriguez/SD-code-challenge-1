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
	
	private Map<String, String> map;
	private List<Map<String, String>> signos;
	
	@Override
	public boolean tieneSignoPuntuacion(String str, int index) {
		boolean ok = false;
		
		if(StringUtils.containsAny(str, todosLosSignos)) {
			ok = true;
			map = new HashMap<String, String>();
			
			String izquierda = getSignosIzquierdaString(str);
			String derecha = getSignosDerechaString(str);
						
			if(!izquierda.isBlank() || !izquierda.isEmpty()) {
				map.put("signosIzq", izquierda);
			}
			if (!derecha.isBlank() || !derecha.isEmpty()) {
				map.put("signosDer", derecha);
			}
			
			while (signos.size() < index)
			{
			     signos.add(null);
			}
			signos.add(index, map);
		}
		
		return ok;
	}

	@Override
	public String getSignosIzquierdaString(String str) {
		str = RegExUtils.removePattern(str, "[\\?¿!¡\\.]+$");		
		String signos = RegExUtils.removePattern(str, "[^\\?¿!¡\\.]+");
		
		return signos;
	}
	
	@Override
	public String getSignosDerechaString(String str) {
		str = RegExUtils.removePattern(str, "^[\\?¿!¡\\.]+");		
		String signos = RegExUtils.removePattern(str, "[^\\?¿!¡\\.]+");
		
		return signos;
	}

	@Override
	public String invertirString(String string) {
		
		signos = new ArrayList<>();
		
		String[] stringArray = string.split(" ");
		
		for (int i = 0; i < stringArray.length; i++) {

			if(tieneSignoPuntuacion(stringArray[i], i)) {
				stringArray[i] = RegExUtils.removePattern(stringArray[i], "[\\?¿!¡\\.]*");
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
