package notepadApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenCommand implements Command {

	private JTextArea textArea;
	
	public OpenCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);
        int action = fileChooser.showOpenDialog(null);
        if (action != JFileChooser.APPROVE_OPTION){
            //return;
        }else{
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                textArea.read(reader,null);
            }catch (IOException ee){
                ee.printStackTrace();
            }
        }
        return textArea;
	}

}
