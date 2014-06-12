package br.org.furb.compilador.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class FileUtil {
	private FileUtil() {
	}

	/**
	 * Cria e escreve em um novo arquivo ou substitui o existente.
	 * 
	 * @param texto
	 * @param pathFile
	 * @throws IOException
	 */
	public static String writeFile(String texto, String pathFile,
			String fileName) throws IOException {
		File originalFile = new File(pathFile);
		String objFilePath = originalFile.getParent() + "\\" + fileName
				+ ".obj";
		File objFile = new File(objFilePath);

		if (objFile.exists()) {
			objFile.delete();
		}
		objFile.createNewFile();

		BufferedWriter writer = new BufferedWriter(new FileWriter(objFile));
		writer.write(texto);
		writer.flush();
		writer.close();
		return objFilePath;
	}

	/**
	 * Metodo que retorna somente o nome do arquivo sem a extensão do mesmo.
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName) {
		if (fileName.contains(".")) {
			String[] path = fileName.split("\\.");
			if (path.length == 2) {
				return path[0];
			} else {
				String completePath = "";
				for (int i = 0; i < path.length - 1; i++) {
					completePath += path[i];
				}
				return completePath;
			}
		} else {
			return fileName;
		}
	}

}
