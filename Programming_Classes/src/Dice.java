import java.util.Random;

public class Dice {

    // Task 1 - Constructor/Instance Variables

	private int faceValue;

    public Dice() {
        faceValue = 0;
    }

	// Task 2
	public void roll() {
		Random diceRoll = new Random();
        faceValue = diceRoll.nextInt(6)+1;
	}

	// Task 3
	public int getFaceValue() {
		return this.faceValue;
	}

	// Task 4
	public String toString() {
		return "" + this.faceValue;
	}
}
