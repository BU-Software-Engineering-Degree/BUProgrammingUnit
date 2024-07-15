import java.util.Random;

    /**
     * MarksCalculator class - part of Control Flow
     * Selection and Iteration examples
     * @author Dr Suzy Atfieldcutts adapted from Melanie Coles
     * @since 2023
     */
    public class MarksCalculator {

        // Task 1
        public int highestOfTwoMarks(int num1, int num2){
            int highestNum = -1;
            if(num1 > num2){
                highestNum = num1;
            }
            if(num2 > num1){
                highestNum = num2;
            }
            return highestNum;
        }

        // Task 2
        public String calculateGrade(int mark) {
            String grade = "";
            if(mark > 100 || mark < 0){
                grade = "Invalid mark";
            }
            if(mark > 0 && mark < 40){
                grade = "Fail";
            }
            if(mark >= 40 && mark < 50){
                grade = "3rd";
            }
            if(mark >= 50 && mark < 60){
                grade = "2ii";
            }
            if(mark >= 60 && mark < 70){
                grade = "2i";
            }
            if(mark >= 70 && mark <= 100){
                grade = "1st";
            }

            return grade;
        }

        // Task 3
        public int[] randomMarkGenerator(){
            int[] randomMarks = new int[6];
            Random randomMarksGenerator = new Random();
            for (int i = 0; i < randomMarks.length; i++){
                int temp = randomMarksGenerator.nextInt(100) + 1;
                randomMarks[i] = temp;
            }
            return randomMarks;
        }

        // Task 4
        public int[] randomMarkGenerator(int marksNeeded){
            int[] randomMarks = new int[marksNeeded];
            Random randomMarksGenerator = new Random();
            for (int i = 0; i < marksNeeded; i++){
                int temp = randomMarksGenerator.nextInt(100) + 1;
                randomMarks[i] = temp;
            }
            return randomMarks;
        }

        //Task 5
        public double randomMarksAverage(int[] marksArray) {
            double sum = 0;
            for (int j : marksArray) {
                sum = sum + j;
            }
            return sum / marksArray.length;
        }

        // Task 6
        //ADVANCED NO UNIT TEST - Individual parts already tested.
        /*public ?? classMarksSummary(??)
        {
            return ??;
        }*/
    }

