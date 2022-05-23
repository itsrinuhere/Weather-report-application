package com.application;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;
import javax.swing.*;
public class App{
    private JDialog dialog;
    private  JFrame frame ;  
    JLabel label,city,temperature ;
    private void Dialog(Exception exe){
        JFrame frame= new JFrame();  
        dialog =  new JDialog(frame,"Exception");
        dialog.add(new JLabel(exe.getMessage()));
        dialog.setSize(120,120);
        dialog.setVisible(true);
    }
    private boolean label(String text){
    label = new JLabel(text,JLabel.CENTER );
    
       // label.setText(text);
       label.setSize(350,100);
       label.setBounds(80, 120, 240, 40);
       label.setFont(new Font("SansSerif", Font.PLAIN, 10));
       frame.add(label);
    return true;
    }
    private void UI(){
   frame= new JFrame("weather Report API app"); 
    frame.setLayout(null); 
    frame.setSize(740,480);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(new Color(123, 250, 200));
    label("hi");

    }
    private void run() throws MalformedURLException,IOException{
    //api part and integrate to ui and dialog 
   final String APIKEY = "IktJNIrNBIARC7gwEmkrCBm2GvtBTz09";
    URL url = new URL("");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    int responsecode = connection.getResponseCode();
    if(responsecode !=200){
        throw new RuntimeErrorException(null, "HTTP RESONCE CODE"+responsecode);
    }else{
        StringBuilder informationofString = new StringBuilder();
        Scanner scanner = new Scanner(URL.openStream());
        while(scanner.hasNext()){
            informationofString.append(scanner.nextLine());
        }
        scanner.close();
    }
    UI();
    }
    public static void main(String[] args){
        try{
            //exception handling to maintain the stability of application
            new App().run();
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }
}