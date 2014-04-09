package br.org.furb.compilador.controller;

public class Compilador {
	
	
	// Singleton
	
	public String Compilar(String texto){
		if (texto.isEmpty() || texto.trim().equals("")){
			return "Nenhum programa para compilar!";
		}
		
		return texto;
		
	}

}
