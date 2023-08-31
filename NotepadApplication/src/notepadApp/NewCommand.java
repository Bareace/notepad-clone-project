package notepadApp;

import javax.swing.*;


public class NewCommand implements Command {
	private JTextArea textArea;
	
	public NewCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.setText(null);
		return textArea;
		
	}

}
