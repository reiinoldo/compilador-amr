package br.org.furb.compilador.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Principal extends JFrame {

	private static final long serialVersionUID = -2529644283675445941L;

	public Principal() {
		setSize(800,600);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{784, 0};
		gridBagLayout.rowHeights = new int[]{71, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JButton btnNovo = new JButton("novo");
		panel.add(btnNovo);
		
		JButton btnAbrir = new JButton("abrir");
		panel.add(btnAbrir);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		getContentPane().add(splitPane, gbc_splitPane);
		
		
		
		setVisible(true);
	}
}
