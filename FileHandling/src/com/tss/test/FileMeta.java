package com.tss.test;

import java.io.File;

public class FileMeta {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\dhyey.shiyal\\Desktop\\tss\\assignments\\ExceptionHandling"); 

        if(folder.isFile()) {
        	System.out.println(folder.getName());
        }
        else {
        	listFiles(folder);     	
        }
        
    }

    public static void listFiles(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("File: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName());
                    listFiles(f); 
                }
            }
        }
    }
}
