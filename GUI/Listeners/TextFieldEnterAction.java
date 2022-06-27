package GUI.Listeners;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class TextFieldEnterAction extends AbstractAction{
    
    private JTextField textField;
    private JTextArea textArea;
    
    public TextFieldEnterAction(JTextField textField,
                                JTextArea textArea){
        this.textField = textField;
        this.textArea = textArea;
}
    
    public void mapSetUp(JTextField textField, JTextArea textArea){
        textField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        textField.getActionMap().put("enterAction", this);
        }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String currentTextFieldText = textField.getText();
        textArea.append(currentTextFieldText + "\n"); // \n forces new text to be placed on a new line
        textField.setText(" ");
    }
    
}
