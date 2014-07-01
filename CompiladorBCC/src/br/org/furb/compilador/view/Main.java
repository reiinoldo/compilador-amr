package br.org.furb.compilador.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//SETANDO CONFIGURAÇÕES NO LOOK AND FEEL
//		System.setProperty("Quaqua.tabLayoutPolicy","wrap");
//		UIManager.put("Panel.opaque", Boolean.TRUE);
//		UIManager.put("Quaqua.Component.cellRendererFor", Boolean.TRUE);
//		UIManager.put("Component.visualMargin", new Insets(2,2,2,2));
//		//SETANDO O LOOK AND FEEL
//		UIManager.setLookAndFeel(QuaquaManager.getLookAndFeel());
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame.setDefaultLookAndFeelDecorated(true);
		new PrincipalView();
	}
}