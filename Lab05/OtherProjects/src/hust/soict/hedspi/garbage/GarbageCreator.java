package hust.soict.hedspi.garbage;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class GarbageCreator {
    public static void main(final String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        try {
            File myObj = new File("LOTR.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}