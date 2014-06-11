package br.org.furb.compilador.model.analisador;

import java.util.Stack;

import br.org.furb.compilador.model.Tipo;

public class Semantico implements Constants {
	private StringBuilder codigo;
	private Stack<Tipo> tipos;
	private String fileName;

	public Semantico(String fileName) {
		this.fileName = fileName;
		codigo = new StringBuilder();
		tipos = new Stack<Tipo>();
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
			action2();
			break;
		case 3:
			action3();
			break;
		case 4:
			action4();
			break;
		case 5:
			action5(token);
			break;
		case 6:
			action6(token);
			break;
		case 7:
			action7();
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
			action16(action);
			break;
		case 17:
			action17();
			break;
		case 18:
			action18();
			break;
		case 19:
			action19();
			break;
		case 20:
			action20();
			break;
		case 21:
			action21();
			break;
		case 22:
			action22();
			break;
		case 23:
			action23();
			break;
		default:
			break;
		}
	}

	private void action1(Token token) throws SemanticError {
		Tipo tipo1 = tipos.pop();
		Tipo tipo2 = tipos.pop();
		if(tipo1 !=  Tipo.CTE_FLOAT && tipo1 != Tipo.CTE_INTEGER){
			throw new SemanticError("encontrado ("+token.getClasse()+") esperado (constante float ou constante inteira)");
		}
		if (tipo1 == Tipo.CTE_FLOAT || tipo2 == Tipo.CTE_FLOAT) {
			tipos.push(Tipo.CTE_FLOAT);
		} else if (tipo1 == Tipo.CTE_INTEGER && tipo2 == Tipo.CTE_INTEGER) {
			tipos.push(Tipo.CTE_INTEGER);
		} 
		appendln("     add");
	}

	private void action2() {
		appendln("     sub");
	}

	private void action3() {
		appendln("     mul");
	}

	private void action4() {
		appendln("     div");
	}

	private void action5(Token token) {
		appendln("     ldc.i8 " + token.getLexeme());
	}

	private void action6(Token token) {
		appendln("     ldc.r8 " + token.getLexeme());
	}

	private void action7() {

	}

	private void action8() {
	}

	private void action9() {
	}

	private void action10() {
	}

	private void action11() {
	}

	private void action12() {
	}

	private void action13() {
	}

	private void action14() {
		appendln("     call void [mscorlib]System.Console::Write(int64)");
	}

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

	private void action16(int action) {
		System.out.println("Ação: " + action
				+ " - reconhecimento de fim de programa");
		appendln("     ret");
		appendln("  }");
		appendln("}");
		System.out.println(codigo.toString());
	}

	private void action17() {
	}

	private void action18() {
	}

	private void action19() {
	}

	private void action20() {
	}

	private void action22() {
	}

	private void action21() {
	}

	private void action23() {
	}
}
