import br.org.furb.compilador.model.lexico.LexicalError;
import br.org.furb.compilador.model.lexico.Lexico;
import br.org.furb.compilador.model.lexico.Token;

public class TesteLexico {
	public static void main(String[] args) throws LexicalError {
		Lexico lexico = new Lexico();
		
		lexico.setInput("asd teste teste teste  ASD asd as d00 _00asd teste \n"
				+ ";}");
		
		Token token = null;
		while((token = lexico.nextToken()) != null){			
			System.out.println(token);
		}
		
	}
}
