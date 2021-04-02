package util;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class UtilEditor{
	
	static JLabel label = new JLabel();
	
	public static void buildEditor(JFrame frame, String title, String syntaxHigligther, File file) {
		
		JPanel panel = new JPanel(new BorderLayout());

		RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(syntaxHigligther);
		RTextScrollPane textScrollPane = new RTextScrollPane(textArea);
		panel.add(textScrollPane);
		
		
		Button buttonSave = new Button("Salvar Arquivo");
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilArquivo.writeFile(file, false, textArea.getText());
				label.setText("Arquivo salvo com sucesso!");
				//panel.add(label, BorderLayout.PAGE_START);
			}
		});
		panel.add(buttonSave, BorderLayout.PAGE_END);
		panel.add(label, BorderLayout.PAGE_START);
		
		frame.setContentPane(panel);
		frame.setTitle(title);
		String texto = UtilArquivo.getFileText(file);
		textArea.setText(texto);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		
		//return null;
	}
	
	public static void setTextLabel(String text) {
		label.setText(text);
	}

}
