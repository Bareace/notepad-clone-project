package notepadApp;

import javax.swing.JTextArea;

public interface Command {
	public JTextArea execute(JTextArea textArea);
}
