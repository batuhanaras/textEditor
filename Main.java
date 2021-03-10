/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textEditor;

import javax.swing.JFrame;

/**
 *
 * @author batuhan
 */
public class Main {
        
    public static void main(String[] args) {
        
        TextEditorFrame frame = new TextEditorFrame();              //Yeni frame oluşturulur.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Kapatma işlemi tanımlanır.
        frame.setLocationRelativeTo(frame);                         //Frame konumlandırılır.
        frame.setVisible(true);                                     //Frame görünür yapılır.
        
    }
}
