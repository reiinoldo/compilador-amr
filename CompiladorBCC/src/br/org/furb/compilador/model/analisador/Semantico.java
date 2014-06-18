package br.org.furb.compilador.model.analisador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import br.org.furb.compilador.model.TipoDado;

public class Semantico implements Constants {
	private StringBuilder codigo;
	private Stack<TipoDado> pilhaTipos;
	private String fileName;
	private Map<String, TipoDado> tabelaSimbolos;
	private List<String> listaId;
	private Stack<String> pilhaRotulos;

	public Semantico(String fileName) {
		this.fileName = fileName;
		codigo = new StringBuilder();
		pilhaTipos = new Stack<TipoDado>();
		tabelaSimbolos = new HashMap<String, TipoDado>();
		listaId = new ArrayList<String>();
		pilhaRotulos = new Stack<String>();
	}

	public String getCodigo() {
		return codigo.toString();
	}

	private void appendln(String text) {
		codigo.append(text + "\n");
	}

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
		switch (action) {
		case 1:
			action1(token);
			break;
		case 2:
			action2(token);
			break;
		case 3:
			action3(token);
			break;
		case 4:
			action4(token);
			break;
		case 5:
			action5(token);
			break;
		case 6:
			action6(token);
			break;
		case 7:
			action7(token);
			break;
		case 8:
			action8();
			break;
		case 9:
			action9();
			break;
		case 10:
			action10();
			break;
		case 11:
			action11();
			break;
		case 12:
			action12();
			break;
		case 13:
			action13();
			break;
		case 14:
			action14();
			break;
		case 15:
			action15();
			break;
		case 16:
			action16();
			break;
		case 17:
			action17();
			break;
		case 18:
			action18(token);
			break;
		case 19:
			action19(token);
			break;
		case 20:
			action20();
			break;
		case 21:
			action21();
			break;
		case 22:
			action22(token);
			break;
		case 23:
			action23();
			break;
		default:
			break;
		}
	}

	private void action1(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_FLOAT && tipo1 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}

		if (tipo1 == TipoDado.CTE_FLOAT || tipo2 == TipoDado.CTE_FLOAT) {
			pilhaTipos.push(TipoDado.CTE_FLOAT);
		} else if (tipo1 == TipoDado.CTE_INTEGER
				&& tipo2 == TipoDado.CTE_INTEGER) {
			pilhaTipos.push(TipoDado.CTE_INTEGER);
		}
		appendln("     add");
	}

	private void action2(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_FLOAT && tipo1 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo1 == TipoDado.CTE_FLOAT || tipo2 == TipoDado.CTE_FLOAT) {
			pilhaTipos.push(TipoDado.CTE_FLOAT);
		} else if (tipo1 == TipoDado.CTE_INTEGER
				&& tipo2 == TipoDado.CTE_INTEGER) {
			pilhaTipos.push(TipoDado.CTE_INTEGER);
		}
		appendln("     sub");
	}

	private void action3(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_FLOAT && tipo1 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo1 == TipoDado.CTE_FLOAT || tipo2 == TipoDado.CTE_FLOAT) {
			pilhaTipos.push(TipoDado.CTE_FLOAT);
		} else if (tipo1 == TipoDado.CTE_INTEGER
				&& tipo2 == TipoDado.CTE_INTEGER) {
			pilhaTipos.push(TipoDado.CTE_INTEGER);
		}
		appendln("     mul");
	}

	private void action4(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_FLOAT && tipo1 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_INTEGER.getNome() + " ou "
					+ TipoDado.CTE_FLOAT.getNome());
		}
		pilhaTipos.push(TipoDado.CTE_FLOAT);
		appendln("     div");
	}

	// carrega constante integer
	private void action5(Token token) {
		pilhaTipos.push(token.getTipo());
		appendln("     ldc.i8 " + token.getLexeme());

	}

	// carrega constante float
	private void action6(Token token) {
		pilhaTipos.push(token.getTipo());
		appendln("     ldc.r8 " + token.getLexeme());
	}

	// inveter sinal
	private void action7(Token token) throws SemanticError {
		pilhaTipos.push(TipoDado.CTE_INTEGER);
		appendln("     ldc.i8 -1");
		action3(token);
	}

	private void action8() {
	}

	private void action9() {
	}

	private void action10() {
	}

	// empilha true
	private void action11() {
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     ldc.i4.1");
	}

	// empilha false
	private void action12() {
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     ldc.i4.0");
	}

	// negação
	private void action13() throws SemanticError {
		TipoDado tipo = pilhaTipos.pop();
		if (tipo == TipoDado.CTE_BOOLEAN) {
			appendln("     ldc.i4.1");
			appendln("     xor");
		} else {
			throw new SemanticError("Esperado expressão boolean encontrado "
					+ tipo.getNome());
		}
	}

	// print
	private void action14() throws SemanticError {
		TipoDado tipoDado = pilhaTipos.pop();
		switch (tipoDado) {
		case CTE_BOOLEAN:
			appendln("     call void [mscorlib]System.Console::Write(bool)");
			break;
		case CTE_FLOAT:
			appendln("     call void [mscorlib]System.Console::Write(float64)");
			break;
		case CTE_INTEGER:
			appendln("     call void [mscorlib]System.Console::Write(int64)");
			break;
		case CTE_STRING:
			appendln("     call void [mscorlib]System.Console::Write(string)");
			break;
		// case NAO_IDENTIFICADO:
		// break;
		default:
			throw new SemanticError("Tipo de expressão inválida");
		}
	}

	// inicio do programa
	private void action15() {
		appendln(".assembly extern mscorlib{}");
		appendln(".assembly " + fileName + "{}");
		appendln(".module " + fileName + ".exe");
		appendln("");
		appendln(".class public " + fileName + " {");
		appendln("  .method public static void _principal ()");
		appendln("  {");
		appendln("     .entrypoint");
	}

	// fim do programa
	private void action16() {
		appendln("     ret");
		appendln("  }");
		appendln("}");
	}

	// println
	private void action17() {
		appendln("     ldstr \"\n\"");
		appendln("     call void [mscorlib]System.Console::Write(string)");
	}

	// OR
	private void action18(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_BOOLEAN.getNome());
		}
		if (tipo2 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_BOOLEAN.getNome());

		}
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     or");
	}

	// AND
	private void action19(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo1.getNome() + " esperado "
					+ TipoDado.CTE_BOOLEAN.getNome());
		}
		if (tipo2 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - encontrado " + tipo2.getNome() + " esperado "
					+ TipoDado.CTE_BOOLEAN.getNome());

		}
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     and");
	}

	private void action20() {
		
	}

	private void action21() {

	}

	private void action22(Token token) {
		pilhaTipos.push(token.getTipo());
		appendln("     ldstr " + token.getLexeme());
	}

	private void action23() {
	}
}
