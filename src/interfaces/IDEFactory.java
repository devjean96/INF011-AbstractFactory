package interfaces;

import java.io.File;

import javax.swing.JFrame;

import util.UtilArquivo;

public abstract class IDEFactory {

	public abstract JFrame createJFrame(File file);
	public abstract IBuilder createBuider();

	public static String[] supportedExtensions() {
		String[] plugins = UtilArquivo.getAllPlugins();
		String[] extensions = new String[plugins.length];

		
		for (int i = 0; i < plugins.length; i++) {
			extensions[i] = "." + UtilArquivo.getFactoryPlugin(plugins[i]);
		}

		return extensions;
	}

}
