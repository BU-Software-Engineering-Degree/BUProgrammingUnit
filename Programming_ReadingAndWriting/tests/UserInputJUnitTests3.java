import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * UserInputJUnitTests class - part of POP_ReadingAndWriting_STAFF
 * JUnit tests for File reading and writing, and user input tasks
 *
 * NOTE Test data for task 3 available at the end of the class.
 *
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */
class UserInputJUnitTests3 {

	UserInput userInput;

	@BeforeEach
	void createObject() {
		userInput = new UserInput();
	}

	@Test
		//Task 3
	void testReadTenNames() {
		String[] names = {"Michael","Saru","Christopher","Sylvia","Paul","Harry","Phillipa","Gabriel","Jett","Ash"};
		assertArrayEquals(names, userInput.readTenNames());
	}
}
/*
Task 3 - See JUnit Test Data below
Michael
Saru
Christopher
Sylvia
Paul
Harry
Phillipa
Gabriel
Jett
Ash
*/