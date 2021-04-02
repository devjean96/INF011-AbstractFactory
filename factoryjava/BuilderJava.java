package factoryjava;

import java.io.File;

import interfaces.IBuilder;
import util.UtilBuilder;
import util.UtilEditor;

public class BuilderJava implements IBuilder {

	public void compile(File file) {

		String command = "javac -cp . " + file.getAbsolutePath();
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
