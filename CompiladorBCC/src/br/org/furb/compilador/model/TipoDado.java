package br.org.furb.compilador.model;

public enum TipoDado {
	CTE_INTEGER("constante integer", "int64"),
	CTE_FLOAT("constante float", "float64"),
	CTE_STRING("constante string", ""),
	CTE_BOOLEAN("expressão boolean", "bool"),
	NAO_IDENTIFICADO("NAO IDENTIFICADO", "");
	
	private String nome;
	private String tipoDotNet;
	
	TipoDado(String nome, String tipoDotNet) {
		this.nome = nome;
		this.tipoDotNet = tipoDotNet;
	}
	
	public String getNome() {
		return nome;
	}
	
	 public String getTipoDotNet() {
		return tipoDotNet;
	}
	
	public static TipoDado getTipo(String nome){
		for(TipoDado tipo : values()){
			if(tipo.getNome().equalsIgnoreCase(nome)){
				return tipo;
			}
		}
		return null;
	}
}
