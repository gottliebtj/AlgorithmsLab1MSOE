public class MergeSort implements AlgorithmInterface{

  @Override
  public double runBenchMark(int[] testArray){
    long startTime = System.nanoTime();
    sort(testArray,0,testArray.length-1);
    long endTime =System.nanoTime();
    double benchmark =(endTime-startTime)*.000000009;
  //  System.out.println("BenchMark For Test of "+testArray.length+" elements using MERGE SORT was "+benchmark+" Seconds.");
    return benchmark;
   }

//Breaks Down Array into Left and Right Sub arrays in order to merge s
//@param L-Left index
//@param R-Right index
//@param M-Middle
//@param arr[]- Start
//Implemented with the help of https://www.geeksforgeeks.org/merge-sort/
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays Left and Right */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Create 2 arrays from the original in order to merge things*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Function to be Benchmarked for Time Complexity Analysis.
    void sort(int arr[], int l, int r){
        if (l < r){
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
