package com.securitas.service.impl;

import org.springframework.stereotype.Service;

import com.securitas.service.MensajeService;

@Service
public class MensajeServiceImpl implements MensajeService{
	
	private static final String signosPuntuacion = "!¡?¿.;";
	
	@Override
	public String inversorPalabras(String mensaje) throws Exception{
		
		
	    String mensajeSinSignosPuntuacion ;
		String arrayMensajeSinSignosPuntuacion[];
		String mensajeInvertido;
		String arrayMensaje[];
		String arrayMensajeInvertidoSinSignosPuntuacion[];
		
		mensajeSinSignosPuntuacion = eliminarSignos(mensaje);
		arrayMensajeSinSignosPuntuacion = convertirStringEnArray(mensajeSinSignosPuntuacion);
		mensajeInvertido = invertirArray(arrayMensajeSinSignosPuntuacion);
		arrayMensaje = convertirStringEnArray(mensaje);
		arrayMensajeInvertidoSinSignosPuntuacion = convertirStringEnArray(mensajeInvertido);
		arrayMensajeInvertidoSinSignosPuntuacion = concatenarSignos(arrayMensajeInvertidoSinSignosPuntuacion,arrayMensaje);
		mensajeInvertido = convertirArrayEnString(arrayMensajeInvertidoSinSignosPuntuacion);
		
		return mensajeInvertido;
	}
	
	private String eliminarSignos(String mensaje) {
		return mensaje.replaceAll("[?¿¡!.;]", "");
	}
	
	private String[] convertirStringEnArray(String mensajeSinSignosPuntuacion) {
		return mensajeSinSignosPuntuacion.split(" ");
	}
	
	private String invertirArray(String[] arrayMensajeSinSignosPuntuacion) {
		
		String mensajeInvertido = "";
		
		for (int x=arrayMensajeSinSignosPuntuacion.length-1;x>=0;x--){
			
			if( x == 0) {
				mensajeInvertido = mensajeInvertido.concat(arrayMensajeSinSignosPuntuacion[x]);
			}else {
				mensajeInvertido = mensajeInvertido.concat(arrayMensajeSinSignosPuntuacion[x]).concat(" ");
			}
		}
		return mensajeInvertido;
	}
	
	private String convertirArrayEnString(String [] arrayMensajeInvertidoSinSignosPuntuacion) {
		String mensajeInvertido = "";
		for (int x=0; x<=arrayMensajeInvertidoSinSignosPuntuacion.length-1; x++){
			
			if( x == arrayMensajeInvertidoSinSignosPuntuacion.length-1) {
				mensajeInvertido = mensajeInvertido.concat(arrayMensajeInvertidoSinSignosPuntuacion[x]);
			}else {
				mensajeInvertido = mensajeInvertido.concat(arrayMensajeInvertidoSinSignosPuntuacion[x]).concat(" ");
			}
		}
		return mensajeInvertido;
	}
	
	private String[] concatenarSignos (String[] arrayMensajeInvertidoSinSignosPuntuacion, String[] arrayMensaje) {
		for (int x=0; x<=arrayMensaje.length-1; x++) {
				//Compruebo si la palabra empieza por signo y cuantos tiene
				int i = 1;
				while(signosPuntuacion.contains(arrayMensaje[x].substring(i-1, i))) {
					i++;
				};
			
				if (signosPuntuacion.contains(arrayMensaje[x].substring(0, 1))){
					arrayMensajeInvertidoSinSignosPuntuacion[x]=
							arrayMensaje[x].substring(0, i-1).concat(arrayMensajeInvertidoSinSignosPuntuacion[x]);
				}
				//Compruebo si la palabra acaba por signo y cuantos tiene
				i = arrayMensaje[x].length();
				while(signosPuntuacion.contains(arrayMensaje[x].substring(i-1, i))) {
					i--;
				};
				
				if (signosPuntuacion.contains(arrayMensaje[x].substring(arrayMensaje[x].length()-1, arrayMensaje[x].length()))){
					arrayMensajeInvertidoSinSignosPuntuacion[x]=
							arrayMensajeInvertidoSinSignosPuntuacion[x].concat(arrayMensaje[x].substring(i, arrayMensaje[x].length()));
				}
		}
		return arrayMensajeInvertidoSinSignosPuntuacion;
	}
}
