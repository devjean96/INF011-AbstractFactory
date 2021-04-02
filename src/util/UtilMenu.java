package util;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.AppMain;
import interfaces.IDEFactory;

public class UtilMenu {
	
	private JPanel panel;
	private JFrame frame;
	
	public UtilMenu() {
		this.panel = new JPanel();
		this.frame = new JFrame();
	}
	
	public void createMenu() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Abstract Factory - INF011");
		frame.setTitle("INF011");
		label.setOpaque(true);
		label.setBackground(new Color(135, 233, 126));
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);
		panel.add(label, BorderLayout.CENTER);

		Button button = new Button("Selecionar Arquivo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile = new JFileChooser();
				jfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
				panel.add(jfile);
				int i = jfile.showSaveDialog(null);
				if (i != 1) {
					File arquivo = jfile.getSelectedFile();
					try {
						checkPluginToFile(arquivo);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		Button buttonExtension = new Button("Extensões Suportadas");
		buttonExtension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] supportedExtensions = IDEFactory.supportedExtensions();
				System.out.println(Arrays.toString(supportedExtensions));
				JOptionPane.showMessageDialog(null, "Extensões Suportadas: " + Arrays.toString(supportedExtensions));
			}
		});
		
		panel.add(button, BorderLayout.PAGE_END);
		panel.add(buttonExtension, BorderLayout.PAGE_START);
		frame.setSize(320, 200);
		frame.setLocation(1250, 400);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
	
	private static void checkPluginToFile(File file) throws Exception {
		
		String extensaoArquivo = UtilArquivo.getFileExtension(file.getName());
		String [] plugins = UtilArquivo.getAllPlugins();
		
		int i;
		URL[] jars = new URL[plugins.length];
		for (i = 0; i < plugins.length; i++) {
			jars[i] = (new File("./plugins/" + plugins[i])).toURL();
		}
		URLClassLoader ulc = new URLClassLoader(jars);
		boolean existePlugin = false;
		for (int j = 0; j < plugins.length; j++) {
			String factoryName = UtilArquivo.getFactoryName(plugins[j]);
			String namePlugin = UtilArquivo.getFactoryPlugin(plugins[j]);		
		 if(namePlugin.equals(extensaoArquivo)) { 
			 String className = factoryName.toLowerCase() + "." + factoryName;
			 IDEFactory factory = (IDEFactory) Class.forName(className, true, ulc).newInstance();
			 AppMain.createProducts(factory, file);
			 existePlugin = true;
		 }
		}
		if(!existePlugin) {
			JOptionPane.showMessageDialog(null, "Não existe plugin que suporte este arquivo");
		}
}

}
