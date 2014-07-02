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

			return "programa compilado com sucesso";
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
			e.printStackTrace();
			return "Erro ao compilar: " + e.getMessage();
		} finally {
			//			System.out.println(semantico.getCodigo());
		}
	}

	private void compilarIlasm(String codigoGerado) throws BuildException, Exception {
		String objFilePath = FileUtil.writeFile(codigoGerado, pathFile, fileName);
		IlasmBuilder.setPathFileIlasm("C:\\Windows\\Microsoft.NET\\Framework\\v4.0.30319\\ilasm.exe");
		IlasmBuilder.setPathFileBuild(pathFile);
		IlasmBuilder.buildAndExecuteAskingIlasm(objFilePath);
	}
}
