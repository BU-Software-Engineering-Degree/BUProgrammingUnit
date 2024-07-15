import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
/**
 * FileWriting class - part of POP_ReadingAndWriting_STAFF
 * File reading and writing, and User input tasks
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */
public class FileWriting {

    //Task 1
    public String writeYourName(String namesString) throws Exception {
        String[] names = namesString.split(" ");

        String fileName = "namewriting.txt";
        PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter(fileName)));
        for (String name : names) {
            out.println(name);
        }
        out.close();
        return fileName;
    }

    //Task 2
    public String writeRandomNumbers(int count) throws Exception {
        String fileName = "numberwriting.txt";
        PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter(fileName)));
        Random numberGenerator = new Random();
        for(int i = 0; i < count; i++){
            int randomNumber = numberGenerator.nextInt(8999)+1000;
            out.println(randomNumber);
        }
        out.close();
        return fileName;
    }

}
