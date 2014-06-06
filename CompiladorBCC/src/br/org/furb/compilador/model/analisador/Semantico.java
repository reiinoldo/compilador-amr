package br.org.furb.compilador.model.analisador;

public class Semantico implements Constants {
	private StringBuilder codigoIntermediario;

	public Semantico() {
		codigoIntermediario = new StringBuilder();
	}

	public void executeAction(int action, Token token) throws SemanticError {
		System.out.println("Ação #" + action + ", Token: " + token);
		switch (action) {
		case 1:
			action1();
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
			action5();
			break;
		case 6:
			action6();
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
			action16();
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

	private void action1() {
	}

	private void action2() {
	}

	private void action3() {
	}

	private void action4() {
	}

	private void action5() {
	}

	private void action6() {
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
	}

	private void action15() {
	}

	private void action16() {
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
