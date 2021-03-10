/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


/**
 *
 * @author batuhan
 */
public class TextOps { //Text Operations

    
   
    private List<String> wrongWords = new ArrayList<>();            //Yanlış kelimeleri tutacak liste.
    private List<Integer> wrongWordsIndexList = new ArrayList<>();  //Yanlış kelimelerin indexini tutacak liste.
    private List<String> dictionary = makeDictionary();             //Sözlüğü tutan liste.
    
    
    
    private List<String> makeDictionary(){                          //Lokasyondan words.txt'yi alıp, listeye dönüştürüp döndürür.
        
        
        
        File dictionaryF = new File("words.txt");                   //words.txt'yi file'a dönüştürür.
        List<String> words = new ArrayList<>();                     //Dosyadan alınacak kelimeleri tutacak liste oluşturulur.
        Scanner scannerDictionary = null;                           //Scanner oluşturur.
        try {                                                       //File'ı scan etmeyi dener.
            scannerDictionary = new Scanner(dictionaryF);
        } catch (FileNotFoundException ex) {                        //File bulunamazsa hata mesajı yollar.
            Logger.getLogger(TextOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(scannerDictionary.hasNextLine()){                     //words.txt'deki her satırı listeye ekler.
            words.add(scannerDictionary.nextLine());
        }
        scannerDictionary.close();                                  //Scanner kapatılır.

        return words;                                               //Liste döndürülür.
        
        
    }

   
 
 
    //Bir text alanında kelime araması yapar ve bulunursa kelimeyi boyar.
    public void findWord(String word, String source,Highlighter hl,Highlighter.HighlightPainter painter){   /*Aranan "word", Aranacak alan "source, 
                                                                                                              "h1" boyama toolu, "painter" renk toolu*/

             
        
        Scanner sc = new Scanner(source);                       //Aracanak alanı Scanner'a dönüştürür. 
        
        while(sc.hasNext()){                                    //Aranacak alanın her satırı için döngü oluşturulur.
 
            int index = source.indexOf(word);                   //Aranan kelimenin, text alanındaki indexi tutulur.
            
            while(index >= 0){                                  //İndex var olduğu sürece,
                
                try {          
                hl.addHighlight(index, index + word.length(), DefaultHighlighter.DefaultPainter);               /*Kelimenin başlangıç indexinden,
                                                                                                                  son indexine kadar boyama işlemi yapılır.*/
                } catch (BadLocationException ex) {     //İndexte bir şey boyanacak bir şey bulunamaması durumunda hata mesajı gönderir.
                    Logger.getLogger(TextOps.class.getName()).log(Level.SEVERE, null, ex);
                }
                    index = source.indexOf(word, index + word.length());    //Sıradaki kelimenin indexine geçiş yapılır.
                
                
            }           
            sc.nextLine();   //Text Alanındaki alt satıra geçiş yapar.    
        }
        sc.close();     //İşlemler bitince scanner'ı kapatır.
    }
    
    
    
    
    
    public void changeWord(JTextArea textArea, JTextField findField, JTextField changeField){           //Kelime değiştirme işlemi yapılır.
        
         textArea.setText(textArea.getText().replaceAll(findField.getText(), changeField.getText()));    //Aranan kelime, istenilen kelimeyle değiştirilir.
         
    }
                                                                  
    
    
    
    //Text alanındaki kelimelerin sözlükte olup olmadığını kontrol eder ve sözlükte yoksa boyama işlemi gerçekleştirir.
    public void checkErrors(String source,Highlighter hl,Highlighter.HighlightPainter painter,JTextField statusField, JButton fixButton){  /*"source" = Text Alanı,
                                                                                                                                             "hl" = HighLighter toolu,
                                                                                                                                             "painter" = renk toolu,
                                                                                                                                             "statusField" = Status Field,
                                                                                                                                             "fixButton" = fixButton */
   
        
        setWrongWords(new ArrayList<>());                               //Yanlış kelime listesini sıfırlar.
        setWrongWordsIndexList(new ArrayList<>());                      //Yanlış kelime index listesini sıfırlar.
        Scanner scTextArea = new Scanner(source) ;                      //Text Alanı için scanner oluşturur.
        int index = 0;                                                  //Text Alanı indexini sıfırlar.
        
            while(scTextArea.hasNext()){                                //Her Text Alanı satırı için,
                
                String[] words = scTextArea.nextLine().split("\\W");    //"words" listesi bir satırdaki kelimeleri karakterlerden ayırarak içine atar.
                
                
                
                for ( String word : words) {                                    //Karakterlerden ayrılmış kelime listesindeki her kelimeyi gezer.
                    
                    int dCount = 0;                                             //Sözlükte kaçıncı satırda olduğunu tutan sayıdır.                          
                    index = source.indexOf(word,index);                         //For içinde gezen kelimenin indexini alır.
                    String wordLower = word.toLowerCase();                      //Kelimeyi sözlükte karşılaştırabilmek için küçük harfli hale dönüştürür.
                    
                    if(getWrongWords().contains(word)==false){                  /*Bir yanlış kelime, daha önce aranmış mı diye kontrol edilir. 
                                                                                 Daha önce aranmışsa verimlilik için bir daha arama yapılmaz, kelime yanlış kabul edilir.*/
                        
                        while(getDictionary().size()!=dCount){                  //"dCount", sözlükteki kelime sayısına ulaşıncaya kadar döngü devam ettirilir.
                            
                            if(wordLower.equals(getDictionary().get(dCount)) || wordLower.matches(".*\\d.*")){  /*Eğer kelimeye sözlüğün bir satırında rastlanırsa veya
                                                                                                                kelimede sayıya rastlanırsa, doğru kabul edilir.*/
                            dCount = -1;                                        //Kelimenin bulunduğunu gösterir.                            
                            break;                                              //Döngüyü bitirir.
                            }

                        dCount++;                                               //Sözlük listesinde sırayla arama yapılmasını sağlayan index.
                        }                        
                    }                    
                    
                    if(dCount!=-1 && word.equals("")==false && word.equals(word.toUpperCase())==false){     /*Eğer bir kelime bulunamamışsa, o kelime boş bir string değil ise,
                                                                                                            ve tamamı büyük harflerden oluşan özel bir isim değil ise,
                                                                                                            kelime yanlış kabul edilir*/
                        getWrongWords().add(word);          //Yanlış kelimeyi listeye ekler.                  
                                            
                        try {
                            hl.addHighlight(index, index + word.length(), painter);     //O kelimeyi boyar.
                        } catch (BadLocationException ex) {                             //İndex bulunamazsa hata mesajı gönderilir.
                            Logger.getLogger(TextOps.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                    getWrongWordsIndexList().add(index);                //Bu listenin çift sayılı indexleri, kelime başlangıç indexlerini tutar.
                                    getWrongWordsIndexList().add(index+word.length());  //Bu listenin tek sayılı indexleri, kelime bitiş indexlerini tutar.
                                                                                        /*Örnek: word = "animal"
                                                                                          getWrongWordsIndexList().get(0) = 0 //Baş harfinin indexi.
                                                                                          getWrongWordsIndexList().get(1) = 5 //Son harfinin indexi.*/           
                    }
                }                                             
            }
        statusField.setText("Errors have been list. Found : "+getWrongWords().size());    //Status Field'ı gerekli bilgiyle doldurur.
        
        if(getWrongWords().isEmpty()){                                                  //Yanlış kelime yoksa, fixButton kullanıma açılmaz.
            fixButton.setEnabled(false);
        }
        else{                                                                           //Yanlış kelime varsa, fixButton kullanıma açılır.
            fixButton.setEnabled(true);                     
        }
    }
    
    
    
    //Hatalı kelimeler içerisinde, "single transposition" arayan, bulursa düzelten metod.
    public void fixErrors(JTextArea textArea,String source, List<Integer> wrongIndexList, List<String> wrongWords,JTextField statusField){ 
                                                                                                                        /*"textArea" = textArea,    
                                                                                                                          "source" = textArea.getText(),
                                                                                                                          "wrongIndexList" = yanlış kelimelerin index listesi,
                                                                                                                          "statusField" = statusField.*/
        int sizeWrongWords = wrongWords.size();         //Toplam yanlış kelime sayısını tutar.
        int lengthOfWord;                               //Bir kelimenin uzunluğunu tutar.
        char[] chars = source.toCharArray();            //Text Alanındaki yazıyı karakter listesine dönüştürür.
        int anyFixed = 0;                               //Bulunan "single transposition" sayısını tutar.
        
        for(int i = 0;i<sizeWrongWords;i++){            //Yanlış kelime sayısı kadar döngü yapılır.
            
            lengthOfWord = getWrongWordsIndexList().get((i*2)+1)-getWrongWordsIndexList().get(i*2); /*Bir kelime uzunluğu hesaplanır. Bitiş indexinden başlangıç indexi
                                                                                                      çıkarılarak bulunur.
                                                                                                      Örnek: 3. kelime => i = 3; kelime = "animal";
                                                                                                      getWrongWordsIndexList().get((i*2)+1)-getWrongWordsIndexList().get(i*2)       
                                                                                                      =>
                                                                                                      getWrongWordsIndexList().get(7)-getWrongWordsIndexList().get(6);
                                                                                                      (Bu listenin algoritması yukarıda açıklanmıştır.)*/
           
            if(lengthOfWord > 2){                                           //Sözlükte iki harfli kelimeler bulunmadığı için, bu kelimeler işleme sokulmaz.
               
               for(int j = 0;j<lengthOfWord-1;j++){                         /*Single transposition algoritması başlar.
                                                                              Çalışma şekli => kelime = "animla" doğru hali = "animal";
                                                                              j=1 => "naimla"; j=2 => "ainmla"; j=3 => "anmila"; j=4 => "anilma" j=5 => "animal" */
                                      
                    String letter1 = wrongWords.get(i).substring(j, j+1);   //Kelimenin yanyana olan iki harften soldaki harfin indexini alır.   
                    String letter2;                                         //Kelimenin yanyana olan iki harften sağdaki harfin indexini alır.
                    
                    if(j+2!=lengthOfWord){                                  
                        letter2 = wrongWords.get(i).substring(j+1, j+2);    //Sağdaki harf, kelimenin son harfi değilse bu işlem yapılır.
                    }
                    else{
                        letter2 = wrongWords.get(i).substring(j+1);         //Sağdaki harf, kelimenin son harfi ise bu işlem yapılır.
                    }
                    
                    StringBuilder newVersionOfWord = new StringBuilder(wrongWords.get(i));  //Geçici bir stringe, işlem yapılan kelime atılır.
                    newVersionOfWord.setCharAt(j,letter2.toLowerCase().charAt(0));          //Soldaki harf yerine, sağdaki harf konur.
                    newVersionOfWord.setCharAt(j+1,letter1.toLowerCase().charAt(0));        //Sağdaki harf yerine, soldaki harf konur.

                    int dCount = 0;                                                         //Sözlük aramasını sağlayacak olan index.
                    while(getDictionary().size()!=dCount){                                  //"dCount", sözlükteki kelime sayısına ulaşıncaya kadar döngü devam ettirilir.
                        
                         if(newVersionOfWord.toString().toLowerCase().equals(getDictionary().get(dCount))){ /*Harf değişimi işlemi yapılan geçici kelime sözlükte
                                                                                                              bulunuyor mu diye kontrol edilir.                            
                                                                                                              Yeni kelime versiyonu sözlükte bulunursa aşağıdaki
                                                                                                              işlemler yapılır.*/
                             
                            char[] tempCharList;                                        //Geçici karakter listesi oluşturulur.
                            dCount = -1;                                                //Kelime bulunduğu için index "-1" yapılır.
                            tempCharList = newVersionOfWord.toString().toCharArray();   //Geçici kelime, karakter listesine dönüştürülür.
                            
                            for(int k = 0;k<lengthOfWord;k++){                          //Düzeltilmiş kelimenin, Text Alanına koyma işlemi yapılır.  
                                
                                char ch = tempCharList[k];                              //Kelimenin bir karakteri alınır.
                                chars[getWrongWordsIndexList().get(i*2)+k] = ch;        /*Eski kelimenin "başlangıç indexi+k" indexine yeni kelimenin "k" indexindeki
                                                                                          karakteri alınır.*/
                            }
                            
                            StringBuilder sb = new StringBuilder();                     //Yeni bir stringBuilder oluşturur. 

                            for (Character ch : chars) {                                /*Düzeltilmiş yeni karakter listesinin her karakteri bu döngüyle,
                                                                                          stringBuilder'a atılır.*/
                               sb.append(ch); 
                            }  
        
                            textArea.setText(sb.toString());                        /*Düzeltilmiş karakter listesi, stringBuilder ardından String'e çevirilerek,
                                                                                          Text Alanına gönderilir.*/
                            anyFixed++;                                             //Düzeltilen kelime sayısı 1 artırılır.
                            break;                                                  //Döngüden çıkılır.
                         }
                         dCount++;                                                  //Sözlükte kelime bulunamazsa, index 1 artırılır.
                    }
                }             
            }
            if(anyFixed==0){
                statusField.setText("Could not found any single transposition.");   //Transposition bulunamazsa, statusField bu şekilde set edilir.
            }
            else{
                statusField.setText("Single transpositions are fixed.");            //Transposition bulunursa, statusField bu şekilde set edilir.
            }
        }
    }

    
    //Getterlar ve Setterlar aşağıda listelenmiştir.
    
    /**
     * @return the wrongWordsIndexList
     */
    public List<Integer> getWrongWordsIndexList() {
        return wrongWordsIndexList;
    }

    /**
     * @param wrongWordsIndexList the wrongWordsIndexList to set
     */
    public void setWrongWordsIndexList(List<Integer> wrongWordsIndexList) {
        this.wrongWordsIndexList = wrongWordsIndexList;
    }

    /**
     * @return the wrongWords
     */
    public List<String> getWrongWords() {
        return wrongWords;
    }

    /**
     * @param wrongWords the wrongWords to set
     */
    public void setWrongWords(List<String> wrongWords) {
        this.wrongWords = wrongWords;
    }

    /**
     * @return the dictionary
     */
    public List<String> getDictionary() {
        return dictionary;
    }

    /**
     * @param dictionary the dictionary to set
     */
    public void setDictionary(List<String> dictionary) {
        this.dictionary = dictionary;
    }
    
    
}
