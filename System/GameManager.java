package System;

import GUI.GUI;
import GUI.Listeners.TextFieldEnterAction;


public class GameManager {

    
    public GameManager(){
    
    }

    
    public void startHandler(GUI gui, TextFieldEnterAction action){
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
    
    public void newGameHandler(GUI gui, TextFieldEnterAction action){
        //this will be where new game stuff is checked I should probably do char, world gen etc in a different class then just call the methods here
    }
    
    
}
