package factoryjava;

import java.io.File;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IDEFactory;

public class FactoryJava extends IDEFactory{
	
	public static FactoryJava instance = null;
	
	private FactoryJava() {}
	
	public static FactoryJava getInstance() {
        if (instance == null)
            instance = new FactoryJava();
        return instance;
    }
	
	@Override
	public JFrame createJFrame(File file) {
		return new SyntaxHighlighterJava(file);
	}
	
	@Override
	public IBuilder createBuider() {
		return new  BuilderJava();
	}
	
	

}
