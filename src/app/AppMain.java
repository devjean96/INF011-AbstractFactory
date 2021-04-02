package app;

import java.io.File;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IDEFactory;
import util.UtilMenu;

public class AppMain {

	public static void createProducts(IDEFactory factory, File file) {

		JFrame frame = factory.createJFrame(file);
		frame.setVisible(true);
		IBuilder builder = factory.createBuider();
		builder.compile(file);
	}

	public static void main(String[] args) throws Exception {
		UtilMenu menu = new UtilMenu();
		menu.createMenu();
	}

}
