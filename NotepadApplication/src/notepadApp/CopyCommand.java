package notepadApp;

import javax.swing.*;


public class CopyCommand implements Command {
	private JTextArea textArea;
	
	public CopyCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.copy();
		return textArea;
		
	}

}
