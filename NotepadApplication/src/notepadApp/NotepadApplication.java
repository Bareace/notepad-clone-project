package notepadApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Stack;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadApplication extends JFrame implements ActionListener {
    UndoManager undoManager = new UndoManager();
    //menu bar
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    JMenu textFormat = new JMenu("Text Format");

    // "file" inner menu
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem exit = new JMenuItem("Exit");

    // "edit" inner menu
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    JMenuItem info = new JMenuItem("Info");
    JMenuItem undo = new JMenuItem("Undo");

    // "help" inner menu
    JMenuItem about = new JMenuItem("About");

    // "textFormat" inner menu
    JMenuItem italic = new JMenuItem("Italic");
    JMenuItem bold = new JMenuItem("Bold");
    JMenuItem underline = new JMenuItem("Underline");


    //textArea
    public JTextArea textArea = new JTextArea();

    



    NotepadApplication(){
        setTitle("Notepadd Application");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add(menubar);
        setJMenuBar(menubar);

        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        menubar.add(textFormat);


        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        edit.add(undo);
        

        help.add(info);
        help.add(about);

        textFormat.add(italic);
        textFormat.add(bold);
        textFormat.add(underline);
        

        //search bar
        /*JTextField search = new JTextField();
        search.setBounds(0, 0, 100, 30);
        add(search);*/

        // scroll pane
        JScrollPane scrollpane = new JScrollPane(textArea);
        add(scrollpane);

        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollpane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Adding Listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
        info.addActionListener(this);
        italic.addActionListener(this);
        bold.addActionListener(this);
        underline.addActionListener(this);
        //undo.addActionListener(this);


    }


    public static void main(String[] args) throws Exception {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApplication().setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* 
        PrototypeText prototypeText = new PrototypeText(textArea);
        prototypeText.setText(textArea.getText());
        System.out.println(prototypeText.getText());
        undoManager.setText(prototypeText);
        */
        

    	e.getActionCommand().equalsIgnoreCase("New");
    	if(e.getActionCommand().equalsIgnoreCase("New")) {
            Command newCommand = new NewCommand(textArea);
            textArea = newCommand.execute(textArea);

        }
        else if(e.getActionCommand().equalsIgnoreCase("Open")) {
        	
        	Command openCommand = new OpenCommand(textArea);
        	textArea = openCommand.execute(textArea);
        	
            /*JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showOpenDialog(null);
            if (action != JFileChooser.APPROVE_OPTION){
                return;
            }else{
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(reader,null);
                }catch (IOException ee){
                    ee.printStackTrace();
                }
            }*/


        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")) {
        	
        	Command saveCommand = new SaveCommand(textArea);
        	textArea = saveCommand.execute(textArea);
                /*JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter textFilter = new FileNameExtensionFilter("sadece txt olabilir","txt");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(textFilter);
                //kaydetme ekrani
                int action =fileChooser.showSaveDialog(null);
                if (action != JFileChooser.APPROVE_OPTION){
                    return;
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
                }*/
        }
        else if(e.getActionCommand().equalsIgnoreCase("Exit")) {
            
        	Command exitCommand = new ExitCommand(textArea);
        	textArea = exitCommand.execute(textArea);
        	//System.exit(0);
        }
        else if(e.getActionCommand().equalsIgnoreCase("Cut")) {
        	Command cutCommand = new CutCommand(textArea);
        	textArea = cutCommand.execute(textArea);
            //textArea.cut();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Copy")) {
        	Command copyCommand = new CopyCommand(textArea);
        	textArea = copyCommand.execute(textArea);
            //textArea.copy();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Paste")) {
        	Command pasteCommand = new PasteCommand(textArea);
        	textArea = pasteCommand.execute(textArea);
            //textArea.paste();
        }
        else if(e.getActionCommand().equalsIgnoreCase("Select All")) {
        	Command selectAllCommand = new SelectAllCommand(textArea);
        	textArea = selectAllCommand.execute(textArea);
            //textArea.selectAll();
        }
        /*
        else if(e.getActionCommand().equalsIgnoreCase("Undo")) {
            System.out.println("undo");
            //PrototypeText prototypeText = new PrototypeText(textArea);
            
            textArea = undoManager.undo(prototypeText);
           

        }
        */
        else if(e.getActionCommand().equalsIgnoreCase("About")) {// bir tane a��lmas� laz�m
        	Command aboutCommand = new AboutCommand(textArea);
        	textArea = aboutCommand.execute(textArea);
            //new About().setVisible(true);
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Info")) {
        	Command infoCommand = new InfoCommand(textArea);
        	textArea = infoCommand.execute(textArea);
            //Welcome a = new Welcome.Builder().ders("oop").okul("ege").build();

            //textArea.setText(a.degis());
        }
        else if(e.getActionCommand().equalsIgnoreCase("Italic")){
            /*Command italiCommand = new ItalicCommand(textArea);
            textArea = italiCommand.execute(textArea);*/

            ItalicFormattingStrategy italicText = new ItalicFormattingStrategy(textArea);
            textArea = italicText.formatText(textArea);
            System.out.println("italic");


        }/*else if(e.getActionCommand().equalsIgnoreCase("Bold")){
            Command boldCommand = new BoldCommand(textArea);
            textArea = boldCommand.execute(textArea);

        }else if(e.getActionCommand().equalsIgnoreCase("Underline")){
            Command underlineCommand = new UnderlineCommand(textArea);
            textArea = underlineCommand.execute(textArea);
        }*/

    }
    
	
}