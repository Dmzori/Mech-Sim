
package System;

import java.util.ArrayList;
import javax.swing.JTextArea;


public class Commands {
    //commands and command handling code goes here
    private JTextArea textArea;
    private ArrayList<String> commandList = new ArrayList<String>();
    
    public Commands(JTextArea textArea){
        this.textArea = textArea;
        commandList.add("HELP");
        commandList.add("START");
        commandList.add("MENU");
    }
    
    public void stringHandler()//this is going to take in a string input and run a method based off that
    {
        for(String commands : commandList)
        {
            if("HELP".equals(commands))
            {
                helpHandler(textArea);
            }
        }
    
    }
    
    public void helpHandler(JTextArea textArea)
    {
        textArea.append("Here is a list of commands \n");
        for(String commands : commandList)
        {
        textArea.append(commands + " \n");
        }
    }
}
