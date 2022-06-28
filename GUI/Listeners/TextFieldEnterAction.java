package GUI.Listeners;

import GUI.GUI;
import System.GameManager;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class TextFieldEnterAction extends AbstractAction{
    
    private JTextField textField;
    private JTextArea textArea;
    public int gameState = 0;
    private GUI gui;
    private GameManager gameManager = new GameManager();
    
    public TextFieldEnterAction(JTextField textField,
                                JTextArea textArea,
                                GUI gui){
        this.textField = textField;
        this.textArea = textArea;
        this.gui = gui;
        
}
    
    public void mapSetUp(JTextField textField, JTextArea textArea){
        textField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        textField.getActionMap().put("enterAction", this);
        }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String currentTextFieldText = textField.getText();
        textArea.append(currentTextFieldText +"\n"); // \n forces new text to be placed on a new line
        textField.setText(" ");
        
        if(gameState == 0){
            gameManager.startHandler(gui, this);
            
        }
        System.out.println(gameState);
        
        if(gameState == 1){
            //this is the new game game state char gen and world gen go here
        }
    }
    
    
    public void gameStateSetter(int gameState){
        this.gameState = gameState;
    }
}
