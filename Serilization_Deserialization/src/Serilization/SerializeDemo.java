package Serilization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.tss.model.SerilizationTest;

public class SerializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SerilizationTest student = new SerilizationTest( 1,  "john");
		 try {
	            FileOutputStream fileOut = new FileOutputStream("student.ser");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(student);
	            out.close();
	            fileOut.close();
	            System.out.println("Object has been serialized to student.ser");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
