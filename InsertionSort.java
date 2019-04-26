public class InsertionSort implements AlgorithmInterface{

  @Override
  public double runBenchMark(int[] testArray){
    long startTime = System.nanoTime();
    sort(testArray);
    long endTime =System.nanoTime();
    long nano=1000000000;
    double benchmark =(endTime-startTime)*.000000009;
  //  System.out.println("BenchMark For Test of "+testArray.length+" elements using INSERTION SORT was "+benchmark+" Seconds.");
    return benchmark;
    
  }


//@param arr[]- array to be sorted
 void sort(int arr[])
 {
     int n = arr.length;
     for (int i=1; i<n; ++i)
     {
         int key = arr[i];
         int j = i-1;
         while (j>=0 && arr[j] > key)
         {
             arr[j+1] = arr[j];
             j = j-1;
         }
         arr[j+1] = key;
     }
 }

}
