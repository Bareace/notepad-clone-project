package notepadApp;

import javax.swing.*;


public class AboutCommand implements Command {
	private JTextArea textArea;
	
	public AboutCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		new About().setVisible(true);
		return textArea;
		
	}

}
