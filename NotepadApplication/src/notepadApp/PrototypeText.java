package notepadApp;


import javax.swing.JTextArea;

//creating a prototype class
public class PrototypeText implements Prototype {
	private JTextArea textArea;
	
	public PrototypeText(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JTextArea getText() {
		return textArea;	
	}


	public void setText(String text) {
		textArea.setText(text);
	}
	@Override
	public Prototype copy() {
		return new PrototypeText(textArea);
	}
	

}