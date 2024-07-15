public class LoopyCalculator {

    // Task 1
    public int sumFromOneToWhat(int topNumber) {
        int sum = 0;
        for(int i = 0; i <= topNumber; i++){
            sum += i;
        }
        return sum;
    }

    // Task 2
    public int sumFromWhatToWhat(int bottom, int top) {
        int sum = 0;
        for(int i = bottom; i <= top; i++){
            sum += i;
        }
        return sum;
    }

    // Task 3
    public String displayPrices(double[] oldPrices, double priceIncrease) {
        StringBuilder newPrices = new StringBuilder();
        for(double price : oldPrices){
            double newPrice = price + priceIncrease;
            newPrices.append(newPrice).append("\n");
        }
        return newPrices.toString();
    }

    // Task 4
    public double[] storeNewPrices(double[] oldPrices, int priceIncrease) {
        double[] newPrices = new double[oldPrices.length];
        for(int i = 0; i < oldPrices.length; i++){
            newPrices[i] = oldPrices[i] + priceIncrease;
        }
        return newPrices;
    }

    // Task 5
    public double[] storeNewPricesReversed(double[] oldPrices, double priceIncrease) {
        double[] newPrices = new double[oldPrices.length];
        for(int i = 0; i < oldPrices.length; i++){
            newPrices[i] = oldPrices[oldPrices.length - 1 - i] + priceIncrease;
        }
        return newPrices;
    }

    // Task 6
    public String timesTable(int multiplier) {
        StringBuilder timesTableResult = new StringBuilder();
        for(int i = 0; i <= 12; i++){
            int temp = i * multiplier;
            timesTableResult.append(i).append(" X ").append(multiplier).append(" = ").append(temp).append("\n");
        }
        return timesTableResult.toString();
    }

    // Task 7
    public String atLeastOneOfYourFiveADay(String[] fruitNVeg, int record) {
        StringBuilder toBeEaten = new StringBuilder();
        if(record == 0){
            record++;
        }
        for(int i = 0; i < record; i++){
            toBeEaten.append(i + 1).append(". ").append(fruitNVeg[i]).append("\n");
        }
        return toBeEaten.toString();
    }
}
