package System;

import GUI.GUI;


public class GameManager {
    public int gameState;//depending on the game state this will fire certain text, look for specific responses and then run game code and change game state as required
    private GUI gui;
    
    
    public GameManager(GUI gui){
    gameState = 0;
    this.gui = gui;
    if(gameState == 0){
        
    }
    
    
    
    
    
    
    }
    
    private String startHandler(){
        //needs to check if the user has typed start then append the next required text for char creation or w/e to the text area and finally change the game state to the w/e int im going to use for whats next
        return "";
    }
}
