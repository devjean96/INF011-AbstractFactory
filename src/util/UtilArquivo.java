package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilArquivo {

	public static String getFileExtension(String filename) {
		if (filename.contains("."))
			return filename.substring(filename.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static String[] getAllPlugins() {
		File currentDir = new File("./plugins");
		String[] plugins = currentDir.list();

		return plugins;
	}
	
	public static String getFactoryPlugin(String filename) {
		String factoryPlugin = getFactoryName(filename).split("Factory")[1];
		return factoryPlugin.toLowerCase();
	}
	
	public static String getFactoryName(String filename) {
		return  filename.split("\\.")[0];
	}

	public static String getFileText(File file) {
		StringBuilder text = new StringBuilder();
		try (FileReader in = new FileReader(file); BufferedReader buff = new BufferedReader(in, 1024)) {
			String s = null;
			while ((s = buff.readLine()) != null) {
				text.append(s).append("\n");
			}
			// System.out.println("Conteudo do arquivo:\n\n"+texto);
		} catch (IOException iox) {
			System.out.println("Falha ao ler arquivo: " + iox.getMessage());
		}
		return text.toString();
	}
	
	public static void writeFile(File file, boolean append, String text) {
		try {
			FileWriter fileWriter = new FileWriter(file, append);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(text);
			printWriter.flush();
			printWriter.close();
			System.out.println("Arquivo Salvo com Sucesso!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
