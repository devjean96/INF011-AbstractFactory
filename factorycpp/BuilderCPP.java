package factorycpp;

import java.io.File;

import interfaces.IBuilder;
import util.UtilArquivo;
import util.UtilBuilder;
import util.UtilEditor;

public class BuilderCPP implements IBuilder {

	@Override
	public void compile(File file) {

		// g++ arquivo.cpp -o arquivo -Wall
		String command = "g++ " + file.getAbsolutePath() + " -o " + UtilArquivo.getFactoryName(file.getName());
		Integer retorno = null;
		try {
			retorno = UtilBuilder.execCommand(command);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro na compila��o: " + e.getMessage());
		}
		if (retorno.equals(0)) {
			 String mensagem = "Compila��o executada com sucesso!";
			 System.out.println(mensagem);
			 UtilEditor.setTextLabel(mensagem);
		} else {
			 String mensagem = "Ocorreu uma falha ao realizar a Compila��o!";
			 System.out.println(mensagem); 
			 UtilEditor.setTextLabel(mensagem);
		}
	}

}
