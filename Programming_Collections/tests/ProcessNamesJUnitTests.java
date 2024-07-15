import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessNamesJUnitTests {

	ProcessNames processNames;
	ArrayList<String> namesMatchFile1 = new ArrayList<String>();
	ArrayList<String> namesMatchFile2 = new ArrayList<String>();
	ArrayList<String> namesMatchFile3 = new ArrayList<String>();
	ArrayList<String> namesMatchFile4 = new ArrayList<String>();

	ArrayList<String> namesReadFile1;
	ArrayList<String> namesReadFile2;
	ArrayList<String> namesReadFile3;
	ArrayList<String> namesReadFile4;

	ArrayList<String> names = new ArrayList<String>();

	@BeforeEach
	void setUp()  throws Exception{
		processNames = new ProcessNames();
		namesMatchFile1.addAll(Arrays.asList("Hiram Mcfarland", "Clark Snow", "Tory Warren", "Guy Cowan", "Ned Mcintosh", 
				"Hugo Johnston", "Beth Bates", "Tiffany Mccarty", "Kevin Matthews", "Elisabeth Yates"));
		
		namesMatchFile3.addAll(Arrays.asList("Lillian Coleman", "Kara Greer", "Joshua Pittman", "Lionel Page", "Rosemarie Graves", 
				"Lynn Francis", "Glenda Schmidt", "Floyd Walters", "Guillermo Butler", "Cary Weaver", 
				"Rosemary Mendoza", "Hugh West", "Leroy Hunt", "Becky Chambers", "Neil Roberson", 
				"Sabrina Anderson", "Raymond Rivera", "Dana Montgomery", "Sidney Meyer", 
				"Elmer Rose", "Bobby Moss", "Bridget Green", "Caleb Allison", "Ted Chavez", 
				"Angie Bradley", "Lora Nunez", "Vivian Thornton", "Cody Pierce", "Bobbie Nichols",
				"Kerry Singleton", "Elsie Stephens", "Hannah Lopez", "Hiram Mcfarland", 
				"Clark Snow", "Tory Warren", "Guy Cowan", "Ned Mcintosh", "Hugo Johnston", "Beth Bates",
				"Tiffany Mccarty", "Kevin Matthews", "Elisabeth Yates", "Alberta Newman", "Madeline Barker", 
				"Vicki Salazar", "Kristi Padilla", "Monique Love", "Cecilia Johnston", "Brandi Glover", "Belinda Richards"));

		namesMatchFile4.addAll(Arrays.asList("Leroy Hunt", "Becky Chambers", "Neil Roberson", "Sabrina Anderson", "Raymond Rivera", 
				"Dana Montgomery", "Sidney Meyer", "Elmer Rose", "Bobby Moss", "Bridget Green", "Caleb Allison", "Ted Chavez", "Angie Bradley", 
				"Lora Nunez", "Vivian Thornton", "Cody Pierce", "Bobbie Nichols", "Kerry Singleton", "Elsie Stephens", "Hannah Lopez", "Darrin Stevenson", 
				"Ronnie Bowman", "Rosa Mathis", "Trevor Jackson", "Fred Silva", "Leah Bowers", "Norman Edwards", "Dustin Farmer", "Patricia Maxwell", 
				"Delia Page", "Roosevelt Roy", "Moses Osborne", "Shawn Pratt", "Aaron Hubbard", "Emanuel Cox", 
				"Edmund Pearson", "Noel Abbott", "Erica Alvarez", "Jeanette Ballard", "George Waters", 
				"Marilyn Blake", "Carole Griffin", "Cameron Payne", "Melissa Wilkins", "Mable Hampton", 
				"Nettie Woods", "Margaret Townsend", "Ada Weber", "Alonzo Hubbard", "Charlie Fields", 
				"Julio Summers", "Norma Rice", "Adrienne Hicks", "Hiram Mcfarland", "Clark Snow", "Tory Warren", 
				"Guy Cowan", "Ned Mcintosh", "Hugo Johnston", "Beth Bates", "Tiffany Mccarty", "Kevin Matthews", 
				"Elisabeth Yates", "Alberta Newman", "Madeline Barker", "Vicki Salazar", "Kristi Padilla", 
				"Monique Love", "Cecilia Johnston", "Brandi Glover", "Belinda Richards", "Lillian Coleman", 
				"Kara Greer", "Joshua Pittman", "Lionel Page", "Rosemarie Graves", "Lynn Francis", 
				"Glenda Schmidt", "Floyd Walters", "Guillermo Butler", "Cary Weaver", "Rosemary Mendoza", 
				"Hugh West", "Mattie Hamilton", "Nick Carter", "Winston Montgomery", "Erica Manning", 
				"Clyde Vargas", "Dwight Alvarado", "Johnnie Johnson", "Cedric Foster", "Oliver Newman", 
				"Francis Glover", "Catherine Wright", "Marcia Myers", "Kristen Gutierrez", "Rick Cain", 
				"Timmy Gilbert", "Billie Brewer", "Pearl Ball"));

		
		namesReadFile1 = processNames.readNamesFromFile("namesFile1.txt");
		namesReadFile2 = processNames.readNamesFromFile("namesFile2.txt");
		namesReadFile3 = processNames.readNamesFromFile("namesFile3.txt");
		namesReadFile4 = processNames.readNamesFromFile("namesFile4.txt");
	}

	@Test
	// Task 1
	void testAddNamesConstructor(){
        ArrayList<String> match1 = new ArrayList<>(Arrays.asList("Hiram Mcfarland", "Beth Bates", "Tiffany Mccarty", "Kevin Matthews", "Elisabeth Yates"));
		ArrayList<String> match1Student = processNames.addNames("Hiram Mcfarland", "Beth Bates", "Tiffany Mccarty", "Kevin Matthews", "Elisabeth Yates");
		assertArrayEquals(match1.toArray(), match1Student.toArray());

        ArrayList<String> match2 = new ArrayList<>(Arrays.asList("Monique Love", "Cecilia Johnston", "Brandi Glover", "Belinda Richards", "Lillian Coleman"));
		ArrayList<String> match2Student = processNames.addNames("Monique Love", "Cecilia Johnston", "Brandi Glover", "Belinda Richards", "Lillian Coleman");
		assertArrayEquals(match2.toArray(), match2Student.toArray());
	}

	@Test
	// Task 2
	void testReadNamesFromConsole(){
		ArrayList<String> match1Student = processNames.readNamesFromConsole();
		ArrayList<String> match1 = new ArrayList<>(Arrays.asList("Alex", "Ben", "Olivia", "Lucy", "James"));
		assertArrayEquals(match1.toArray(), match1Student.toArray());
	}

	@Test
	// Task 3
	void testReadNamesFromFile() throws Exception {
		assertArrayEquals(namesMatchFile1.toArray(), namesReadFile1.toArray());
		assertArrayEquals(namesMatchFile2.toArray(), namesReadFile2.toArray());
		assertArrayEquals(namesMatchFile3.toArray(), namesReadFile3.toArray());
		assertArrayEquals(namesMatchFile4.toArray(), namesReadFile4.toArray());
		assertThrows(IOException.class,() -> processNames.readNamesFromFile("namesFile5.txt"));
	}

	@Test
	// Task 4
	void testSortNames() {
		Collections.sort(namesMatchFile1);
		assertArrayEquals(namesMatchFile1.toArray(), processNames.sortNames(namesReadFile1).toArray());

		Collections.sort(namesMatchFile2);
		assertArrayEquals(namesMatchFile2.toArray(), processNames.sortNames(namesReadFile2).toArray());

		Collections.sort(namesMatchFile3);
		assertArrayEquals(namesMatchFile3.toArray(), processNames.sortNames(namesReadFile3).toArray());

		Collections.sort(namesMatchFile4);
		assertArrayEquals(namesMatchFile4.toArray(), processNames.sortNames(namesReadFile4).toArray());
	}

	@Test
	// Task 5
	void testFindName() {
		assertTrue(processNames.findName(namesReadFile1, "Hugo Johnston"));
		assertTrue(processNames.findName(namesReadFile3, "Caleb Allison"));
		assertTrue(processNames.findName(namesReadFile4, "Alberta Newman"));
		assertFalse(processNames.findName(namesReadFile1, "Alberta Newman"));
		assertFalse(processNames.findName(namesReadFile2, "Caleb Allison"));
	}

	@Test
	// Task 6
	void testFindNamePosition() {
		assertEquals(5,processNames.findNamePosition(namesReadFile1, "Hugo Johnston"));
		assertEquals(22, processNames.findNamePosition(namesReadFile3, "Caleb Allison"));
		assertEquals(63,processNames.findNamePosition(namesReadFile4, "Alberta Newman"));
		assertEquals(-1,processNames.findNamePosition(namesReadFile1, "Alberta Newman"));
		assertEquals(-1,processNames.findNamePosition(namesReadFile2, "Caleb Allison"));
	}

	@Test
	// Task 7
	void testAddNameAdhoc(){
		assertFalse(namesReadFile1.contains("Trevor Mcgee"));
		assertTrue(processNames.addName(namesReadFile1,"Trevor Mcgee").contains("Trevor Mcgee"));
		assertFalse(namesReadFile2.contains("Eva Young"));
		assertTrue(processNames.addName(namesReadFile2,"Eva Young").contains("Eva Young"));
		assertFalse(namesReadFile3.contains("Tasha Fox"));
		assertTrue(processNames.addName(namesReadFile3,"Tasha Fox").contains("Tasha Fox"));
		assertFalse(namesReadFile4.contains("Rickey Mckenzie"));
		assertTrue(processNames.addName(namesReadFile4,"Rickey Mckenzie").contains("Rickey Mckenzie"));
	}

	@Test
	// Task 8
	void testDeleteName(){
		assertTrue(namesReadFile3.contains("Hannah Lopez"));
		assertFalse(processNames.deleteName(namesReadFile3,"Hannah Lopez").contains("Hannah Lopez"));
		assertTrue(namesReadFile4.contains("Pearl Ball"));
		assertFalse(processNames.deleteName(namesReadFile4,"Pearl Ball").contains("Pearl Ball"));
		assertTrue(namesReadFile1.contains("Kevin Matthews"));
		assertFalse(processNames.deleteName(namesReadFile1,"Kevin Matthews").contains("Kevin Matthews"));
		assertFalse(processNames.deleteName(namesReadFile1,"Melanie").contains("Melanie"));
	}

	@Test
	// Task 9
	void testChangeName(){
		assertFalse(namesReadFile1.contains("Hugo Smith"));
		assertTrue(namesReadFile1.contains("Hugo Johnston"));
		assertTrue(processNames.changeName(namesReadFile1, "Hugo Johnston", "Hugo Smith").contains("Hugo Smith"));
		assertFalse(namesReadFile4.contains("Oli Newman"));
		assertTrue(namesReadFile4.contains("Oliver Newman"));
		assertTrue(processNames.changeName(namesReadFile4, "Oliver Newman", "Oli Newman").contains("Oli Newman"));
	}

	@Test
	// Task 10
	void testWriteNames() throws Exception {
		namesReadFile1.add("Florence Caldwell");
		namesReadFile1.add("Fred Becker");
		assertArrayEquals(processNames.readNamesFromFile(processNames.writeNames(namesReadFile1)).toArray(), namesReadFile1.toArray());

		namesReadFile2.add("Kathy Wood");
		namesReadFile2.add("Lee Carlson");
		assertArrayEquals(processNames.readNamesFromFile(processNames.writeNames(namesReadFile2)).toArray(), namesReadFile2.toArray());
	}
}
