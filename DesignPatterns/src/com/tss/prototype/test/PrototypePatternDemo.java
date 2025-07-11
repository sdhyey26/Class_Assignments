package com.tss.prototype.test;

import com.tss.prototype.model.*;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        try {
            Book originalBook = new Book("Design Patterns", "GoF", 395);
            Book clonedBook = (Book) originalBook.clone();
            
            

            clonedBook.setTitle("Design Patterns - Copy");

            System.out.println("Original: " + originalBook);
            System.out.println("Clone   : " + clonedBook);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
