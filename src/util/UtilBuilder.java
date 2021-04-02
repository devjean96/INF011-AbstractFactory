package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class UtilBuilder {

	public static Integer execCommand(String command) throws Exception {
		
		System.out.println(command);
		Process process = Runtime.getRuntime().exec(command);
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		StringBuilder lineOut = new StringBuilder();
		String s;
		while ((s = input.readLine()) != null) {
		   lineOut.append(s);
		}
		//input.flush();                
		input.close();
		if (process.waitFor() != 0) {
			System.out.println(lineOut);
			JOptionPane.showMessageDialog(null, lineOut);
		}
		return process.waitFor();
		
		//return process.exitValue();
	}

}
