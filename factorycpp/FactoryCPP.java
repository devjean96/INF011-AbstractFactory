package factorycpp;

import java.io.File;

import javax.swing.JFrame;

import factoryjava.FactoryJava;
import interfaces.IBuilder;
import interfaces.IDEFactory;

public class FactoryCPP extends IDEFactory{

	public static FactoryCPP instance = null;
	
	private FactoryCPP() {}
	
	public static FactoryCPP getInstance() {
        if (instance == null)
            instance = new FactoryCPP();
        return instance;
    }
	
	@Override
	public JFrame createJFrame(File file) {
		return new SyntaxHighligtherCPP(file);
	}

	@Override
	public IBuilder createBuider() {
		return new BuilderCPP();
	}

}
