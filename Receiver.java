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
public class Receiver {
    
    private String Text = "";
    
    
    public String undo(){                               
        
        return getText().length() == 0 ? "" : getText().substring(0,getText().length()-1);     /*Text alanı boş ise boş string,
                                                                                  dolu ise bir harf eksiğini döndürür.*/
    }   

    /**
     * @return the Text
     */
    public String getText() {
        return Text;
    }

    /**
     * @param Text the Text to set
     */
    public void setText(String Text) {
        this.Text = Text;
    }
}
