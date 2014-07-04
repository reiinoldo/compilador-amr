package br.org.furb.compilador;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.org.furb.compilador.view.PrincipalView;

public class Main {
	public static void main(String[] args)
			throws UnsupportedLookAndFeelException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		// SETANDO CONFIGURAÇÕES NO LOOK AND FEEL
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		new PrincipalView();
	}
}