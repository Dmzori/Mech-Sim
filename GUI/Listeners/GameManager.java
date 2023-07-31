package GUI.Listeners;

import GUI.GUI;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    public String primaryStat;
    public String secondaryStat;
    public String charName;
    private int numClicks;
    
    
    
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
    public void actionPerformed(ActionEvent e) {//this is the game, gamestate is like on menu, in game, substate is what menu what game
        String currentTextFieldText = textField.getText();//maybe I return some sort of key from handlers 
        textArea.append(currentTextFieldText +"\n"); // \n forces new text to be placed on a new line
        textField.setText("");
        numClicks++;
        
        System.out.println(gameState);
        
        do{
        startHandler(gui, this);// we running start handler
        }while (gameState == 0 && subState == 0);//1 click
            
            
        
    }
    
    
    public void gameStateSetter(int gameState){
        this.gameState = gameState;
    }
    
    public void startHandler(GUI gui, GameManager action){
        //needs to check if the user has typed start then append the next required text for char creation or w/e to the text area and finally change the game state to the w/e int im going to use for whats next this probably doesnt need to return anything
        if("S".equals(gui.getTextAreaLastLine()) ||
           "s".equals(gui.getTextAreaLastLine()) || 
           " S".equals(gui.getTextAreaLastLine()) ||
           " s".equals(gui.getTextAreaLastLine())){
           action.subState++;
           gui.getTextArea().append("Type N for new game or L to load a save\n");//n will be the new game game state on 1 so mabye I can check for N here and then change gamestate to 1 then check for L and change the game state to whatever the save states game state is but I might have to do it from the text field enter action
           }
           else
           {
               gui.getTextArea().append("thats the wrong shit retard\n");
           }
        }
    
    public void newGameHandler(GUI gui, GameManager action){
        //GameCharacter gameCharacter;//maybe I return gamecharacter and just pass it down the method line
        //this will be where new game stuff is checked I should probably do char, world gen etc in a different class then just call the methods here
        if("N".equals(gui.getTextAreaLastLine()) ||
           " N".equals(gui.getTextAreaLastLine())){
            gui.getTextArea().append("first enter your character's name\n");//this is the start of character creation what I need to ask a player is there name, primary stat, secondary stat
            
        }
        if(gameState >= 3){
            charName = gui.getTextAreaLastLine();
            gui.getTextArea().append("Your characters name is " + charName +"\n");
            gameState = 2;
        }
        
    }
    
}
