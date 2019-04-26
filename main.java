
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class main {

//these get resued errytime yo even tho we in java we still hardcore.
  public static int[] tenArray = new int[10];
  public static int[] hundredArray = new int[100];
  public static int[] thousandArray = new int[1000];
  public static int[] tenThousandArray = new int[10000];
  public static int[] hundredThousandArray = new int[100000];
  public static int[] fiveHundredThousandArray = new int[500000];
  public static int[] millionArray = new int[1000000];

//Benchmark Containers
  public static ArrayList<Double> tenMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> thousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> thousandThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenthousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenthousandThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> fiveHundredThousandMerge = new ArrayList<Double>();
  public static ArrayList<Double> fiveHundredThousandThreadedMerge = new ArrayList<Double>();
  public static ArrayList<Double> tenQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> tenThreadedQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> hundredQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> hundredThreadedQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> thousandQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> thousandThreadedQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> tenThousandQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> tenThousandThreadedQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandQuickSort = new ArrayList<Double>();
  public static ArrayList<Double> hundredThousandThreadedQuickSort = new ArrayList<Double>();



   public static void main(String[] args) {

     int NUM_TRIALS = 5000;
     for (int i=0;i<NUM_TRIALS;i++ ) {
     System.out.println("Running Trial: "+ i);
     runAllMergeSortTests();
     runAllParallelMergeSortTests();
     runAllQuickSortTests();
     runAllParallelQuickSortTests();
     //some magic to clear the console
     System.out.print("\033[H\033[2J");
   }
   System.out.println(tenThreadedMerge);
    printAveragesOfTests(NUM_TRIALS);
   }


   public static void runAllParallelMergeSortTests(){
     double benchmarkTen = parallelMergeSortTest(tenArray);
     tenThreadedMerge.add(benchmarkTen);
     double benchmarkHundred = parallelMergeSortTest(hundredArray);
     hundredThreadedMerge.add(benchmarkHundred);
     double benchmarkThousand = parallelMergeSortTest(thousandArray);
     thousandThreadedMerge.add(benchmarkThousand);
     double benchmarkTenThousand = parallelMergeSortTest(tenThousandArray);
     tenthousandThreadedMerge.add(benchmarkTenThousand);
     double benchmarkHundredThousand = parallelMergeSortTest(hundredThousandArray);
     hundredThousandThreadedMerge.add(benchmarkHundredThousand);
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

   }

   public static void runAllQuickSortTests(){
     double benchmarkTen = quickSortTest(tenArray);
     tenQuickSort.add(benchmarkTen);
     double benchmarkHundred = quickSortTest(hundredArray);
     hundredQuickSort.add(benchmarkHundred);
     double benchmarkThousand = quickSortTest(thousandArray);
     thousandQuickSort.add(benchmarkThousand);
     double benchmarkTenThousand = quickSortTest(tenThousandArray);
     tenThousandQuickSort.add(benchmarkTenThousand);
     double benchmarkHundredThousand = quickSortTest(hundredThousandArray);
     hundredThousandQuickSort.add(benchmarkHundredThousand);

   }

   public static void runAllParallelQuickSortTests(){
     double benchmarkTen = parallelQuickSortTest(tenArray);
     tenThreadedQuickSort.add(benchmarkTen);
     double benchmarkHundred = parallelQuickSortTest(hundredArray);
     hundredThreadedQuickSort.add(benchmarkHundred);
     double benchmarkThousand = parallelQuickSortTest(thousandArray);
     thousandThreadedQuickSort.add(benchmarkThousand);
     double benchmarkTenThousand = parallelQuickSortTest(tenThousandArray);
     tenThousandThreadedQuickSort.add(benchmarkTenThousand);
     double benchmarkHundredThousand = parallelQuickSortTest(hundredThousandArray);
     hundredThousandThreadedQuickSort.add(benchmarkHundredThousand);

   }


//Single test for a merge sort.
   public static double mergeSortTest(int[] testArray){
     randomlyPopulateArr(testArray);
     MergeSort mergeSort= new MergeSort();
     double benchmark = mergeSort.runBenchMark(testArray);
     return benchmark;
   }

//single test for a multithreaded merge sort.
   public static double parallelMergeSortTest(int[] testArray){
     randomlyPopulateArr(testArray);
     ThreadedMergeSort threadedMergeSortTest = new ThreadedMergeSort();
     double benchmark = threadedMergeSortTest.runBenchMark(testArray);
     return benchmark;
   }

   //single test for  quicksort.
      public static double quickSortTest(int[] testArray){
        randomlyPopulateArr(testArray);
        QuickSort quickSortTest = new QuickSort();
        double benchmark = quickSortTest.runBenchMark(testArray);
        return benchmark;
      }

      //single test for  quicksort.
         public static double parallelQuickSortTest(int[] testArray){
           randomlyPopulateArr(testArray);
           ThreadedQuickSort tquickSortTest = new ThreadedQuickSort();
           double benchmark = tquickSortTest.runBenchMark(testArray);
           return benchmark;
         }

//populates
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

     double g = calculateAverage(tenThreadedMerge);
     double h = calculateAverage(hundredThreadedMerge);
     double i = calculateAverage(thousandThreadedMerge);
     double j = calculateAverage(tenthousandThreadedMerge);
     double k = calculateAverage(hundredThousandThreadedMerge);

     double l = calculateAverage(tenQuickSort);
     double m = calculateAverage(hundredQuickSort);
     double n = calculateAverage(thousandQuickSort);
     double o = calculateAverage(tenThousandQuickSort);
     double p = calculateAverage(hundredThousandQuickSort);

     double q = calculateAverage(tenThreadedQuickSort);
     double r = calculateAverage(hundredThreadedQuickSort);
     double s = calculateAverage(thousandThreadedQuickSort);
     double t = calculateAverage(tenThousandThreadedQuickSort);
     double u = calculateAverage(hundredThousandThreadedQuickSort);

     System.out.println("Total Trials: "+trials);
     System.out.println("|# elements | Algorithm | Average Time |");
     System.out.println("-----------------------------------");
     System.out.println("|    10     | MergeSort | "+a+"|");
     System.out.println("|    100    | MergeSort | "+b+"|");
     System.out.println("|    1000   | MergeSort | "+c+"|");
     System.out.println("|    10000  | MergeSort | "+d+"|");
     System.out.println("|    100000 | MergeSort | "+e+"|");
     System.out.println("-----------------------------------");
     System.out.println("|    10     | ThreadedMS| "+g+"|");
     System.out.println("|    100    | ThreadedMS| "+h+"|");
     System.out.println("|    1000   | ThreadedMS| "+i+"|");
     System.out.println("|    10000  | ThreadedMS| "+j+"|");
     System.out.println("|    100000 | ThreadedMS| "+k+"|");
     System.out.println("-----------------------------------");
     System.out.println("|    10     | QuickSort | "+l+"|");
     System.out.println("|    100    | QuickSort | "+m+"|");
     System.out.println("|    1000   | QuickSort | "+n+"|");
     System.out.println("|    10000  | QuickSort | "+o+"|");
     System.out.println("|    100000 | QuickSort | "+p+"|");
     System.out.println("-----------------------------------");
     System.out.println("|    10     | ThreadedQS| "+q+"|");
     System.out.println("|    100    | ThreadedQS| "+r+"|");
     System.out.println("|    1000   | ThreadedQS| "+s+"|");
     System.out.println("|    10000  | ThreadedQS| "+t+"|");
     System.out.println("|    100000 | ThreadedQS| "+u+"|");
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
