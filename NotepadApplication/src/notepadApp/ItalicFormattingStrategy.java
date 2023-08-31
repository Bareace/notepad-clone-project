package notepadApp;

import javax.swing.JTextArea;



public class ItalicFormattingStrategy {
    private JTextArea textArea;
    
    public ItalicFormattingStrategy(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JTextArea formatText(JTextArea text) {
        //JTextArea italicTextArea = new JTextArea();
        text.setText("<html>"+"<i>" + text.getText().toString() + "</i>"+"</html>");
        return (text);
    }

    public String getText(){
        return textArea.getText();
    }
}
