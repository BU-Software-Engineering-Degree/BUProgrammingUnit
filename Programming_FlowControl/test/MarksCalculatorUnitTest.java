import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * MarksCalculatorUnitTests - part of Flow Control
 * JUnit testing the MarksCalculator class
 * Selection and Iteration examples
 * @author Dr Suzy Atfieldcutts adapted from Melanie Coles
 * @since 2020
 */

class MarksCalculatorUnitTest {

    MarksCalculator marksCalculator;

    @BeforeEach
    void createObject() {
        marksCalculator = new MarksCalculator();
    }

    //Task 1
    @Test
    void highestOfTwoMarks() {
        assertEquals(20, marksCalculator.highestOfTwoMarks(10, 20));
        assertEquals(-1, marksCalculator.highestOfTwoMarks(5, 5));
        assertEquals(345, marksCalculator.highestOfTwoMarks(345, 5));
    }

    //Task 2
    @Test
    void testCalculateGrade() {
        assertEquals("Fail", marksCalculator.calculateGrade(30));
        assertEquals("3rd", marksCalculator.calculateGrade(44));
        assertEquals("Invalid mark", marksCalculator.calculateGrade(123));
        assertEquals("1st", marksCalculator.calculateGrade(70));
        assertEquals("2i", marksCalculator.calculateGrade(65));
        assertEquals("Invalid mark", marksCalculator.calculateGrade(-2));
    }

    //Task 3
    @Test
    void testRandomMarksNoParam() {
        boolean allItemsHaveValue=true;
        int[] randomMarks = marksCalculator.randomMarkGenerator();
        for (int num : randomMarks) {
            if (num < 1 || num > 100){
                allItemsHaveValue = false;
            }
        }
        assertTrue(allItemsHaveValue);
    }

    //Task 4
    @Test
    void testRandomMarksWithParam() {
        boolean allItemsHaveValue=true;
        int[] randomMarks = marksCalculator.randomMarkGenerator(100);
        for (int num : randomMarks) {
            if (num < 1 || num > 100){
                allItemsHaveValue = false;
            }
        }
        assertTrue(allItemsHaveValue);
    }

    //Task 5
    @Test
    void testRandomMarksAndAAverage() {
        int[] randomMarks = marksCalculator.randomMarkGenerator(100);
        int sum=0;
        for (int num : randomMarks) {
            assertTrue(num >= 1 && num <= 100);
            sum+=num;
        }
        //average from student answer
        double average = marksCalculator.randomMarksAverage(randomMarks);
        assertTrue((double)sum/randomMarks.length == average);
    }

}