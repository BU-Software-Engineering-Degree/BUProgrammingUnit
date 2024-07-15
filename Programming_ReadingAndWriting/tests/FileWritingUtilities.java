import java.io.File;
import java.util.Scanner;
/**
 * FileWritingUtilities class - part of POP_ReadingAndWriting_STAFF
 * JUnit tests for File reading and writing, and user input tasks
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */
public class FileWritingUtilities {

	public String forTestReadFile(String filename) throws Exception {
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file);
		String name="";
		while(fileScanner.hasNext()){
			name = name+" "+fileScanner.next();
		}
		name = name.trim();
		fileScanner.close();
		return name;
	}	
}