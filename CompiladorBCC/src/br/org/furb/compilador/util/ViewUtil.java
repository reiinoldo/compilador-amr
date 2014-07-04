package br.org.furb.compilador.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import br.org.furb.compilador.model.analisador.Constants;

public class ViewUtil {
	private static final String ESPECIAL_WORDS = getSpecialWords();
	public static final Font LINE_NUMBER_FONT = new Font("Consolas",
			Font.PLAIN, 12);

	private static int findLastNonWordChar(String text, int index) {
		while (--index >= 0) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
		}
		return index;
	}

	private static int findFirstNonWordChar(String text, int index) {
		while (index < text.length()) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
			index++;
		}
		return index;
	}

	public static DefaultStyledDocument getDefaultStypeDocument() {
		final SimpleAttributeSet specialWordsStyle = new SimpleAttributeSet();
		StyleConstants.setFontFamily(specialWordsStyle, "Consolas");
		StyleConstants.setFontSize(specialWordsStyle, 12);
		StyleConstants.setBold(specialWordsStyle, true);
		StyleConstants.setForeground(specialWordsStyle, new Color(127, 0, 85));

		final SimpleAttributeSet normalWordsStyle = new SimpleAttributeSet();
		StyleConstants.setFontFamily(normalWordsStyle, "Consolas");
		StyleConstants.setFontSize(normalWordsStyle, 12);
		StyleConstants.setBold(normalWordsStyle, false);
		StyleConstants.setForeground(normalWordsStyle, new Color(0, 0, 0));

		return new DefaultStyledDocument() {
			private static final long serialVersionUID = 1L;

			public void insertString(int offset, String str, AttributeSet a)
					throws BadLocationException {
				super.insertString(offset, str, a);

				String text = getText(0, getLength());
				int before = findLastNonWordChar(text, offset);
				if (before < 0)
					before = 0;
				int after = findFirstNonWordChar(text, offset + str.length());
				int wordL = before;
				int wordR = before;

				while (wordR <= after) {
					if (wordR == after
							|| String.valueOf(text.charAt(wordR))
									.matches("\\W")) {

						if (text.toUpperCase().substring(wordL, wordR)
								.matches("(\\W)*(" + ESPECIAL_WORDS + ")"))
							setCharacterAttributes(wordL, wordR - wordL,
									specialWordsStyle, false);
						else
							setCharacterAttributes(wordL, wordR - wordL,
									normalWordsStyle, false);
						wordL = wordR;
					}
					wordR++;
				}
			}

			public void remove(int offs, int len) throws BadLocationException {
				super.remove(offs, len);

				String text = getText(0, getLength());
				int before = findLastNonWordChar(text, offs);
				if (before < 0)
					before = 0;
				int after = findFirstNonWordChar(text, offs);

				if (text.toUpperCase().substring(before, after)
						.matches("(\\W)*(" + ESPECIAL_WORDS + ")"))
					setCharacterAttributes(before, after - before,
							specialWordsStyle, false);
				else
					setCharacterAttributes(before, after - before,
							normalWordsStyle, false);
			}
		};
	}

	private static String getSpecialWords() {
		StringBuilder strBuilder = new StringBuilder();
		for (String special : Constants.SPECIAL_CASES_KEYS) {
			strBuilder.append(special + "|");
		}
		return strBuilder.replace(strBuilder.length() - 1, strBuilder.length(),
				"").toString();
	}
}
