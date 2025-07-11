package Deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.tss.model.SerilizationTest;

public class DeserlizationTest {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerilizationTest student = (SerilizationTest) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Object has been deserialized:");
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
