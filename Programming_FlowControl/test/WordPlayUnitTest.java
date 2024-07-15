import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class WordPlayUnitTest {

    WordPlay wordPlay = new WordPlay();

    // Task 1
    @Test
    void testWhatComesFirst() {
        assertEquals("ant comes before zebra in the alphabet", wordPlay.whatComesFirst("ant", "zebra"));
        assertEquals("ant comes before bee in the alphabet", wordPlay.whatComesFirst("bee", "ant"));
        assertEquals("ant is the same as ant", wordPlay.whatComesFirst("ant", "ant"));

    }

    // Task 2
    @Test
    void testBackwardsString() {
        assertEquals("einaleM", wordPlay.backwardsString("Melanie"));
        assertEquals("c", wordPlay.backwardsString("c"));
        assertEquals("", wordPlay.backwardsString(""));
        assertEquals("54321", wordPlay.backwardsString("12345"));
        assertEquals("This is programming!", wordPlay.backwardsString("!gnimmargorp si sihT"));

    }

    //Task 3
    @Test
    void testHeadsOrTails() {
        String[] answers = {"Correct: you guessed heads and I flipped heads",
                "Correct: you guessed tails and I flipped tails",
                "Incorrect: you guessed heads and I flipped tails",
                "Incorrect: you guessed tails and I flipped heads"};
        assertTrue(Arrays.asList(answers).contains(wordPlay.headsOrTails("heads")));
        assertTrue(Arrays.asList(answers).contains(wordPlay.headsOrTails("tails")));

    }

    // Task 4
    @Test
    void testAddressBook() {
        String[] names = { "Tom", "Dick", "Harry" };
        String[] numbers = { "0111", "0554", "4532" };
        String[] book = { "Tom 0111", "Dick 0554", "Harry 4532" };
        assertArrayEquals(book, wordPlay.addressBook(names, numbers));
        String[] names1 = { "Melanie", "Ruth", "Heather" };
        String[] numbers1 = { "01202 961120", "01202 965555", "01202 961223" };
        String[] book1 = { "Melanie 01202 961120", "Ruth 01202 965555", "Heather 01202 961223" };
        assertArrayEquals(book1, wordPlay.addressBook(names1, numbers1));
    }

    // Task 5
    @Test
    void testRockPaperScissors() {
        String[] answers = { "USER:rock vs COMP:scissors user wins", "USER:paper vs COMP:rock user wins",
                "USER:scissors vs COMP:paper user wins", "USER:scissors vs COMP:rock COMPUTER wins",
                "USER:rock vs COMP:paper COMPUTER wins", "USER:paper vs COMP:scissors COMPUTER wins",
                "USER:scissors vs COMP:scissors it is a draw", "USER:paper vs COMP:paper it is a draw",
                "USER:rock vs COMP:rock it is a draw" };
        assertTrue(Arrays.asList(answers).contains(wordPlay.rockPaperScissors("rock")));
        assertTrue(Arrays.asList(answers).contains(wordPlay.rockPaperScissors("paper")));
        assertTrue(Arrays.asList(answers).contains(wordPlay.rockPaperScissors("scissors")));
    }
}
