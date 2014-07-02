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
	private TipoDado tipoAtual;

	private Token tokenRelacional = null;
	private long proxRotulo = 0;

	public Semantico(String fileName) {
		this.fileName = fileName;
		codigo = new StringBuilder();
		pilhaTipos = new Stack<TipoDado>();
		tabelaSimbolos = new HashMap<String, TipoDado>();
		listaId = new ArrayList<String>();
		pilhaRotulos = new Stack<String>();
	}

	private String getNextRotulo() {
		proxRotulo++;

		return "L" + proxRotulo;
	}

	public String getCodigo() {
		return codigo.toString();
	}

	private void appendln(String text) {
		codigo.append(text + "\n");
	}

	public void executeAction(int action, Token token) throws SemanticError {
//		System.out.println("Ação #" + action + ", Token: " + token);

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
			action13(token);
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
			action20(token);
			break;
		case 21:
			action21(token);
			break;
		case 22:
			action22(token);
			break;
		case 23:
			action23(token);
			break;
		case 24:
			action24(token);
			break;
		case 25:
			action25(token);
			break;
		case 26:
			action26(token);
			break;
		case 27:
			action27(token);
			break;
		case 28:
			action28(token);
			break;
		case 29:
			action29(token, null);
			break;
		case 30:
			action30(token);
			break;
		case 31:
			action31(token);
			break;
		case 32:
			action32();
			break;
		case 33:
			action33();
			break;
		case 34:
			action34();
			break;
		case 35:
			action35(token);
			break;
		default:
			break;
		}
	}

	private void action1(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_FLOAT && tipo1 != TipoDado.CTE_INTEGER) {
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
							+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
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
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
							+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
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
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
							+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
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
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
							+ TipoDado.CTE_FLOAT.getNome());
		}
		if (tipo2 != TipoDado.CTE_FLOAT && tipo2 != TipoDado.CTE_INTEGER) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_INTEGER.getNome() + " ou "
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
		appendln("     ldc.r8 " + token.getLexeme().replace(",", "."));
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
	private void action13(Token token) throws SemanticError {
		TipoDado tipo = pilhaTipos.pop();
		if (tipo == TipoDado.CTE_BOOLEAN) {
			pilhaTipos.push(TipoDado.CTE_BOOLEAN);
			appendln("     ldc.i4.1");
			appendln("     xor");
		} else {
			throw new SemanticError(token.getLine(), tipo.getNome(),
					TipoDado.CTE_BOOLEAN.getNome());
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
		appendln("     ldstr \"\\n\"");
		appendln("     call void [mscorlib]System.Console::Write(string)");
	}

	// OR
	private void action18(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_BOOLEAN.getNome());
		}
		if (tipo2 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_BOOLEAN.getNome());
		}
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     or");
	}

	// AND
	private void action19(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		if (tipo1 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError(token.getLine(), tipo1.getNome(),
					TipoDado.CTE_BOOLEAN.getNome());
		}
		if (tipo2 != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError(token.getLine(), tipo2.getNome(),
					TipoDado.CTE_BOOLEAN.getNome());
		}
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		appendln("     and");
	}

	// guardar operador relacional
	private void action20(Token token) {
		tokenRelacional = token;
	}

	// aplicar operador relacional
	private void action21(Token token) throws SemanticError {
		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = pilhaTipos.pop();
		// Validação se um tipo for string os dois deverão ser string
		if ((tipo1 == TipoDado.CTE_STRING) || (tipo2 == TipoDado.CTE_STRING)) {
			if (tipo1 != TipoDado.CTE_STRING) {
				throw new SemanticError(token.getLine(), tipo1.getNome(),
						TipoDado.CTE_STRING.getNome());
			}
			if (tipo2 != TipoDado.CTE_STRING) {
				throw new SemanticError(token.getLine(), tipo2.getNome(),
						TipoDado.CTE_STRING.getNome());
			}
		}
		pilhaTipos.push(TipoDado.CTE_BOOLEAN);
		switch (tokenRelacional.getLexeme()) {
		case "==":
			appendln("     ceq");
			break;
		case "!=":
			appendln("     ceq");
			action13(token);
			break;
		case ">":
			appendln("     cgt");
			break;
		case "<":
			appendln("     clt");
			break;
		case "<=":
			appendln("     cgt");
			appendln("     ldc.i4 0");
			appendln("     ceq");
			break;
		case ">=":
			appendln("     clt");
			appendln("     ldc.i4 0");
			appendln("     ceq");
			break;
		}

	}

	// empilha string
	private void action22(Token token) {
		pilhaTipos.push(token.getTipo());
		appendln("     ldstr " + token.getLexeme());
	}

	// verificar +String ou +Boolean
	private void action23(Token token) throws SemanticError {
		if (!(token.getTipo() == TipoDado.CTE_FLOAT || token.getTipo() == TipoDado.CTE_INTEGER)) {
			throw new SemanticError(token.getLine(), token.getLexeme(),
					TipoDado.CTE_INTEGER.getTipo() + " ou "
							+ TipoDado.CTE_FLOAT.getTipo());
		}
	}

	// EMPILHA TIPO DE DADOS PARA DECLARAÇÃO
	private void action24(Token token) {
		tipoAtual = TipoDado.getTipoPorTipo(token.getLexeme());
	}

	// adiciona o identificado na listaID
	private void action25(Token token) throws SemanticError {
		listaId.add(token.getLexeme());
	}

	// verifica se identificadores já estão declarados.
	private void action26(Token token) {
		for (int i = 0; i < listaId.size(); i++) {
			String identificador = listaId.get(i);
			if (tabelaSimbolos.containsKey(identificador)) {
				new SemanticError("Erro na linha: " + token.getLine()
						+ " - identificador " + identificador + "já declarado.");
			}
			tabelaSimbolos.put(identificador, tipoAtual);
			appendln("     .locals(" + tipoAtual.getTipoDotNet() + " "
					+ identificador + ")");
		}
	}

	// comando SCAN
	private void action27(Token token) throws SemanticError {
		for (String id : listaId) {
			if (!tabelaSimbolos.containsKey(id)) {
				throw new SemanticError("Erro na linha " + token.getLine()
						+ " - identificador " + id + " não declarado.");
			}

			TipoDado tipo = tabelaSimbolos.get(id);

			appendln("     call string [mscorlib]System.Console::ReadLine()");
			switch (tipo) {
			case CTE_BOOLEAN:
				appendln("     call bool [mscorlib]System.Boolean::Parse(string)");
				break;
			case CTE_FLOAT:
				appendln("     call float64 [mscorlib]System.Double::Parse(string)");
				break;
			case CTE_INTEGER:
				appendln("     call int64 [mscorlib]System.Int64::Parse(string)");
				break;
			default:
				break;
			}
			appendln("     stloc " + id);
		}
		listaId = new ArrayList<String>();
	}

	// imprimir identificadores
	private void action28(Token token) throws SemanticError {
		String id = token.getLexeme();
		if (!tabelaSimbolos.containsKey(id)) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - identificador " + id + " não declarado.");
		}
		TipoDado tipo = tabelaSimbolos.get(id);
		pilhaTipos.push(tipo);

		appendln("     ldloc " + id);
	}

	// atribuição
	private void action29(Token token, String id) throws SemanticError {
		if (id == null) {
			id = listaId.remove(0);
		}
		if (!tabelaSimbolos.containsKey(id)) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - identificador " + id + " não declarado.");
		}

		TipoDado tipo1 = pilhaTipos.pop();
		TipoDado tipo2 = tabelaSimbolos.get(id);

		if (tipo1 != tipo2) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - tipos incompativeis na atribuição.");
		}

		appendln("     stloc " + id);
	}

	// atribuir valor nas variaveis na decaração
	private void action30(Token token) throws SemanticError {
		TipoDado tipo = token.getTipo();
		boolean trueOrFalse = token.getLexeme().equalsIgnoreCase("true")
				|| token.getLexeme().equalsIgnoreCase("false");
		if ((tipo != TipoDado.NAO_IDENTIFICADO) || (trueOrFalse)) {
			for (String id : listaId) {
				switch (tipo) {
				case CTE_FLOAT:
					action6(token);
					break;
				case CTE_INTEGER:
					action5(token);
					break;
				case CTE_STRING:
					action22(token);
					break;
				default:
					if (trueOrFalse) {
						if (token.getLexeme().equalsIgnoreCase("true")) {
							action11();
						} else {
							action12();
						}
					}
					break;
				}
				action29(token, id);
			}
		}

		listaId = new ArrayList<String>();
	}

	// inicio do if
	private void action31(Token token) throws SemanticError {
		TipoDado tipo = pilhaTipos.pop();
		if (tipo != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - esperado expressão boleana.");
		}

		String rotuloFalse = getNextRotulo();
		pilhaRotulos.push(rotuloFalse);
		appendln("     brfalse " + rotuloFalse);
	}

	// final do if
	private void action32() {
		String rotuloFinal = pilhaRotulos.pop();
		appendln("  " + rotuloFinal + ":");
	}

	// else
	private void action33() {
		String rotuloFalse = pilhaRotulos.pop();
		String rotuloFinal = getNextRotulo();
		pilhaRotulos.push(rotuloFinal);
		appendln("     br " + rotuloFinal);
		appendln("  " + rotuloFalse + ":");
	}

	// inicio do-while
	private void action34() {
		String rotulo = getNextRotulo();
		pilhaRotulos.push(rotulo);
		appendln("  " + rotulo + ":");
	}

	// condição do-while
	private void action35(Token token) throws SemanticError {
		TipoDado tipo = pilhaTipos.pop();
		if (tipo != TipoDado.CTE_BOOLEAN) {
			throw new SemanticError("Erro na linha " + token.getLine()
					+ " - esperado expressão boleana.");
		}

		appendln("     brtrue " + pilhaRotulos.pop());
	}
}
