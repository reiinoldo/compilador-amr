package br.org.furb.compilador.model;

public enum TipoDado {
	CTE_INTEGER("constante integer", "int64", "integer"), CTE_FLOAT(
			"constante float", "float64", "float"), CTE_STRING(
			"constante string", "string", "string"), CTE_BOOLEAN(
			"expressão boolean", "bool", "boolean"), NAO_IDENTIFICADO(
			"NAO IDENTIFICADO", "", "");

	private String nome;
	private String tipo;
	private String tipoDotNet;

	TipoDado(String nome, String tipoDotNet, String tipo) {
		this.nome = nome;
		this.tipoDotNet = tipoDotNet;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoDotNet() {
		return tipoDotNet;
	}

	public String getTipo() {
		return tipo;
	}

	public static TipoDado getTipo(String nome) {
		for (TipoDado tipo : values()) {
			if (tipo.getNome().equalsIgnoreCase(nome)) {
				return tipo;
			}
		}
		return null;
	}

	public static TipoDado getTipoPorTipo(String tipo) {
		for (TipoDado tipos : values()) {
			if (tipos.getTipo().equalsIgnoreCase(tipo)) {
				return tipos;
			}
		}
		return null;
	}
}
