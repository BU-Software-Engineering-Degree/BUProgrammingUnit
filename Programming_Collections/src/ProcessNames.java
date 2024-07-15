import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProcessNames {

    // Task 1 - create and add from code
    public ArrayList<String> addNames(String name1, String name2, String name3, String name4, String name5) {
        ArrayList<String> names = new ArrayList<>();
        names.add(name1); names.add(name2); names.add(name3); names.add(name4); names.add(name5);
        return names;
    }

    // Task 2 - create and add from console
    public ArrayList<String> readNamesFromConsole() {
        ArrayList<String> names = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            System.out.print("Enter name " + (i+1) + ": ");
            names.add(keyboard.next());
        }
        return names;
    }

    // Task 3 - read in all data from a file
    public ArrayList<String> readNamesFromFile(String pathName) throws Exception {
        ArrayList<String> names = new ArrayList<>();

        File fileNames = new File(pathName);
        Scanner fileScan = new Scanner(fileNames);
        while (fileScan.hasNext()){
            names.add(fileScan.nextLine());
        }
        fileScan.close();

        return names;
    }

    // Task 4 - sort the data
    public ArrayList<String> sortNames(ArrayList<String> names) {
        Collections.sort(names);
        return names;
    }

    // Task 5 - find if exists
    public boolean findName(ArrayList<String> names, String toFind) {
        boolean found = false;
        for (String name : names){
            if (name.equals(toFind)) {
                found = true;
                break;
            }
        }
        return found;
    }

    // Task 6 - find index
    public int findNamePosition(ArrayList<String> names, String toFind) {
        int position = -1;
        for (String name : names){
            if (name.equals(toFind)) {
                position = names.indexOf(name);
                break;
            }
        }
        return position;
    }

    // Task 7 - add name
    public ArrayList<String> addName(ArrayList<String> names, String toAdd) {
        names.add(toAdd);
        return names;
    }

    // Task 8 - delete name
    public ArrayList<String> deleteName(ArrayList<String> names, String toRemove) {
        int position = -1;
        for (String name : names){
            if (name.equals(toRemove)) {
                position = names.indexOf(name);
                break;
            }
        }
        if (position != -1){
            names.remove(position);
        }
        return names;
    }

    // Task 9 - change name
    public ArrayList<String> changeName(ArrayList<String> names, String toFind, String alterTo) {
        int position = -1;
        for (String name : names){
            if (name.equals(toFind)) {
                position = names.indexOf(name);
                break;
            }
        }
        if (position != -1){
            names.set(position, alterTo);
        }
        return names;
    }

    // Task 10 - write the new data back to the file
    public String writeNames(ArrayList<String> names) throws Exception {
        String fileName = "namewriting.txt";
        PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter(fileName)));
        for (String name : names) {
            out.println(name);
        }
        out.close();
        return fileName;
    }
}
