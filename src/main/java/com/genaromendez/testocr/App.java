package com.genaromendez.testocr;

import java.io.File;
import net.sourceforge.tess4j.*;

public class App {

    public static void main(String[] args) {
        File imageFile = new File("prueba1.jpg");

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

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
