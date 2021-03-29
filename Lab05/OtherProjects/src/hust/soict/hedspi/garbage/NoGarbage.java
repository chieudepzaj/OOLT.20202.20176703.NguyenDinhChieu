package hust.soict.hedspi.garbage;


import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NoGarbage {
    public static void main(final String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        try {
            File file = new File("LOTR.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            StringBuffer sbf = new StringBuffer();
            String line;
            while ((line = bfr.readLine()) != null) {
                sbf.append(line);
                sbf.append('\n');
            }
            fr.close();
            s = sbf.toString();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}