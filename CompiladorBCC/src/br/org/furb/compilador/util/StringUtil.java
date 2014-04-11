package br.org.furb.compilador.util;

public class StringUtil {	
	
	// Completa String com caracteres a direita
	public static String completaASC(String texto, String letra, int tamanho){
		
		StringBuffer sb = new StringBuffer(texto);
		
		for (int i=sb.length() ; i<tamanho ; i++)
            sb.append(letra);		
		
		return sb.toString();
		
	}

}
