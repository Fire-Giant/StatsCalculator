public class Main{
    public static void main(String[] args){
        double[] arr1 = {0.0, 5.6, -3.5, 2.3, 6.9, 419.0, -34556, 12};
        double[] arr2 = {2.0, 1.0,3.0,4.0,6.0,5.0,7.0,8.0};
        StatsCalculator tester = new StatsCalculator(arr1);
        tester.print();
        tester.printSorted();
        tester.printFiveNumberSummary();

    }
}
