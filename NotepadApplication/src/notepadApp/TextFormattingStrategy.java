package notepadApp;

import javax.swing.JTextArea;

public interface TextFormattingStrategy {
    public JTextArea formatText(JTextArea text);
}