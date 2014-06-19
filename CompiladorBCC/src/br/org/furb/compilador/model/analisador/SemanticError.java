package br.org.furb.compilador.model.analisador;


@SuppressWarnings("serial")
public class SemanticError extends AnalysisError {
	public SemanticError(String msg, int position) {
		super(msg, position);
	}

	public SemanticError(String msg) {
		super(msg);
	}

	public SemanticError(int linha, String encontrado, String esperado) {
		super("Erro na linha " + linha + " - econtrado " + encontrado
				+ " esperado " + esperado);
	}
}
