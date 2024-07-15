
public class Craps {

    // Task 1 - Constructor/Instance Variables

    private final Dice firstDice;
    private final Dice secondDice;

    public Craps() {
        this.firstDice = new Dice();
        this.secondDice = new Dice();
    }

	// Task 2
	public void shoot() {
		this.firstDice.roll();
        this.secondDice.roll();
	}

	// Task 3
	public Dice getDice1() {
		return firstDice;
	}

	public Dice getDice2() {
		return secondDice;
	}

	// Task 4
	public int addUpScore() {
		return firstDice.getFaceValue() + secondDice.getFaceValue();
	}

	// Task 5
	public String decideOutcome(int total) {
		String result;

        if(total == 7 || total == 11){
            result = "You win";
        }
        else if(total == 2 || total == 3 || total == 12){
            result = "You lose";
        }
        else{
            result = "Throw again";
        }

        return result;
	}

	// Task 6
	public String getResults() {
        return "Dice 1: " + firstDice + "\nDice 2: " + secondDice + "\nTotal: " + this.addUpScore() + "\nResult: " + this.decideOutcome(this.addUpScore());
	}

	// Task 7
	public String playCraps() {
		StringBuilder fullResults;

		firstDice.roll();
		secondDice.roll();
		String outcome = this.decideOutcome(this.addUpScore());
		fullResults = new StringBuilder(this.getResults() + "\n**************\n");

		while(outcome.equals("Throw again")){
			firstDice.roll(); secondDice.roll();
			fullResults.append(this.getResults()).append("\n**************\n");
			outcome = this.decideOutcome(this.addUpScore());
		}

		return fullResults.toString();
	}

	/*Task 8 Additional tasks - OPTIONAL AND NOT ASSESSED
	Can you add a method that asks the user if they want to play again?
	public ?? playAgain(??){

	}*/
}
