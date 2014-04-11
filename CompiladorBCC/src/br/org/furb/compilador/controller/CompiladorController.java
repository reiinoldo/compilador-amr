package br.org.furb.compilador.controller;

import br.org.furb.compilador.model.lexico.LexicalError;
import br.org.furb.compilador.model.lexico.Lexico;
import br.org.furb.compilador.model.lexico.Token;
import br.org.furb.compilador.util.StringUtil;

public class CompiladorController {
	
	
	// Singleton
	
	public String compilar(String texto){
		
		if (texto.isEmpty() || texto.trim().equals("")){
			return "Nenhum programa para compilar!";
		}else{
		
			Lexico lexico = new Lexico();			
			String msgToken = "";
			Token token = null;
			
			lexico.setInput(texto);
			
			try{ 
				
				msgToken = StringUtil.completaASC("linha", " ", 8) +
			        	   StringUtil.completaASC("classe", " ", 22) +
			        	   "lexema\n"; 						
				
				while((token = lexico.nextToken()) != null){			
					msgToken = msgToken + token.toString() + "\n";					
				}				
				
				return msgToken + "\n" + "     programa compilado com sucesso";
				
			}catch ( LexicalError e ){				
				return e.getMessage();
			}
			
		}				
		
	}

}
