/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program1_ooad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aishwariyatalathi
 */
public class Program1_OOAD implements Runnable{
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    private String fname;
    private String fnumber;
    
    public Program1_OOAD(String fname,String fnumber) {
        this.fname=fname;
        this.fnumber=fnumber;
    }
    

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       String file1="/Users/aishwariyatalathi/Desktop/OOAD/Assignment1/AllFiles/file1.txt";
       String file2="/Users/aishwariyatalathi/Desktop/OOAD/Assignment1/AllFiles/file2.txt";
       String file3="/Users/aishwariyatalathi/Desktop/OOAD/Assignment1/AllFiles/file3.txt";
       String file4="/Users/aishwariyatalathi/Desktop/OOAD/Assignment1/AllFiles/file4.txt";
       Thread t1= new Thread(new Program1_OOAD(file1,"File 1"));
       t1.start();
       Thread t2= new Thread(new Program1_OOAD(file2,"File 2"));
       t2.start();
       Thread t3= new Thread(new Program1_OOAD(file3,"File 3"));
       t3.start();
       Thread t4= new Thread(new Program1_OOAD(file4,"File 4"));
       t4.start();
       //int count1 = file_word_count(file1);
       System.out.println("\nDone in Main");
    }   

    @Override
    public void run() {
        int word_count = 0;
        FileReader filereader;        
        try {
            filereader = new FileReader (fname);
            BufferedReader bufferedreader = new BufferedReader (filereader);    
            System.out.println("\nProcessing File "+fnumber);
            String s = bufferedreader.readLine();
            while (s!=null) {
            String []section=s.split(" ");
            for( String word:section)
                 word_count++;        
            s = bufferedreader.readLine();
       }
        System.out.print("\n"+fnumber+" :: "+word_count);
        } catch (FileNotFoundException ex) {
            System.out.println("file "+fnumber+" Not Found");
        } catch (IOException ex) {
            Logger.getLogger(Program1_OOAD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
