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

//import br.org.furb.compilador.util.StringUtil;

public class CompiladorController {
	private String fileName;
	private String pathFile;

	public CompiladorController(String fileName, String pathFile) {
		this.fileName = fileName;
		this.pathFile = pathFile;
	}

	public String compilar(String texto) {
		Lexico lexico = new Lexico();
		lexico.setInput(texto);
		Sintatico sintatico = new Sintatico();
		Semantico semantico = new Semantico(fileName);

		try {
			sintatico.parse(lexico, semantico);

			compilarIlasm(semantico.getCodigo());

			return "programa compilado com sucesso";
		} catch (LexicalError e) {
			return e.getMessage();
		} catch (SemanticError e) {
			return e.getMessage();
		} catch (SyntaticError e) {
			return e.getMessage();
		} catch (BuildException e) {
			return "Erro ao compilar com o ilasm.exe: " + e.getMessage();
		} catch (Exception e) {
			return "Erro ao compilar: " + e.getMessage();
		}
	}

	private void compilarIlasm(String codigoGerado) throws BuildException,
			Exception {
		System.out.println(codigoGerado);
		String objFilePath = FileUtil.writeFile(codigoGerado, pathFile,
				fileName);
		IlasmBuilder
				.setPathFileIlasm("C:\\Windows\\Microsoft.NET\\Framework\\v4.0.30319\\ilasm.exe");
		IlasmBuilder.setPathFileBuild(pathFile);
		IlasmBuilder.buildAndExecuteAskingIlasm(objFilePath);
	}

	// public String compilar(String texto) {
	// String result;
	//
	// if (texto.isEmpty() || texto.trim().equals("")) {
	// result = "Nenhum programa para compilar!";
	// } else {
	//
	// result = analisadorLexico(texto);
	//
	// // ** Caso não apresente erros ("") faz a análise sintática ** //
	// if (result.equals(""))
	// result = analisadorSintatico(texto);
	//
	// }
	//
	// if (result.equals(""))
	// result = "     programa compilado com sucesso";
	//
	// return result;
	// }
	//
	//
	//
	// private String analisadorLexico(String texto) {
	// Lexico lexico = new Lexico();
	// String msgToken = "";
	// Token token = null;
	//
	// lexico.setInput(texto);
	//
	// try {
	// /*
	// * ** Especificação do trabalho 3 ** Não deve ser mostrado as
	// * mensagens do léxico ** Apenas será mostrado caso cotenha erro
	// *
	// * msgToken = StringUtil.completaASC("linha", " ", 8) +
	// * StringUtil.completaASC("classe", " ", 22) + "lexema\n";
	// */
	//
	// while ((token = lexico.nextToken()) != null) {
	// msgToken = msgToken + token.toString() + "\n";
	// }
	//
	// // return msgToken + "\n" + "     programa compilado com sucesso";
	// return "";
	//
	// } catch (LexicalError e) {
	// return e.getMessage();
	// }
	// }
	//
	// private String analisadorSintatico(String texto) {
	// Semantico semantico = new Semantico(fileName);
	// Sintatico sintatico = new Sintatico();
	// Lexico lexico = new Lexico();
	// lexico.setInput(texto);
	//
	// try {
	//
	// sintatico.parse(lexico, semantico);
	//
	// return "";
	//
	// } catch (LexicalError e) {
	// return e.getMessage();
	// } catch (SemanticError e) {
	// return e.getMessage();
	// } catch (SyntaticError e) {
	// return e.getMessage();
	// }
	// }

}
