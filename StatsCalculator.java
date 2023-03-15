import static java.util.Arrays.sort;

public class StatsCalculator {
    private double[] arr;
    private double[] sortedArray;
    private double[] outliers;
    /**
     * @description default constructor creates an double array with length twenty
     */
    public StatsCalculator() {
        arr = new double[20];
    }

    /**
     * @description creates a new array of doubles
     * @param values
     *
     */

    public StatsCalculator(double[] values) {

        arr = values;
    }

    /**
     * @description Assigns the value of arr to sortedArray and then sorts that array least to greatest
     */
    public void sortData() {
        sortedArray = arr;
        sort(sortedArray);

    }

    /**
     * @description finds the maximum value of the array
     * @return The maximum value in the array
     */
    public double calculateMax() {
        sortData();
        return sortedArray[arr.length - 1];
    }

    /**
     * @description calculates the minimum value of the array
     * @return The minimum value in the array
     */
    public double calculateMin() {
        sortData();
        return sortedArray[0];
    }

    /**
     * @description calculates the first quartile of the array
     * @return Value at first quartile excluding the median
     */
    public double calculateFirstQuartile() {
        sortData();
        if (arr.length % 4 <= 1) {
            return ((sortedArray[(arr.length / 2) / 2] + sortedArray[(arr.length / 2) / 2 - 1]) / 2);
        }
        return sortedArray[(arr.length / 2) / 2];
    }

    /**
     * @description calculates the third quartile of the array
     * @return Value at third quartile excluding the median
     */
    public double calculateThirdQuartile() {
        sortData();
        if (arr.length % 4 <= 1) {
            return ((sortedArray[arr.length - 1 - (arr.length / 2) / 2] + sortedArray[arr.length - 1 - (arr.length / 2) / 2 + 1]) / 2);
        }
        return sortedArray[arr.length - 1 - (arr.length / 2) / 2];
    }

    /**
     * @description calculates the median value of the array
     * @return Value at middle of the array
     */
    public double calculateMedian() {
        sortData();
        if (arr.length % 2 == 0) {
            return (sortedArray[arr.length / 2] + sortedArray[arr.length / 2 - 1]) / 2;
        } else {
            return sortedArray[arr.length / 2];
        }
    }

    /**
     * @description adds all of the values together
     * @return All of the values added together (the sum)
     */
    public double calculateSum() {
        double sum = 0;
        for (double addToSum : arr) {
            sum += addToSum;
        }
        return sum;
    }

    /**
     * @description divides the sum of the values by the number of values
     * @return The average value of the ArrayList
     */
    public double calculateMean() {
        return (calculateSum() / arr.length);
    }

    /**
     * @description finds any of the outliers of the array using the 1.51 iqr rule
     * assigns them to a new array
     * @return double array of the outliers of the original array from least to greatest
     */
    public double[] findOutliers() {
        sortData();
        int count = 0;
        double[] temporaryArray = new double[arr.length];
        double interQuartileRange = calculateThirdQuartile() - calculateFirstQuartile();
        for (int i = 0; i < arr.length; i++) {
            if (sortedArray[i] < (calculateFirstQuartile() - 1.51 * interQuartileRange)
                    || sortedArray[i] > (calculateThirdQuartile() + 1.51 * interQuartileRange)) {
                temporaryArray[count] = sortedArray[i];
                count++;
            }
        }
        outliers = new double[count];
        for (int j = 0; j < count; j++) {
            outliers[j] = temporaryArray[j];
        }
        System.out.print("Outliers: ");
        if(outliers.length == 0){
            System.out.print("No outliers!");
        }
        for(double outlier: outliers){
            System.out.print(outlier+" ");
        }
        System.out.println();
        return outliers;
    }

    /**
     * @description Prints to the console each value in the array separated by a space
     */
    public void print() {
        System.out.print("Your data is: ");
        for (double value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * @description Prints to the console each value in the array from lease to greatest
     */
    public void printSorted() {
        System.out.print("Your sorted data is: ");
        sortData();
        for (double values : sortedArray) {
            System.out.print(values + " ");
        }
        System.out.println();
    }

    /**
     * @description Prints the minimum, first quartile, median, third quartile, maximum, and outliers to the console
     */
    public void printFiveNumberSummary() {
        System.out.println("The five number summary is: ");
        System.out.println("Minimum: " + calculateMin());
        System.out.println("First Quartile: " + calculateFirstQuartile());
        System.out.println("Median: " + calculateMedian());
        System.out.println("Third Quartile: " + calculateThirdQuartile());
        System.out.println("Maximum: " + calculateMax());
        findOutliers();
    }
}