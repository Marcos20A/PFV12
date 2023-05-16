package com.perfecciondigital.tallerprimefaces.controller.viewcontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class pruebaProperties {

    private Properties prop;

    public pruebaProperties() {
        prop = new Properties();
        try {
            File file = new File("javaprueba.properties");
            FileInputStream fileInput = new FileInputStream(file);
            prop.load(fileInput);
            fileInput.close();
        } catch (IOException ex) {
            
        }
        
    }
    	
    public void calcular() {
        Scanner scanner = new Scanner(System.in);
        
        int intNum1 = 0;
        int intNum2 = 0;

        String strNum1 = prop.getProperty("intNum1");
        if (strNum1 != null) {
            intNum1 = Integer.parseInt(strNum1);
        }

        String strNum2 = prop.getProperty("intNum2");
        if (strNum2 != null) {
            intNum2 = Integer.parseInt(strNum2);
        }
        
        System.out.print("Ingrese el signo de operación (+, -, *, /): ");
        String operacion = scanner.nextLine();
        
        switch (operacion) {
            case "+":
                System.out.println(intNum1 + " + " + intNum2 + " = " + (intNum1 + intNum2));
                break;
            case "-":
                System.out.println(intNum1 + " - " + intNum2 + " = " + (intNum1 - intNum2));
                break;
            case "*":
                System.out.println(intNum1 + " * " + intNum2 + " = " + (intNum1 * intNum2));
                break;
            case "/":
                System.out.println(intNum1 + " / " + intNum2 + " = " + ((double) intNum1 / intNum2));
                break;
            default:
                System.out.println("Signo de operación no válido.");
        }
    }
    
    public static void main(String[] args) {
    	File file = new File("javaprueba.properties");
    	System.out.println(file.getAbsolutePath());
    }
    
    
}