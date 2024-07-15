import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CrapsJUnitTests {

	Craps craps;
	Dice dice;

	@BeforeEach
	void setUp()  {
		craps = new Craps();
		dice = new Dice();
	}

	@Test
		//Task 1
	void testShoot() {
		assertEquals(0, craps.getDice1().getFaceValue());
		assertEquals(0, craps.getDice2().getFaceValue());

		craps.shoot();
		assertTrue(craps.getDice1().getFaceValue() > 0 && craps.getDice1().getFaceValue() <= 6);
		assertTrue(craps.getDice2().getFaceValue() > 0 && craps.getDice2().getFaceValue() <= 6);

		craps.shoot();
		assertTrue(craps.getDice1().getFaceValue() > 0 && craps.getDice1().getFaceValue() <= 6);
		assertTrue(craps.getDice2().getFaceValue() > 0 && craps.getDice2().getFaceValue() <= 6);
	}

	@Test
		//Task 2
	void testAddUpScore() {
		craps.shoot();
		assertEquals(craps.addUpScore(), craps.getDice1().getFaceValue() + craps.getDice2().getFaceValue());
	}

	@Test
		//Task 3
	void testDecideOutcome() {
		craps.shoot();
		assertEquals("You lose".toLowerCase(), craps.decideOutcome(2).toLowerCase());
		assertEquals("You lose".toLowerCase(), craps.decideOutcome(3).toLowerCase());
		assertEquals("You lose".toLowerCase(), craps.decideOutcome(12).toLowerCase());

		assertEquals("You win".toLowerCase(), craps.decideOutcome(7).toLowerCase());
		assertEquals("You win".toLowerCase(), craps.decideOutcome(11).toLowerCase());

		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(4).toLowerCase());
		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(5).toLowerCase());
		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(6).toLowerCase());
		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(8).toLowerCase());
		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(9).toLowerCase());
		assertEquals("Throw again".toLowerCase(), craps.decideOutcome(10).toLowerCase());
	}

	@Test
		// Task 4
	void testGetResults() {
		craps.shoot();

		testResult(craps.getResults(), false);
	}

	@Test
		// Task 5
	void testPlayCraps() {
		String fullResult = craps.playCraps();

		assertTrue(fullResult.contains("\n**************\n"));

		String[] resultArray = fullResult.split("\n\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\n");

		testResult(resultArray[resultArray.length - 1], true);

		for (int i = 0; i < resultArray.length - 1; i++){
			testResult(resultArray[i], false);
		}
	}

	private void testResult(String result, boolean checkFinalResult){
		String[] array = result.split("\n");

		String line1 = array[0];
		String line1Check = line1.split(": ")[0] + ": ";
		int line1Check2 = Integer.parseInt(line1.split(": ")[1]);

		String line2 = array[1];
		String line2Check = line2.split(": ")[0] + ": ";
		int line2Check2 = Integer.parseInt(line2.split(": ")[1]);

		String line3 = array[2];
		String line3Check = line3.split(": ")[0] + ": ";
		int line3Check2 = Integer.parseInt(line3.split(": ")[1]);

		String line4 = array[3];
		String line4Check = line4.split(": ")[0] + ": ";
		String line4Check2 = line4.split(": ")[1];


		assertEquals("Dice 1: ", line1Check);
		assertEquals("Dice 2: ", line2Check);
		assertEquals("Total: ", line3Check);
		assertEquals("Result: ", line4Check);

		assertTrue(line1Check2 > 0 && line1Check2 <= 6);
		assertTrue(line2Check2 > 0 && line2Check2 <= 6);
		assertEquals((line1Check2 + line2Check2), line3Check2);

		assertTrue(line3Check2 <= 12 && line3Check2 >= 2);

		if(line3Check2 == 2 || line3Check2 == 3 || line3Check2 == 12) {
			assertEquals("You lose".toLowerCase(), line4Check2.toLowerCase());
		}else if(line3Check2 == 7 || line3Check2 == 11){
			assertEquals("You win".toLowerCase(), line4Check2.toLowerCase());
		}else{
			assertEquals("Throw again".toLowerCase(), line4Check2.toLowerCase());
		}

		if(checkFinalResult){
			assertTrue(line4Check2.equalsIgnoreCase("You lose") || line4Check2.equalsIgnoreCase("You win"));
		}
	}

}