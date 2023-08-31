package notepadApp;

import javax.swing.*;


public class InfoCommand implements Command {
	private JTextArea textArea;
	
	public InfoCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	Welcome a = new Welcome.Builder().ders("oop").okul("ege").build();

    
	@Override
	public JTextArea execute(JTextArea textArea) {
		textArea.setText(a.degis());
		return textArea;
		
	}

}
