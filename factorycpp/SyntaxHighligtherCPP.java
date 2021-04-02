package factorycpp;

import java.io.File;

import javax.swing.JFrame;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import util.UtilEditor;

public class SyntaxHighligtherCPP extends JFrame{
	
	public SyntaxHighligtherCPP(File file) {
		UtilEditor.buildEditor(this, "Text Editor C++", SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS, file);
	}

}
