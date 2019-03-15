
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class main {

  public static int[] tenArray = new int[10];
  public static int[] hundredArray = new int[100];
  public static int[] thousandArray = new int[1000];
  public static int[] tenThousandArray = new int[10000];
  public static int[] hundredThousandArray = new int[100000];
  public static int[] fiveHundredThousandArray = new int[500000];
  public static int[] millionArray = new int[1000000];

//Benchmark Containers
  public static ArrayList<Double> tenMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenInsert = new ArrayList<Double>();
  public static ArrayList<Double> hundredMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredInsert = new ArrayList<Double>();
  public static ArrayList<Double> thousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> thousandInsert = new ArrayList<Double>();
  public static ArrayList<Double> tenthousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenthousandInsert = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandInsert = new ArrayList<Double>();
  public static ArrayList<Double> fiveHundredThousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> fiveHundredThousandInsert = new ArrayList<Double>();




   public static void main(String[] args) {

     int NUM_TRIALS = 1000;
     for (int i=0;i<NUM_TRIALS;i++ ) {
     System.out.println("Running Trial: "+ i);
     runAllMergeSortTests();
     runAllInsertionSortTests();
     //some magic to clear the console
     System.out.print("\033[H\033[2J");

   }
   printAveragesOfTests(NUM_TRIALS);
   }


   public static void runAllInsertionSortTests(){
     double benchmarkTen = insertionSortTest(tenArray);
     tenInsert.add(benchmarkTen);
     double benchmarkHundred = insertionSortTest(hundredArray);
     hundredInsert.add(benchmarkHundred);
     double benchmarkThousand = insertionSortTest(thousandArray);
     thousandInsert.add(benchmarkThousand);
     double benchmarkTenThousand = insertionSortTest(tenThousandArray);
     tenthousandInsert.add(benchmarkTenThousand);
     double benchmarkHundredThousand = insertionSortTest(hundredThousandArray);
     hundredThousandInsert.add(benchmarkHundredThousand);
     //double benchmarkFiveHundredThousand = insertionSortTest(fiveHundredThousandArray);
     //fiveHundredThousandInsert.add(benchmarkFiveHundredThousand);

     //double benchmark = insertionSortTest(millionArray);
   }

   public static void runAllMergeSortTests(){
     double benchmarkTen = mergeSortTest(tenArray);
     tenMerge.add(benchmarkTen);
     double benchmarkHundred = mergeSortTest(hundredArray);
     hundredMerge.add(benchmarkHundred);

     double benchmarkThousand = mergeSortTest(thousandArray);
     thousandMerge.add(benchmarkThousand);
     double benchmarkTenThousand = mergeSortTest(tenThousandArray);
     tenthousandMerge.add(benchmarkTenThousand);
     double benchmarkHundredThousand = mergeSortTest(hundredThousandArray);
     hundredThousandMerge.add(benchmarkHundredThousand);
  //   double benchmarkFiveHundredThousand = mergeSortTest(fiveHundredThousandArray);
  //   fiveHundredThousandMerge.add(benchmarkFiveHundredThousand);
     //double benchmarka = mergeSortTest(millionArray);
   }
   /**Didnt need for lab but developed anyway cause i cant read.
   public static void runAllMergeInsertionSortTests(){
     double benchmarkTen = mergeInsertionSortTest(tenArray);
     double benchmarkHundred = mergeInsertionSortTest(hundredArray);
     double benchmarkThousand = mergeInsertionSortTest(thousandArray);
     double benchmarkTenThousand = mergeInsertionSortTest(tenThousandArray);
     double benchmarkHundredThousand = mergeInsertionSortTest(hundredThousandArray);
     double benchmarkFiveHundredThousand = mergeInsertionSortTest(fiveHundredThousandArray);

     //double benchmarka = mergeInsertionSortTest(millionArray);
   }
 */


   public static double mergeSortTest(int[] testArray){
     randomlyPopulateArr(testArray);
     MergeSort mergeSort= new MergeSort();
     double benchmark = mergeSort.runBenchMark(testArray);
     return benchmark;


   }

   public static double insertionSortTest(int[] testArray){
     randomlyPopulateArr(testArray);
     InsertionSort insertionSortTest = new InsertionSort();
     double benchmark = insertionSortTest.runBenchMark(testArray);
     return benchmark;
   }

   public static double mergeInsertionSortTest(int[] testArray){
     randomlyPopulateArr(testArray);
     MergeInsertionSort mergeInsertionSortTest = new MergeInsertionSort();
     double benchmark = mergeInsertionSortTest.runBenchMark(testArray);
     return benchmark;
   }

   public static void randomlyPopulateArr(int[] arr){
     int max = 1000;
     int min = 1;
     int range = max - min + 1;
     for (int i=0;i<arr.length;i++ ) {
         int number = (int)(Math.random() * range) + min;
         arr[i]=number;
     }

   }

   public static void printAveragesOfTests(int trials){
     double a = calculateAverage(tenMerge);
     double b = calculateAverage(hundredMerge);
     double c = calculateAverage(thousandMerge);
     double d = calculateAverage(tenthousandMerge);
     double e = calculateAverage(hundredThousandMerge);

     double g = calculateAverage(tenInsert);
     double h = calculateAverage(hundredInsert);
     double i = calculateAverage(thousandInsert);
     double j = calculateAverage(tenthousandInsert);
     double k = calculateAverage(hundredThousandInsert);

     System.out.println("Total Trials: "+trials);
     System.out.println("|# elements | Algorithm | Average Time |");
     System.out.println("-----------------------------------");
     System.out.println("|    10     | MergeSort | "+a+"|");
     System.out.println("|    100    | MergeSort | "+b+"|");
     System.out.println("|    1000   | MergeSort | "+c+"|");
     System.out.println("|    10000  | MergeSort | "+d+"|");
     System.out.println("|    100000 | MergeSort | "+e+"|");
     System.out.println("|    10     | InsertSort| "+g+"|");
     System.out.println("|    100    | InsertSort| "+h+"|");
     System.out.println("|    1000   | InsertSort| "+i+"|");
     System.out.println("|    10000  | InsertSort| "+j+"|");
     System.out.println("|    100000 | InsertSort| "+k+"|");
     System.out.println("-----------------------------------");
     System.out.println("Tests Executed Successfully");





   }

  public static double calculateAverage(List <Double> marks) {
  double sum = 0;
  if(!marks.isEmpty()) {
    for (Double mark : marks) {
        sum += mark;
    }
    return sum / marks.size();
  }
  return sum;
}








}
