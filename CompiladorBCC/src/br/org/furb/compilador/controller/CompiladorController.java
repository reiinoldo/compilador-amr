package br.org.furb.compilador.controller;

public class CompiladorController {
	
	
	// Singleton
	
	public String compilar(String texto){
		if (texto.isEmpty() || texto.trim().equals("")){
			return "Nenhum programa para compilar!";
		}
		
		return texto;
		
	}

}
