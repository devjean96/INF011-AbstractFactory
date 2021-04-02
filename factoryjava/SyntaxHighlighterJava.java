package factoryjava;

import java.io.File;

import javax.swing.JFrame;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import util.UtilEditor;

public class SyntaxHighlighterJava extends JFrame {

	public SyntaxHighlighterJava(File file) {
		UtilEditor.buildEditor(this, "Text Editor Java", SyntaxConstants.SYNTAX_STYLE_JAVA, file);
	}

}
