import java.util.Random;

/**
 * MyArrays class
 * This class contains tasks about using arrays.
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */

public class MyArrays {

	// Task 1
	public int addUpNumbers(int num1, int num2, int num3, int num4, int num5) {
        return num1 + num2 + num3 + num4 + num5;
	}

	// Task 2
	public int addUpNumbersArray(int[] numbers) {
		int num = 0;
        for (int number : numbers) {
            num = num + number;
        }
        return num;
	}

	// Task 3
	public double averageOfNumbers(int[] numbers) {
		double average = 0;
        for (int number : numbers) {
            average = average + number;
        }
        average = average / numbers.length;
        return average;
	}

	// Task 4
	public int[] convertToCelsius(int[] fahrenheit) {
		int[] celsius;
        celsius = new int[fahrenheit.length];
        for (int i = 0; i < fahrenheit.length; i++){
            int temp = fahrenheit[i];
            temp = ((temp - 32) * 5) / 9;
            celsius[i] = temp;
        }
        return celsius;
    }

	// Task 5
	public String[] unitMarks(int[] rawMarks) {
		String[] unitsAndAverage = {"APP:","BSAD:","CF:","DAD:","N&CS:","POP:","Average:"};
        double average = 0;
        for (int i = 0; i < rawMarks.length - 1; i++) {
            unitsAndAverage[i] = unitsAndAverage[i] + rawMarks[i];
        }
        unitsAndAverage[rawMarks.length - 1] = unitsAndAverage[rawMarks.length - 1] + rawMarks[rawMarks.length - 1];
        for (int rawMark : rawMarks) {
            average = average + rawMark;
        }
        average = average / rawMarks.length;
        unitsAndAverage[rawMarks.length] = unitsAndAverage[rawMarks.length] + average;
        return unitsAndAverage;
	}

	// Task 6
	public String andTheWinnerIs(String[] names) {
        Random randomNumberGenerator = new Random();
        int winnerIs = randomNumberGenerator.nextInt(names.length);
        return names[winnerIs];
	}
}
