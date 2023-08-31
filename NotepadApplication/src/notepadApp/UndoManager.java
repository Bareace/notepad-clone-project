package notepadApp;

import java.util.Stack;

import javax.swing.JTextArea;
import org.w3c.dom.Text;

//creating a stack class for undo
public class UndoManager {
    private Stack<PrototypeText> undoStack = new Stack<PrototypeText>();
    private PrototypeText textArea;
    public  void PrototypeText(PrototypeText text) {
        this.undoStack = new Stack<>();
        this.textArea = text;
    }
    public void setText (PrototypeText text) {
        this.undoStack.push((notepadApp.PrototypeText) text.copy());
        this.textArea = text;
    }
    public JTextArea undo(PrototypeText text) {
        if (!undoStack.isEmpty()) {
            this.textArea = undoStack.pop();
            
        }
        return textArea.getText();
    }

}



