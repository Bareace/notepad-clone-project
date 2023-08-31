package notepadApp;

import javax.swing.JTextArea;

public class BoldFormattingStrategy {
    public JTextArea formatText(JTextArea text) {
        JTextArea boldTextArea = new JTextArea();
        boldTextArea.setText("<b>" + text.getText() + "</b>");
        return (boldTextArea);
    }
}
