package br.org.furb.compilador.model.analisador;

import br.org.furb.compilador.util.StringUtil;

public class Token
{
    private int id;
    private String lexeme;
    private int position;
    private int line;

    public Token(int id, String lexeme, int position, int line)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
        this.line = line;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }
    
    public final int getLine()
    {
        return line;
    }
    
    public final String getClasse(){
    	String classe;
    	
    	switch (id) {
		case 2:
			classe = "identificador";
			break;
		case 3:
			classe = "constante integer";
			break;
		case 4:
			classe = "constante float";
			break;
		case 5:
			classe = "constante string";
			break;
		default:
			if (id >= 6 && id <= 23)
				classe = "símbolo especial";
			else if (id >= 24 && id <= 39)
				classe = "palavra  reservada";
			else
				classe = "";
			break;
		}
    	return classe;
    }

    public String toString()
    {
        return StringUtil.completaASC(Integer.toString(getLine()), " ", 8) +
        	   StringUtil.completaASC(getClasse(), " ", 22) +
        	   getLexeme();
    };
}
