package com.securitas.service.impl;

import org.springframework.stereotype.Service;

import com.securitas.service.SecuritasService;

@Service
public class SecuritasServiceImpl implements SecuritasService{
	
	public String inversor(String mensaje) {
		
		String mensajeInvertido = "";
		String arrayMensaje[] = mensaje.split(" ");
		String signosPuntuacion = "¡?.";
		int indice = arrayMensaje.length-1;
		String ultimaPalabra = arrayMensaje[indice];
		
		if(signosPuntuacion.contains(ultimaPalabra.substring(ultimaPalabra.length()-1))) {
			arrayMensaje[0]= arrayMensaje[0].concat(ultimaPalabra.substring(ultimaPalabra.length()-1));
			arrayMensaje[indice] = ultimaPalabra.substring(0, ultimaPalabra.length()-1);
		}
		
		for (int x=arrayMensaje.length-1;x>=0;x--){
			
			
			if( x == 0) {
				mensajeInvertido = mensajeInvertido.concat(arrayMensaje[x]);
			}else {
				mensajeInvertido = mensajeInvertido.concat(arrayMensaje[x]).concat(" ");
			}
			
		}
		
		return mensajeInvertido;
	}

	
}
