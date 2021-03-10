/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author batuhan
 */
public class FileOps {
    
    private String fileName = "";   //Kullanıcıdan gelecek dosya ismini tutar.
    
    
    
    
    
    
    public void createFile() {                          //Yeni dosya oluşturma işlemi yapar.
        File file = new File(getFileName()+".txt");     //Kullanıcıdan gelen veriyle bir dosya tanımlar.
        try {
            file.createNewFile();                       //Dosyayı oluşturmaya çalıştır.
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);      //IOException durumunda hata mesajı yollar.
        }
    }
    
    
    
    
    public void saveFile(String text) throws IOException {      //Dosya kaydetme işlemi yapar.
        FileWriter myWriter = null;                             //Text Alanından veri alacak bir FileWriter oluşturulur.
        try {
            if(getFileName().equals("")){
                setFileName("newfile");                         //Dosya ismi "newfile.txt" olur.
                myWriter = new FileWriter(getFileName()+".txt");       //Dosya ismi kullanıcı tarafından verilmemişse, default bir dosya oluşturur.
               
            }
            else{
                myWriter = new FileWriter(getFileName()+".txt");    //Dosya ismi verilmişse, o dosya ismi ile bir dosya oluşturulur.
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);  //Dosya oluşturulamazsa verilecek hata mesajı.
        }
        try {
            myWriter.write(text);
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);  //Dosyaya veri yazdırılamazsa verilecek hata mesajı.
        }
        try {
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);  //Dosya kapatılamazsa verilecek hata mesajı.
        }       
    }
    
    
    
    public void loadFile(JFileChooser fileChooser, int chooserValue, JTextArea textArea, JTextField statusField){   //Dosya yükleme işlemi yapar.
        
        if(chooserValue == JFileChooser.APPROVE_OPTION){                            //Seçim yapıldıysa aşağıdaki işlemlere geçer.
            
            try {
                Scanner fileRead = new Scanner(fileChooser.getSelectedFile());      //Scanner ile konumdaki dosya okunur.

                String buffer = "";                                                 //"buffer" stringi oluşturulur.
                while(fileRead.hasNext()){                                          //Dosyanın içindeki her satır için döngü oluşturulur.
                    
                    buffer += fileRead.nextLine() + "\n";                           //Dosyadaki her satır "buffer" a eklenir.
                    
                }   
                textArea.setText(buffer);                                           //Dosya tamamen okunduktan sonra, tüm içerik text Alanına yazdırılır.

                statusField.setText("Loaded from: " + fileChooser.getSelectedFile().getAbsolutePath());     //Status alanına bilgi metni gönderir.
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);              //Dosya bulunamazsa hata mesajı gönderir.                                
            }
            
        }
        
    }
    
    
    
   public void saveAs(JFileChooser chooser, int chooserValue, JTextArea textArea, JTextField statusField){
       
       if (chooserValue == JFileChooser.APPROVE_OPTION){                                            //Seçim yapıldıysa aşağıdaki işlemlere geçer.
            
            try {
                PrintWriter fileSaved = new PrintWriter(chooser.getSelectedFile());                 //Seçilen konumda dosya oluşturur.
                fileSaved.print(textArea.getText());                                                //Seçilen konumdaki dosyaya metni yazdırır.
                fileSaved.close();                                                                  //Dosya işlemi sonlandırılır.
                statusField.setText("Saved at: " + chooser.getSelectedFile().getAbsolutePath());    //Status alanına bilgi metni gönderir.
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);      //Dosya bulunamazsa hata mesajı gönderir.
            }
            
        }
   }
    

    //Getterlar ve Setterlar aşağıdaki gibi listelenmiştir.
    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    

    
    
    
    
   
    
}
