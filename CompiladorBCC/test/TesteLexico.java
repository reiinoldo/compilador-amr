import br.org.furb.compilador.model.lexico.LexicalError;
import br.org.furb.compilador.model.lexico.Lexico;
import br.org.furb.compilador.model.lexico.Token;

public class TesteLexico {
	public static void main(String[] args) throws LexicalError {
		
		Lexico lexico = new Lexico();
		boolean first = true;
		
		lexico.setInput("asd teste \n \n teste teste \n ASD asd as d00 _00asd teste "
				+ ";}");
		
		try{ 
			
			Token token = null;
			while((token = lexico.nextToken()) != null){			
				System.out.println(token.toString());
				
			}
			if (first){
				first = false;
				System.out.println("Linha  classe               lexema");
			}
		
		}catch ( LexicalError e ){
			
		    System.err.println(e.getMessage() + ", em " + e.getPosition());
		}
		
	}
}
