public class Main{
    public static void main(String[] args){
        double[] arr = {0.0, 5.6, -3.5, 2.3, 6.9, 419.0, -34556, 12};
        StatsCalculator tester = new StatsCalculator(arr);
        System.out.println(tester.calculateMax());
    }
}
