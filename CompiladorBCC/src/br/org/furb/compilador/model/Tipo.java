package br.org.furb.compilador.model;

public enum Tipo {
	CTE_INTEGER("constante integer"),
	CTE_FLOAT("constante float"),
	CTE_STRING("constante string"),
	CTE_BOOLEAN(""),
	NAO_IDENTIFICADO("NAO IDENTIFICADO");
	
	private String nome;
	
	Tipo(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
