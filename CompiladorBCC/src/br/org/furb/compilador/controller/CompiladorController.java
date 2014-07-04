package br.org.furb.compilador.controller;

import br.org.furb.compilador.model.analisador.LexicalError;
import br.org.furb.compilador.model.analisador.Lexico;
import br.org.furb.compilador.model.analisador.SemanticError;
import br.org.furb.compilador.model.analisador.Semantico;
import br.org.furb.compilador.model.analisador.Sintatico;
import br.org.furb.compilador.model.analisador.SyntaticError;
import br.org.furb.compilador.util.FileUtil;
import br.org.ilasm.IlasmBuilder;
import br.org.ilasm.exception.BuildException;

public class CompiladorController {
	private static final String COMPILADO_COM_SUCESSO = "programa compilado com sucesso";

	private Lexico lexico;
	private Sintatico sintatico;
	private Semantico semantico;

	private String fileName;
	private String pathFile;

	/**
	 * Construtor para compilar.
	 */
	public CompiladorController() {
		this.lexico = new Lexico();
		this.sintatico = new Sintatico();
	}

	/**
	 * Construtor para compilar e gerar código
	 * 
	 * @param fileName
	 * @param pathFile
	 */
	public CompiladorController(String fileName, String pathFile) {
		this();
		this.fileName = fileName;
		this.pathFile = pathFile;
	}

	public String compilar(String texto) {
		this.lexico.setInput(texto);
		this.semantico = new Semantico(fileName);

		try {
			this.sintatico.parse(lexico, semantico);

			return COMPILADO_COM_SUCESSO;
		} catch (LexicalError e) {
			return e.getMessage();
		} catch (SemanticError e) {
			return e.getMessage();
		} catch (SyntaticError e) {
			return e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao compilar: " + e.getMessage();
		}
	}

	public String gerarCodigo(String texto) {
		String compilacao = this.compilar(texto);
		if (compilacao.equalsIgnoreCase(COMPILADO_COM_SUCESSO)) {
			try {
				compilarIlasm();
			} catch (BuildException e) {
				return "Erro ao compilar com o ilasm.exe: " + e.getMessage();
			} catch (Exception e) {
				e.printStackTrace();
				return "Erro ao compilar com o ilasm.exe: " + e.getMessage();
			}
		}
		return compilacao;
	}

	private void compilarIlasm() throws BuildException, Exception {
		String objFilePath = FileUtil.writeFile(this.semantico.getCodigo(),
				pathFile, fileName);
		IlasmBuilder.setPathFileBuild(pathFile);
		IlasmBuilder.buildAndExecuteAskingIlasm(objFilePath);
	}
}