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
public class undoOperation implements Command{

    private Receiver operation;
    
    public undoOperation(Receiver newOperation){
        
        operation = newOperation;
        
    }
    
    @Override
    public void execute() {
        getOperation().undo();
    }

    /**
     * @return the operation
     */
    public Receiver getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(Receiver operation) {
        this.operation = operation;
    }
    
}
