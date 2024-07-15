import java.util.Random;

/**
 * WordPlay class - part of Control Flow
 * Advanced String manipulation tasks examples
 * @author Dr Suzy Atfieldcutts adapted from Melanie Coles
 * @since 2020 updated 2023
 */
public class WordPlay {

    //Task1
    public String whatComesFirst(String wordOne, String wordTwo) {
        String answer;
        if (!(wordOne.equals(wordTwo))) {
            if (wordOne.charAt(0) < wordTwo.charAt(0)) {
                answer = wordOne + " comes before " + wordTwo + " in the alphabet";
            }
            else {
                answer = wordTwo + " comes before " + wordOne + " in the alphabet";
            }
        }
        else {
            answer = wordOne + " is the same as " + wordTwo;
        }
        return answer;
    }

    //Task 2
    public String backwardsString(String forwardString) {
        StringBuilder backwardString = new StringBuilder();
        for (int i = forwardString.length() - 1; i >= 0; i--) {
            backwardString.append(forwardString.charAt(i));
        }
        return backwardString.toString();
    }

    //Task 3
    public String headsOrTails(String guess) {
        String result;
        Random headOrTailsGenerator = new Random();
        int resultInt = headOrTailsGenerator.nextInt(2);
        if (resultInt == 0){
            if (guess.equals("heads")) {
                result = "Correct: you guessed heads and I flipped heads";
            }
            else {
                result = "Incorrect: you guessed heads and I flipped tails";
            }
        }
        else {
            if (guess.equals("tails")) {
                result = "Correct: you guessed tails and I flipped tails";
            }
            else {
                result = "Incorrect: you guessed heads and I flipped tails";
            }
        }
        return result;
    }

    //Task 4
    public String[] addressBook(String[] name, String[] numbers) {
        String [] book = new String[name.length];
        for (int i = 0; i < name.length; i++) {
            book[i] = name[i] + " " + numbers[i];
        }
        return book;
    }

    //Task 5
    public String rockPaperScissors(String userGuess) {
        String compGuess; String winner;
        Random rockPaperScissorsGenerator = new Random();
        int compGuessInt = rockPaperScissorsGenerator.nextInt(3);
        if (compGuessInt == 0) {
            compGuess = "rock";
        }
        else if (compGuessInt == 1) {
            compGuess = "paper";
        }
        else {
            compGuess = "scissors";
        }

        if (userGuess.equals(compGuess)) {
            winner = "draw";
        }
        else if ((userGuess.equals("rock") && compGuess.equals("scissors")) || (userGuess.equals("scissors") && compGuess.equals("paper")) || (userGuess.equals("paper") && compGuess.equals("rock"))) {
            winner = "user";
        }
        else {
            winner = "comp";
        }
        return "USER:%s vs COMP:%s %s".formatted(userGuess, compGuess, winner.equals("user") ? "user wins" : winner.equals("comp") ? "COMPUTER wins" : "it is a draw");
    }
}
