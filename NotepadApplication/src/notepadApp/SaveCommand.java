package notepadApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveCommand implements Command {
	
	private JTextArea textArea;
	
	public SaveCommand(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public JTextArea execute(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);
        //kaydetme ekrani
        int action =fileChooser.showSaveDialog(null);
        if (action != JFileChooser.APPROVE_OPTION){
            //return;
        }else{
            String fileName =fileChooser.getSelectedFile().getAbsolutePath().toString();
            if (!fileName.contains(".txt")){    //dosyanin sonuna .txt eklenmis mi onu inceliyor.
                fileName = fileName+".txt";
            }
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                textArea.write(writer);         //kaydediyoruz
            }catch (IOException ee){
                ee.printStackTrace();
            }
        }
        return textArea;
	}

}
