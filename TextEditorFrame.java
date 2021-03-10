/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textEditor;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author batuhan
 */
public class TextEditorFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;    //TextEditorFrame için seri numarası oluşturulur

    private FileOps fileOps = new FileOps();    //FileOps nesnesi oluşturur.
    private TextOps textOps = new TextOps();    //TextOps nesnesi oluşturur.
    private Receiver receiver = new Receiver();

    
    /**
     * Creates new form TextEditorFrame
     */
    public TextEditorFrame() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        findButton = new javax.swing.JButton();
        findField = new javax.swing.JTextField();
        changeButton = new javax.swing.JButton();
        changeField = new javax.swing.JTextField();
        undoButton = new javax.swing.JButton();
        statusField = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        fixButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        saveAsButton.setText("Save As");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        statusField.setEditable(false);
        statusField.setText("Welcome to the Text Editor!");
        statusField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        fixButton.setText("Fix");
        fixButton.setEnabled(false);
        fixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton)
                            .addComponent(saveAsButton)
                            .addComponent(loadButton)
                            .addComponent(quitButton)
                            .addComponent(newButton)
                            .addComponent(undoButton)
                            .addComponent(checkButton)
                            .addComponent(fixButton))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusField, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusField)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(findButton)
                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton)
                        .addGap(35, 35, 35)
                        .addComponent(checkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(undoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(quitButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed

        getFileOps().setFileName(JOptionPane.showInputDialog(this,"Enter file name: "));    //"New" butonuna tıklandığında yaratılacak dosya için isim ister.
        
        getFileOps().createFile();                                                       //Dosyayı oluşturur.
        
        statusField.setText("New file is created.");                                        //Status alanına bilgi metni gönderir.
               
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        String text = textArea.getText();                                                   //Text Alanındaki metni bir stringe atar.
        
        try {
            getFileOps().saveFile(text);                                                    //Text Alanındaki metni default dosya konumuna kaydeder.
        } catch (IOException ex) {
            Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);  //IOException durumunda hata mesajı yollar.
        }
        statusField.setText("File is saved over "+getFileOps().getFileName()+".txt");       //Status alanına bilgi metni gönderir.
              
    }//GEN-LAST:event_saveButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed

        JFileChooser chooser = new JFileChooser();                                          //Bilgisayarda konum seçebilmek için FileChooser oluşturur.
        int chooserValue = chooser.showSaveDialog(this);                                    //Seçim değerini tutar.
        fileOps.saveAs(chooser, chooserValue, textArea, statusField);                       //Seçilen konuma dosyayı farklı kaydeder.
        
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed

        JFileChooser chooser = new JFileChooser();                              //Bilgisayarda konum seçebilmek için FileChooser oluşturulur.
        int chooserValue = chooser.showOpenDialog(this);                        //Seçim değerini tutar.
        fileOps.loadFile(chooser, chooserValue, textArea, statusField);         //Bir konumdan seçilen dosyayı yükler.

    }//GEN-LAST:event_loadButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed

        statusField.setText("Quitting...");     //Status alanına bilgi metni gönderir.
        System.exit(0);                         //Frame kapatılır.
        
    }//GEN-LAST:event_quitButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
     
        if(findField.getText().equals("")){
            statusField.setText("Need a word for this operation.");     //Find Field boş ise status alanına bilgi metni gönderilir.
        }
        else{                                                           //Find Fieldda bir kelime var ise aşağıdaki işlemler yapılır.
            
            String word = findField.getText();                          //Find Fielddaki kelime alınır.
            String source = textArea.getText();                         //Text Alanındaki metin alınır.
            
            Highlighter highlighter = textArea.getHighlighter();        //Boyama işlemi için Highlighter oluşturulur.
            HighlightPainter painter =                                  //Boyama rengi seçilir.
            new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
            highlighter.removeAllHighlights();                          //Eski boyama işlemleri temizlenir.
            
            getTextOps().findWord(word, source,highlighter,painter);    //Metinde istenen kelime aranır.
            
            statusField.setText("Search results listed.");              //Status alanına bilgi metni gönderilir.
            
        }
        
    }//GEN-LAST:event_findButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed

        if(findField.getText().equals("") && changeField.getText().equals("")){ 
            statusField.setText("There is nothing to be changed.");                                         //Aranan kelime yoksa, status alanına bilgi metni gönderilir.
        }
        else{
            
            textOps.changeWord(textArea, findField, changeField);                                           //Aranan kelimeyi, istenen kelimeyle değiştirme işlemi yapılır.
            
            statusField.setText("Words are changed.");                                                      //Status alanına bilgi metni gönderilir.              
        }
        
    }//GEN-LAST:event_changeButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed

        if(textArea.getText().equals("")){
            statusField.setText("Page is empty, can not remove anything.");     //Sayfa boş ise silme işlemi olamayacağından, status alanına bilgi metni gönderilir.
        }
        else{
            
            undoOperation onCommand = new undoOperation(getReceiver());
            
            Invoker onPressed = new Invoker(onCommand);
            
            onPressed.press();
            
            getReceiver().setText(textArea.getText());
            
            textArea.setText(getReceiver().undo());    //Text Alanından bir karakter geri alınır.
            statusField.setText("A letter removed.");
        }
        
    }//GEN-LAST:event_undoButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        
        Highlighter highlighter = textArea.getHighlighter();                            //Boyama işlemi için HighLighter oluşturulur.
        HighlightPainter painter =                                                      //Boyama rengi seçilir.
        new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        highlighter.removeAllHighlights();                                              //Eski boyama işlemleri silinir.
        
        getTextOps().checkErrors(textArea.getText(),highlighter,painter,statusField,fixButton);   //Hatalı kelimeler aranır.
        
       
    }//GEN-LAST:event_checkButtonActionPerformed

    private void fixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixButtonActionPerformed

        Highlighter highlighter = textArea.getHighlighter();    //Boyama işlemleri için HighLighter oluşturulur.
        highlighter.removeAllHighlights();                      //Eski boyama işlemlerini siler.
        
        //"Single transposition" olan kelimeleri düzeltir.
        getTextOps().fixErrors(textArea,textArea.getText(),getTextOps().getWrongWordsIndexList(), getTextOps().getWrongWords(),statusField);
        fixButton.setEnabled(false);    //"Fix" butonunun aktifliği sonlanır.
        
    }//GEN-LAST:event_fixButtonActionPerformed

    private void textAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseClicked

        Highlighter highlighter = textArea.getHighlighter();    //Boyama işlemleri için HighLighter oluşturulur.
        highlighter.removeAllHighlights();                      //Text Alanına tıklandığında boyama işlemlerini siler.
        
    }//GEN-LAST:event_textAreaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TextEditorFrame().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private javax.swing.JTextField changeField;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField findField;
    private javax.swing.JButton fixButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField statusField;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables

    
    //Getterlar ve Setterlar aşağıda listelenmiştir.
    
    /**
     * @return the fileOps
     */
    public FileOps getFileOps() {
        return fileOps;
    }

    /**
     * @param fileOps the fileOps to set
     */
    public void setFileOps(FileOps fileOps) {
        this.fileOps = fileOps;
    }

    /**
     * @return the textOps
     */
    public TextOps getTextOps() {
        return textOps;
    }

    /**
     * @param textOps the textOps to set
     */
    public void setTextOps(TextOps textOps) {
        this.textOps = textOps;
    }

    /**
     * @return the receiver
     */
    public Receiver getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}