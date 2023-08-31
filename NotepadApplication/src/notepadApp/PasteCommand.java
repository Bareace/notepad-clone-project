package notepadApp;

import javax.swing.*;


public class PasteCommand implements Command {
	private JTextArea textArea;
	
	public PasteCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.paste();
		return textArea;
		
	}

}
