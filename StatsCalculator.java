import static java.util.Arrays.sort;

public class StatsCalculator {
    private double[] arr;
    private double[] sortedArray;
    public StatsCalculator(){
        arr = new double[20];
    }
    public StatsCalculator(double[] values){
        arr = new double[values.length];
        for(int i = 0; i < values.length; i++){
            arr[i] = values[i];
        }
    }
    public void sortData(){
        sortedArray = arr;
        sort(sortedArray);

    }
    public double calculateMax(){
       sortData();
       return sortedArray[arr.length-1];
    }
    public double calculateMin(){
        sortData();
        return sortedArray[0];
    }
    public double calculateFirstQuartile(){
        sortData();
        if(arr.length%4 <= 1){
        return((sortedArray[(arr.length/2)/2]+sortedArray[(arr.length/2)/2-1])/2);
        }
        return sortedArray[(arr.length/2)/2];
    }
    public double calculateThirdQuartile(){
        sortData();
        if(arr.length%4 <= 1){
            return((sortedArray[arr.length-1-(arr.length/2)/2]+sortedArray[arr.length-1-(arr.length/2)/2+1])/2);
        }
        return sortedArray[arr.length-1-(arr.length/2)/2];
    }
    public double calculateMedian(){
        sortData();
        if(arr.length%2 == 0){
            return (sortedArray[arr.length/2]+sortedArray[arr.length/2-1])/2;
        }
        else{
            return sortedArray[arr.length/2];
        }
    }
    public double calculateSum(){
        double sum =0;
        for(double addToSum : arr){
            sum += addToSum;
        }
        return sum;
    }
    public double calculateMean(){
        return calculateSum()/arr.length;
    }
    public void print(){
        System.out.print("Your data is: ");
        for(double value : arr){
            System.out.print(value+ " ");
        }
        System.out.println();
    }
    public void printSorted(){
        System.out.print("Your sorted data is: ");
        sortData();
        for(double values : sortedArray){
            System.out.print(values+" ");
        }
        System.out.println();
    }
    public void printFiveNumberSummary(){
        System.out.println("The five number summary is: ");
        System.out.println("Minimum: "+calculateMin());
        System.out.println("First Quartile: "+calculateFirstQuartile());
        System.out.println("Median: "+calculateMedian());
        System.out.println("Third Quartile: "+calculateThirdQuartile());
        System.out.println("Maximum: "+calculateMax());
        System.out.println();
    }


}
