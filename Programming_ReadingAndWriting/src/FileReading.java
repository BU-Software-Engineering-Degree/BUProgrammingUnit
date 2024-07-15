import java.io.File;
import java.util.Scanner;
/**
 * FileReading class - part of POP_ReadingAndWriting_STAFF
 * File reading and writing, and User input tasks
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */

public class FileReading {

    //Task 1
    public String readName1(String pathName) throws Exception {
        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);
        String name = fileScan.next() + " " + fileScan.next();
        fileScan.close();
        return name;
    }

    //Task 2
    public String readName2(String pathName) {
        String result;
        try {
            File fileNames = new File(pathName);
            Scanner fileScan = new Scanner(fileNames);
            result = fileScan.next() + " " + fileScan.next();
            fileScan.close();
        }
        catch (Exception FileNotFound){
            result = "Invalid filename";
        }
        return result;
    }

    //Task 3
    public String[] readNames(String pathName) throws Exception {
        String[] names = new String[10];

        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);
        for(int i = 0; i < 10; i++){
            names[i] = fileScan.nextLine();
        }
        fileScan.close();

        return names;
    }

    //Task 4
    public int[] readNumbers1(String pathName) throws Exception {
        int[] numbers = new int[20];
        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);

        int count = 0;
        while (count < 20){
            while (fileScan.hasNext()){
                numbers[count] = Integer.parseInt(fileScan.next());
                count++;
            }
            numbers[count] = 0;
            count++;
        }
        fileScan.close();

        return numbers;
    }

    //Task5
    public int[] readNumbers2(String pathName) throws Exception {
        int[] numbers = new int[20];
        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);

        int count = 0;
        while (count < 20){
            while (fileScan.hasNext()){
                try{
                    numbers[count] = Integer.parseInt(fileScan.next());
                    count++;
                }
                catch(Exception e){
                    fileScan.nextLine();
                }
            }
            numbers[count] = 0;
            count++;
        }
        fileScan.close();

        return numbers;
    }

    //Task 6
    public String[] readAddressBook(String pathName) throws Exception {
        String[] names = new String[5];

        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);
        for(int i = 0; i < 5; i++){
            names[i] = fileScan.nextLine() + ": " + fileScan.nextLine();
        }
        fileScan.close();

        return names;
    }
}
