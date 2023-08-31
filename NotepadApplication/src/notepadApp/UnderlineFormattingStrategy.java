package notepadApp;

import javax.swing.JTextArea;

public class UnderlineFormattingStrategy {
    public JTextArea formatText(JTextArea text) {
        JTextArea underlineTextArea = new JTextArea();
        underlineTextArea.setText("<b>" + text.getText() + "</b>");
        return (underlineTextArea);
    }
}
