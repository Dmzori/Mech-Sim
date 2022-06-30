package GUI.Listeners;

import GUI.GUI;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class GameManager extends AbstractAction{
    
    private JTextField textField;
    private JTextArea textArea;
    public int gameState = 0;//this will be used for changing main scenes such as going from game start to character creation
    private int subState = 0;//this will be used for sub scenes such as going from the first part of character creation to the second
    private GUI gui;
    
    
    public GameManager(JTextField textField,
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
            startHandler(gui, this);
            
        }
        System.out.println(gameState);
        
        if(gameState == 1){
            newGameHandler(gui, this);
            subState = 1;//I need to find a way to check this is my newGameHandler to change what text is fired if that doesnt work I can just do a different gamestate for each line of text
        }
    }
    
    
    public void gameStateSetter(int gameState){
        this.gameState = gameState;
    }
    
    public void startHandler(GUI gui, GameManager action){
        //needs to check if the user has typed start then append the next required text for char creation or w/e to the text area and finally change the game state to the w/e int im going to use for whats next this probably doesnt need to return anything
        if("S".equals(gui.getTextAreaLastLine()) ||
           "s".equals(gui.getTextAreaLastLine()) || 
           " S".equals(gui.getTextAreaLastLine()) ||
           " s".equals(gui.getTextAreaLastLine())){//for some reason a space is getting added before the next S after the action code is fired
            action.gameState = 1;
            gui.getTextArea().append("Type N for new game or L to load a save\n");//n will be the new game game state on 1 so mabye I can check for N here and then change gamestate to 1 then check for L and change the game state to whatever the save states game state is but I might have to do it from the text field enter action
            }
            else
            {
                gui.getTextArea().append("thats the wrong shit retard\n");
            }
        }
    
    public void newGameHandler(GUI gui, GameManager action){
        //this will be where new game stuff is checked I should probably do char, world gen etc in a different class then just call the methods here
        if("N".equals(gui.getTextAreaLastLine()) ||
           " N".equals(gui.getTextAreaLastLine())){
            gui.getTextArea().append("");//this is the start of character creation what I need to ask a player is there name, primary stat, secondary stat
        }
    }
    
    
}
