package com.screening.exercise;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exercise1 {

	public static void main(String[] args) {
		
		doesFileExist("C:\\Users\\sshah\\eclipse-workspace\\BusinessInsider\\src\\File");
    }
    public static void doesFileExist(String textFile) {
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(textFile);
            System.out.println("The file exist!");
        }catch (Exception e){
            System.out.println("The file does not exist!");
        }
        try{
            br = new BufferedReader(fr);
            String data = "";
            while ((data = br.readLine())!=null){
                System.out.println(data);
            }
        }catch (Exception ex){
            System.out.println("Data does not exist!");
        }
    }
}