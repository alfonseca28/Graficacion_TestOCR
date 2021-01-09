/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genaromendez.testocr;

import java.io.File;
import net.sourceforge.tess4j.*;

public class App {

    public static void main(String[] args) {
        File imageFile = new File("imagen.png");
       
        System.out.println(imageFile.getAbsolutePath());
        
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        //ITesseract instance = new Tesseract1(); // JNA Direct Mapping
       
        instance.setLanguage("eng");
        instance.setPageSegMode(1);
        instance.setOcrEngineMode(1);
        instance.setDatapath("./tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
