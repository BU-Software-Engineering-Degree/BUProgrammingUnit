import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * FileWritingJUnitTests class - part of POP_ReadingAndWriting_STAFF
 * JUnit tests for File reading and writing, and user input tasks
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */
class FileWritingJUnitTests {

	FileReading fileReading;
	FileWriting fileWriting;
	FileWritingUtilities utilities;

	@BeforeEach
	void setUp() {
		fileReading = new FileReading();
		fileWriting = new FileWriting();
		utilities =  new FileWritingUtilities();
	}
	
	@Test 
	//Test Task 1
	void testWriteYourName() throws Exception {
		assertEquals("John Smith", fileReading.readName1(fileWriting.writeYourName("John Smith")));
		assertEquals("Sarah Jane Smith", utilities.forTestReadFile(fileWriting.writeYourName("Sarah Jane Smith")));
		assertThrows(NoSuchElementException.class,() -> fileReading.readName1(fileWriting.writeYourName("Bob")));
	}
	
	@Test 
	//Test Task 2
	void testWriteRandomNumbers() throws Exception {
		int top = 10;
		int[] numbers = fileReading.readNumbers1(fileWriting.writeRandomNumbers(top));
		
		assertEquals(20, numbers.length);
		
		for (int i = 0; i < top ; i++) {
			assertTrue(numbers[i] >= 1000 && numbers[i] <= 9999);
		}
		
		for(int i = top ; i < numbers.length; i++) {
			assertEquals(0, numbers[i]);
		}
	}
}
