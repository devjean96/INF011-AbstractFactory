package factorycpp;

import java.io.File;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IDEFactory;

public class FactoryCPP extends IDEFactory{

	@Override
	public JFrame createJFrame(File file) {
		return new SyntaxHighligtherCPP(file);
	}

	@Override
	public IBuilder createBuider() {
		return new BuilderCPP();
	}

}
