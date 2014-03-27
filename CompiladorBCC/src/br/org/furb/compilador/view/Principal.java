package br.org.furb.compilador.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class Principal extends JFrame {

	private static final long serialVersionUID = -2529644283675445941L;

	public Principal() {

		JPanel panelPrincipal = new JPanel();
		setSize(800, 600);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 784, };
		gridBagLayout.rowHeights = new int[] { 71, 467, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		
		getContentPane().add(panel, gbc_panel);

		String valorPadraoTexto = "<html><div style=\"text-align:center\"><br /><img src="
				+ "file:img/%s" + "/><br />%s<br /></div></html>";

		Font fontButtonsHeader = new Font("Arial", 1, 10);

		JButton btnNovo = new JButton();

		btnNovo.setFont(fontButtonsHeader);
		btnNovo.setText(String.format(valorPadraoTexto, "novo.png",
				"novo [ctrl-n]"));
		btnNovo.setPreferredSize(new Dimension(80, 75));

		JButton btnAbrir = new JButton();
		btnAbrir.setFont(fontButtonsHeader);
		btnAbrir.setText(String.format(valorPadraoTexto, "open.png",
				"abrir [ctrl-a]"));
		btnAbrir.setPreferredSize(new Dimension(80, 75));

		JButton btnSalvar = new JButton();
		btnSalvar.setFont(fontButtonsHeader);
		btnSalvar.setText(String.format(valorPadraoTexto, "save.png",
				"salvar [ctrl-s]"));
		btnSalvar.setPreferredSize(new Dimension(80, 75));

		JButton btnCopiar = new JButton();
		btnCopiar.setFont(fontButtonsHeader);
		btnCopiar.setText(String.format(valorPadraoTexto, "copy.png",
				"copiar [ctrl-c]"));
		btnCopiar.setPreferredSize(new Dimension(80, 75));

		JButton btnColar = new JButton();
		btnColar.setFont(fontButtonsHeader);
		btnColar.setText(String.format(valorPadraoTexto, "paste.png",
				"colar [ctrl-v]"));
		btnColar.setPreferredSize(new Dimension(80, 75));

		JButton btnRecortar = new JButton();
		btnRecortar.setFont(fontButtonsHeader);
		btnRecortar.setText(String.format(valorPadraoTexto, "cut.png",
				"recortar [ctrl-r]"));
		btnRecortar.setPreferredSize(new Dimension(80, 75));

		JButton btnCompilar = new JButton();
		btnCompilar.setFont(fontButtonsHeader);
		btnCompilar.setText(String.format(valorPadraoTexto, "play.png",
				"compilar [F8]"));
		btnCompilar.setPreferredSize(new Dimension(80, 75));

		JButton btnGerarCodigo = new JButton();
		btnGerarCodigo.setFont(fontButtonsHeader);
		btnGerarCodigo.setText(String.format(valorPadraoTexto, "make.png",
				"gerar c�digo [F9]"));
		btnGerarCodigo.setPreferredSize(new Dimension(80, 75));

		JButton btnEquipe = new JButton();
		btnEquipe.setFont(fontButtonsHeader);
		btnEquipe.setText(String.format(valorPadraoTexto, "people.png",
				"equipe [F1]"));
		btnEquipe.setPreferredSize(new Dimension(80, 75));

		panel.add(btnNovo);
		panel.add(btnAbrir);
		panel.add(btnSalvar);
		panel.add(btnCopiar);
		panel.add(btnColar);
		panel.add(btnRecortar);
		panel.add(btnCompilar);
		panel.add(btnGerarCodigo);
		panel.add(btnEquipe);

		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		getContentPane().add(splitPane, gbc_splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);

		final JTextArea textAreaCodigo = new JTextArea();

		final JTextArea lines = new JTextArea("01");

		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);
//TODO
		textAreaCodigo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent event) {
				if (event.isControlDown()) {
					// CTRL + n
					if (event.getKeyCode() == KeyEvent.VK_N) {

						System.out.println("novo");
					}
					// CTRL + A
					if (event.getKeyCode() == KeyEvent.VK_A) {

						JOptionPane.showMessageDialog(null,"a");
					}
					// CTRL + S
					if (event.getKeyCode() == KeyEvent.VK_S) {

						System.out.println("salvar");
					}
					// CTRL + C
					if (event.getKeyCode() == KeyEvent.VK_C) {

						System.out.println("copiar");
					}
					// CTRL + V
					if (event.getKeyCode() == KeyEvent.VK_V) {

						System.out.println("colar");
					}
					// CTRL + R
					if (event.getKeyCode() == KeyEvent.VK_R) {

						System.out.println("recortar");
					}

				}
				// F8
				if (event.getKeyCode() == KeyEvent.VK_F8) {

					System.out.println("compilar");
				}
				// F9
				if (event.getKeyCode() == KeyEvent.VK_F9) {

					System.out.println("gerar codigo");
				}
				// F1
				if (event.getKeyCode() == KeyEvent.VK_F1) {

					System.out.println("equipe");
				}
			}

			@Override
			public void keyPressed(KeyEvent evt) {

			}
		});

		textAreaCodigo.getDocument().addDocumentListener(
				listnerLineNumbers(textAreaCodigo, lines));

		scrollPane.setViewportView(textAreaCodigo);
		scrollPane.setRowHeaderView(lines);
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		splitPane.setDividerLocation(370);
		splitPane.setResizeWeight(1);
		final JTextArea textAreaMensagens = new JTextArea();
		textAreaMensagens.setMinimumSize(new Dimension(4, 5));
		textAreaMensagens.setEditable(false);
		scrollPane_1.setViewportView(textAreaMensagens);

		JPanel panelStatus = new JPanel();
		GridBagConstraints gbc_panelStatus = new GridBagConstraints();
		gbc_panelStatus.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panelStatus.gridx = 0;
		gbc_panelStatus.gridy = 2;
		getContentPane().add(panelStatus, gbc_panelStatus);
		panelStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 2));

		final JLabel lblStatus = new JLabel("New label");
		panelStatus.add(lblStatus);

		setVisible(true);

		// A��o do bot�o Novo
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaMensagens.setText("");
				textAreaCodigo.setText("");
				lblStatus.setText(" ");
			}
		});
	}

	/**
	 * @author Maiconzera
	 * @param jta
	 * @param lines
	 * @return
	 */
	private DocumentListener listnerLineNumbers(final JTextArea jta,
			final JTextArea lines) {
		return new DocumentListener() {
			public String getText() {
				int caretPosition = jta.getDocument().getLength();
				Element root = jta.getDocument().getDefaultRootElement();
				String text = "01" + System.getProperty("line.separator");
				for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
					String value = "" + i;

					if (i < 10) {
						value = "0" + i;
					}

					text += value + System.getProperty("line.separator");

				}
				return text;
			}

			@Override
			public void changedUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

			@Override
			public void insertUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

			@Override
			public void removeUpdate(DocumentEvent de) {
				lines.setText(getText());
			}

		};

	}

}
