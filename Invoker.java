/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textEditor;

/**
 *
 * @author batuhan
 */
public class Invoker {
    
    private Command theCommand;
    
    public Invoker(Command newCommand){
        theCommand = newCommand;
    }
    
    public void press(){
        getTheCommand().execute();
    }

    /**
     * @return the theCommand
     */
    public Command getTheCommand() {
        return theCommand;
    }

    /**
     * @param theCommand the theCommand to set
     */
    public void setTheCommand(Command theCommand) {
        this.theCommand = theCommand;
    }
            
}
