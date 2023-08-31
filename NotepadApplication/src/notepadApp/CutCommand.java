package notepadApp;

import javax.swing.*;


public class CutCommand implements Command {
	private JTextArea textArea;
	
	public CutCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.cut();
		return textArea;
		
	}

}
