package notepadApp;

import javax.swing.*;


public class SelectAllCommand implements Command {
	private JTextArea textArea;
	
	public SelectAllCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.selectAll();
		return textArea;
		
	}

}
