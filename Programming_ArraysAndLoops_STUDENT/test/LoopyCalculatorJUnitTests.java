import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopyCalculatorJUnitTests {

    LoopyCalculator loopyCalculator = new LoopyCalculator();


    //Task 1
    @Test
    void testSumFromOneToWhat() {
        assertEquals(55, loopyCalculator.sumFromOneToWhat(10));
        assertEquals(1, loopyCalculator.sumFromOneToWhat(1));
        assertEquals(0, loopyCalculator.sumFromOneToWhat(0));
        assertEquals(5151, loopyCalculator.sumFromOneToWhat(101));
        assertEquals(0, loopyCalculator.sumFromOneToWhat(-1));
    }

    //Task 2
    @Test
    void testSumFromWhatToWhat() {
        assertEquals(55, loopyCalculator.sumFromWhatToWhat(1,10));
        assertEquals(3, loopyCalculator.sumFromWhatToWhat(1,2));
        assertEquals(55, loopyCalculator.sumFromWhatToWhat(0, 10));
        assertEquals(-1, loopyCalculator.sumFromWhatToWhat(-1,0));
        assertEquals(-55, loopyCalculator.sumFromWhatToWhat(-10,0));
    }
    //Task 1
    @Test
    void testDisplayPrices() {
        double[] prices = new double[] {444.29, 3.18, 255,07, 89.77, 17.56};
        double[] pricesPlus10 = new double[] {454.29, 13.18, 265,07, 99.77, 27.56};
        assertEquals("454.29\n" +
                "13.18\n" +
                "265.0\n" +
                "17.0\n" +
                "99.77\n" +
                "27.56\n", loopyCalculator.displayPrices(prices, 10.00));
        assertEquals("10444.29\n" +
                "10003.18\n" +
                "10255.0\n" +
                "10007.0\n" +
                "10089.77\n" +
                "10017.56\n", loopyCalculator.displayPrices(prices, 10000.00));
        assertEquals("444.29\n" +
                "3.18\n" +
                "255.0\n" +
                "7.0\n" +
                "89.77\n" +
                "17.56\n", loopyCalculator.displayPrices(prices, 0));
        assertEquals("422.29\n" +
                "-18.82\n" +
                "233.0\n" +
                "-15.0\n" +
                "67.77\n" +
                "-4.440000000000001\n", loopyCalculator.displayPrices(prices, -22));

    }

    //Task 2
    @Test
    void testStoreNewPrices() {
        double[] prices = new double[]{444.29, 3.18, 255, 07, 89.77, 17.56};
        assertEquals("[454.29, 13.18, 265.0, 17.0, 99.77, 27.56]", Arrays.toString(loopyCalculator.storeNewPrices(prices, 10)));
        assertEquals("[449.29, 8.18, 260.0, 12.0, 94.77, 22.56]", Arrays.toString(loopyCalculator.storeNewPrices(prices, 5)));
        assertEquals("[444.29, 3.18, 255.0, 7.0, 89.77, 17.56]", Arrays.toString(loopyCalculator.storeNewPrices(prices, 0)));
    }
    //Task 5
    @Test
    void testStoreNewPricesReversed() {

        double[] morePrices = new double[] {444.29, 3.18, 255,07, 89.77, 17.56};
        assertEquals("[39.78, 111.99, 29.22, 277.22, 25.4, 466.51]", Arrays.toString(loopyCalculator.storeNewPricesReversed(morePrices,22.22)));
        assertEquals("[17.56, 89.77, 7.0, 255.0, 3.18, 444.29]", Arrays.toString(loopyCalculator.storeNewPricesReversed(morePrices, 0)));
        assertEquals("[15.559999999999999, 87.77, 5.0, 253.0, 1.1800000000000002, 442.29]", Arrays.toString(loopyCalculator.storeNewPricesReversed(morePrices,-2)));
    }



    @Test
    /**
     * Task 6
     * The method takes the times table number and displays multiples in rows showing the whole calculation, up to 12 times.
     * eg  1 x 9 = 9
     */
    void testTimesTable() {
       assertEquals("0 X 10 = 0\n" +
                "1 X 10 = 10\n" +
                "2 X 10 = 20\n" +
                "3 X 10 = 30\n" +
                "4 X 10 = 40\n" +
                "5 X 10 = 50\n" +
                "6 X 10 = 60\n" +
                "7 X 10 = 70\n" +
                "8 X 10 = 80\n" +
                "9 X 10 = 90\n" +
                "10 X 10 = 100\n" +
                "11 X 10 = 110\n" +
                "12 X 10 = 120\n", loopyCalculator.timesTable(10));
        assertEquals("0 X 2 = 0\n" +
                "1 X 2 = 2\n" +
                "2 X 2 = 4\n" +
                "3 X 2 = 6\n" +
                "4 X 2 = 8\n" +
                "5 X 2 = 10\n" +
                "6 X 2 = 12\n" +
                "7 X 2 = 14\n" +
                "8 X 2 = 16\n" +
                "9 X 2 = 18\n" +
                "10 X 2 = 20\n" +
                "11 X 2 = 22\n" +
                "12 X 2 = 24\n", loopyCalculator.timesTable(2));
        assertEquals("0 X 1 = 0\n" +
                "1 X 1 = 1\n" +
                "2 X 1 = 2\n" +
                "3 X 1 = 3\n" +
                "4 X 1 = 4\n" +
                "5 X 1 = 5\n" +
                "6 X 1 = 6\n" +
                "7 X 1 = 7\n" +
                "8 X 1 = 8\n" +
                "9 X 1 = 9\n" +
                "10 X 1 = 10\n" +
                "11 X 1 = 11\n" +
                "12 X 1 = 12\n", loopyCalculator.timesTable(1));
        assertEquals("0 X 0 = 0\n" +
                "1 X 0 = 0\n" +
                "2 X 0 = 0\n" +
                "3 X 0 = 0\n" +
                "4 X 0 = 0\n" +
                "5 X 0 = 0\n" +
                "6 X 0 = 0\n" +
                "7 X 0 = 0\n" +
                "8 X 0 = 0\n" +
                "9 X 0 = 0\n" +
                "10 X 0 = 0\n" +
                "11 X 0 = 0\n" +
                "12 X 0 = 0\n", loopyCalculator.timesTable(0));
       assertEquals("0 X -2 = 0\n" +
                "1 X -2 = -2\n" +
                "2 X -2 = -4\n" +
                "3 X -2 = -6\n" +
                "4 X -2 = -8\n" +
                "5 X -2 = -10\n" +
                "6 X -2 = -12\n" +
                "7 X -2 = -14\n" +
                "8 X -2 = -16\n" +
                "9 X -2 = -18\n" +
                "10 X -2 = -20\n" +
                "11 X -2 = -22\n" +
                "12 X -2 = -24\n", loopyCalculator.timesTable(-2));
    }



    //Task 7
    @Test
    void testAtLeastOneOfYourFiveADay() {
        String[] fruitNVeg = new String[] {"apple", "carrot", "banana", "celery", "orange", "peas"};

        assertEquals("1. apple\n" +
                "2. carrot\n" +
                "3. banana\n",loopyCalculator.atLeastOneOfYourFiveADay(fruitNVeg,3));
        assertEquals("1. apple\n", loopyCalculator.atLeastOneOfYourFiveADay(fruitNVeg,0));
        assertEquals("1. apple\n" +
                "2. carrot\n" +
                "3. banana\n" +
                "4. celery\n" +
                "5. orange\n",loopyCalculator.atLeastOneOfYourFiveADay(fruitNVeg,5));
    }
}
