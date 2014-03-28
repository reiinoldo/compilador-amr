package br.org.furb.compilador.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class Principal extends JFrame {

	// decvar
	private static final long serialVersionUID = -2529644283675445941L;
	private JPanel panelStatus;
	private JLabel lblStatus;
	private JTextArea textAreaCodigo, textAreaMensagens;
	private JButton btnNovo, btnAbrir, btnSalvar, btnCopiar, btnColar,
			btnRecortar, btnCompilar, btnGerarCodigo, btnEquipe;
	private String oldTextAreaCodigo;
	private String pathFile;

	private void btnNovoEvt() {
		pathFile = null;
		textAreaMensagens.setText("");
		textAreaCodigo.setText("");
		lblStatus.setText("Não modificado");
	}

	private void btnAbrirEvt() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System
				.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			setTitle("Selected file: " + selectedFile.getAbsolutePath());
			lblStatus.setText("Selected file: "
					+ selectedFile.getAbsolutePath());
			pathFile = selectedFile.getAbsolutePath();

			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(
						selectedFile.toString()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					textAreaCodigo.setText(textAreaCodigo.getText() + line
							+ "\n");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		lblStatus.setText("Não modificado");
	}

	private void setStatusBar() {
		if (!textAreaCodigo.getText().equals(oldTextAreaCodigo)) {
			lblStatus.setText("Modificado");
		} else {
			lblStatus.setText("Não modificado");
		}
		oldTextAreaCodigo = textAreaCodigo.getText();
	}

	private void btnCompilarEvt() {
		textAreaMensagens
				.setText("Compilação de programas ainda não foi implementada");
	}

	private void btnGerarCodigoEvt() {
		textAreaMensagens
				.setText("Geração de código ainda não foi implementada");
	}

	private void btnEquipeEvt() {
		textAreaMensagens.setText("André Vinícius Bampi \n"
				+ "Maicon Machado Gerardi da Silva \n"
				+ "Reinoldo Krause Junior");
	}

	private void btnCopiarEvt() {
		if (textAreaCodigo.getSelectedText() != null) {
			StringSelection selection = new StringSelection(textAreaCodigo
					.getSelectedText().toString());
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(selection, selection);
		}
	}

	private void btnColarEvt() {
		String str = getClipboardContents();
		textAreaCodigo.setText(textAreaCodigo.getText().toString() + "" + str);
	}

	private void btnRecortarEvt() {
		btnCopiarEvt();
		textAreaCodigo.replaceSelection("");
	}

	private void btnSalvarEvt() {
		if (pathFile != null) {
			try {
				gravarNoArquivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
			lblStatus.setText("Não modificado");
		} else {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System
					.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				setTitle("Selected file: " + selectedFile.getAbsolutePath());
				lblStatus.setText("Selected file: "
						+ selectedFile.getAbsolutePath());
				pathFile = selectedFile.getAbsolutePath();

				try {
					gravarNoArquivo();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void gravarNoArquivo() throws IOException {
		FileWriter fw = new FileWriter(pathFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(textAreaCodigo.getText().toString());
		bw.close();
		fw.close();
		lblStatus.setText("Não modificado");
	}

	public String getClipboardContents() {
		String result = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText = (contents != null)
				&& contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				result = (String) contents
						.getTransferData(DataFlavor.stringFlavor);
			} catch (Exception ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return result;
	}

	public Principal() {
		@SuppressWarnings("unused")
		JPanel panelPrincipal = new JPanel();
		panelStatus = new JPanel();
		lblStatus = new JLabel("Não Modificado");

		panelStatus.add(lblStatus);
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

		btnNovo = new JButton();
		btnNovo.setFont(fontButtonsHeader);
		btnNovo.setText(String.format(valorPadraoTexto, "novo.png",
				"novo [ctrl-n]"));
		btnNovo.setPreferredSize(new Dimension(80, 75));

		btnAbrir = new JButton();
		btnAbrir.setFont(fontButtonsHeader);
		btnAbrir.setText(String.format(valorPadraoTexto, "open.png",
				"abrir [ctrl-a]"));
		btnAbrir.setPreferredSize(new Dimension(80, 75));

		btnSalvar = new JButton();
		btnSalvar.setFont(fontButtonsHeader);
		btnSalvar.setText(String.format(valorPadraoTexto, "save.png",
				"salvar [ctrl-s]"));
		btnSalvar.setPreferredSize(new Dimension(80, 75));

		btnCopiar = new JButton();
		btnCopiar.setFont(fontButtonsHeader);
		btnCopiar.setText(String.format(valorPadraoTexto, "copy.png",
				"copiar [ctrl-c]"));
		btnCopiar.setPreferredSize(new Dimension(80, 75));

		btnColar = new JButton();
		btnColar.setFont(fontButtonsHeader);
		btnColar.setText(String.format(valorPadraoTexto, "paste.png",
				"colar [ctrl-v]"));
		btnColar.setPreferredSize(new Dimension(80, 75));

		btnRecortar = new JButton();
		btnRecortar.setFont(fontButtonsHeader);
		btnRecortar.setText(String.format(valorPadraoTexto, "cut.png",
				"recortar [ctrl-r]"));
		btnRecortar.setPreferredSize(new Dimension(80, 75));

		btnCompilar = new JButton();
		btnCompilar.setFont(fontButtonsHeader);
		btnCompilar.setText(String.format(valorPadraoTexto, "play.png",
				"compilar [F8]"));
		btnCompilar.setPreferredSize(new Dimension(80, 75));

		btnGerarCodigo = new JButton();
		btnGerarCodigo.setFont(fontButtonsHeader);
		btnGerarCodigo.setText(String.format(valorPadraoTexto, "make.png",
				"gerar código [F9]"));
		btnGerarCodigo.setPreferredSize(new Dimension(80, 75));

		btnEquipe = new JButton();
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
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane.setLeftComponent(scrollPane);

		textAreaCodigo = new JTextArea();
		textAreaCodigo.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				setStatusBar();
			}
		});
		textAreaCodigo.setText("");

		final JTextArea lines = new JTextArea("01");

		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);
		// TODO
		textAreaCodigo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent event) {
				if (event.isControlDown()) {
					// CTRL + n
					if (event.getKeyCode() == KeyEvent.VK_N) {
						btnNovoEvt();
					}
					// CTRL + A
					if (event.getKeyCode() == KeyEvent.VK_A) {
						btnAbrirEvt();
					}
					// CTRL + S
					if (event.getKeyCode() == KeyEvent.VK_S) {
						btnSalvarEvt();
					}
					// CTRL + C
					if (event.getKeyCode() == KeyEvent.VK_C) {
						btnCopiarEvt();
					}
					// CTRL + V
					if (event.getKeyCode() == KeyEvent.VK_V) {
						btnColarEvt();
					}
					// CTRL + R
					if (event.getKeyCode() == KeyEvent.VK_R) {
						btnRecortarEvt();
					}

				}
				// F8
//				if (event.getKeyCode() == KeyEvent.VK_F8) {
//					System.out.println("compilar1");
//				}

				// F9
				if (event.getKeyCode() == KeyEvent.VK_F9) {
					btnGerarCodigoEvt();
				}
				// F1
				if (event.getKeyCode() == KeyEvent.VK_F1) {
					btnEquipeEvt();
				}
			}

			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_F8) {
					btnCompilarEvt();
				}
			}
		});

		textAreaCodigo.getDocument().addDocumentListener(
				listnerLineNumbers(textAreaCodigo, lines));

		scrollPane.setViewportView(textAreaCodigo);
		scrollPane.setRowHeaderView(lines);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPane_1);

		splitPane.setDividerLocation(370);
		splitPane.setResizeWeight(1);
		textAreaMensagens = new JTextArea();
		textAreaMensagens.setMinimumSize(new Dimension(4, 5));
		textAreaMensagens.setEditable(false);
		scrollPane_1.setViewportView(textAreaMensagens);

		GridBagConstraints gbc_panelStatus = new GridBagConstraints();
		gbc_panelStatus.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panelStatus.gridx = 0;
		gbc_panelStatus.gridy = 2;
		getContentPane().add(panelStatus, gbc_panelStatus);
		panelStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 2));

		setVisible(true);

		// Ação do botão Novo
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNovoEvt();
			}
		});

		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAbrirEvt();
			}
		});

		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCompilarEvt();
			}
		});

		btnGerarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGerarCodigoEvt();
			}
		});

		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEquipeEvt();
			}
		});

		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCopiarEvt();
			}
		});

		btnColar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnColarEvt();
			}
		});

		btnRecortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecortarEvt();
			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSalvarEvt();
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
