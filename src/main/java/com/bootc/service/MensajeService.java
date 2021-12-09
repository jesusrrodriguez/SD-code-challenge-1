package com.bootc.service;

public interface MensajeService {
	public boolean tieneSignoPuntuacion(String str, int index);
	public String invertirString(String string);
	public String getSignosIzquierdaString(String str);
	public String getSignosDerechaString(String str);
}
