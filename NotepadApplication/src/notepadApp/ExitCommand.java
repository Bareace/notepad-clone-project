package notepadApp;

import javax.swing.JTextArea;

public class ExitCommand implements Command {

	private JTextArea textArea;
	
	public ExitCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		// TODO Auto-generated method stub
		System.exit(0);
		return textArea;
	}
	

}
