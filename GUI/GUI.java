package GUI;

import GUI.Listeners.TextFieldEnterAction;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {
    private final JFrame mainFrame;//the main frame that holds everything
    private final JPanel mainPanel;//the panel that sits on the frame and holds everything else
    private final JTextField textField; //this will be where user text is entered
    private final JTextArea textArea;//this will be where old text is appended and responses are lsited
    private final JScrollPane scrollPane;//scroll pane for the text area
    private final GridBagLayout gridBagLayout;//the layout thats applied to the panel
    private final GridBagConstraints textFieldConstraint;//the size constraint to be used for the gridbaglayout
    private final GridBagConstraints textAreaConstraint;
    private final Dimension minSize;//the min size of the frame
    private final TextFieldEnterAction  textAction;
    private final SmartScroller smartScroller;
    
    public GUI()
    {
        //instantiating stuff
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        textField = new JTextField(10);//instantiatiing with width
        textArea = new JTextArea("Type S to start \n", 10, 40);// instantiating with width x height
        minSize = new Dimension(640,480);
        scrollPane = new JScrollPane(textArea);//adds the scroll pane to the text area
        gridBagLayout = new GridBagLayout();
        textFieldConstraint = new GridBagConstraints();//each component should have its own constraint size when added to it's panel unless you want them to act the same at all times 
        textAreaConstraint = new GridBagConstraints();
        textAction = new TextFieldEnterAction(textField, textArea, this);
        smartScroller = new SmartScroller(scrollPane, SmartScroller.VERTICAL, SmartScroller.END);

        
        //scrollpane stuff
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

 
        //textField gridBagConstraint stuff
        textFieldConstraint.weightx = 1;
        textFieldConstraint.weighty = 1;
        textFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        textFieldConstraint.gridx = 0;
        textFieldConstraint.gridy = 0;
        //textFieldConstraint.anchor = GridBagConstraints.FIRST_LINE_START;
        textFieldConstraint.gridwidth = GridBagConstraints.REMAINDER;
        textFieldConstraint.insets = new Insets(10, 10, 10, 10);
        
        //textArea gridBagConstraint stuff
        textAreaConstraint.gridx = 0;
        textAreaConstraint.gridy = 1;
        textAreaConstraint.ipady = 40;
        textAreaConstraint.weightx = 1;
        textAreaConstraint.weighty = 1;
        textAreaConstraint.fill = GridBagConstraints.BOTH;
        textAreaConstraint.gridwidth = GridBagConstraints.REMAINDER;
        textAreaConstraint.gridwidth = 5;
        
        //textField stuff
        textField.setEditable(true);
        textField.setFocusable(true);
        textAction.mapSetUp(textField, textArea);
        
        //textArea stuff
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.requestFocusInWindow();
        textArea.setBackground(Color.lightGray);
        
        
        
        
        //panel stuff
        mainPanel.setLayout(gridBagLayout);
        mainPanel.add(scrollPane, textAreaConstraint);//this holds the text area so the constraints are added here
        mainPanel.add(textField, textFieldConstraint);
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        //frame stuff
        mainFrame.add(mainPanel);
        //mainFrame.setMinimumSize(minSize);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.getContentPane().setBackground(Color.GRAY);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Mech Sim");
        
    }
    
    public String getTextAreaLastLine(){
        String text = textArea.getText();
        String[] lines = text.split("\n");
        String lastLine = lines[lines.length-1];
        System.out.println(lastLine);
        return lastLine;
        
    }
    
    public JTextArea getTextArea(){
        return textArea;
    }
    
}
