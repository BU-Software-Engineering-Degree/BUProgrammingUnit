import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * FileReadingJUnitTests class - part of POP_ReadingAndWriting_STAFF
 * JUnit tests for File reading and writing, and user input tasks
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */
class FileReadingJUnitTests {

	FileReading fileReading;

	@BeforeEach
	void setUp() {
		fileReading = new FileReading();
	}

	@Test 
	//Test Task 1
	void testReadName1() throws Exception {
		assertEquals("Radia Perlman", fileReading.readName1("nameFileToRead.txt"));
		assertThrows(IOException.class,() -> fileReading.readName1("ddd.txt"));
	}

	@Test 
	//Test Task 2
	void testReadName2(){
		assertEquals("Radia Perlman", fileReading.readName2("nameFileToRead.txt"));
		assertEquals("Invalid filename", fileReading.readName2("ddd.txt"));
	}

	@Test 
	//Test Task 3
	void testReadNames() throws Exception{
		String[] names = {"Charles Babbage", "Susan Graham", "Raj Reddy", "Judea Pearl", "Edgar Codd", "Tim Berners-Lee","Sally Floyd", "Sophie Wilson","Max Newman", "Vint Cerf"};
		assertArrayEquals(names, fileReading.readNames("computingHeroesToRead.txt"));
	}

	@Test 
	//Test Task 4
	void testReadNumbers1() throws Exception{
		int[] numbers = {3456, 1234, 2345, 5555, 6743, 1235, 4556, 1987, 
				1254, 6776, 4345, 3422, 2334, 2323, 4333, 0, 0, 0, 0, 0};
		assertArrayEquals(numbers, fileReading.readNumbers1("numbersFile1ToRead.txt"));
	}

	@Test 
	//Test Task 5
	void testReadNumbers2() throws Exception{
		int[] numbers = {3456, 1234, 2345, 5555, 6743, 1235, 4556, 
				1254, 6776, 4345, 3422, 2334, 2323, 4333, 0, 0, 0, 0, 0, 0};
		assertArrayEquals(numbers, fileReading.readNumbers2("numbersFile2ToRead.txt"));
	}
	@Test 
	//Test Task 6 - Address Book
	void testReadAddressBook() throws Exception{
		String[] addressBook= {"Donald Knuth: 0111", "Dennis Ritchie: 0554", "Alan Turing: 4532", "Grace Hopper: 2222", "Ada Lovelace: 4464"};
		assertArrayEquals(addressBook, fileReading.readAddressBook("addressBookToRead.txt"));
	}
}
