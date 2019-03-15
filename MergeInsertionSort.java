public class MergeInsertionSort implements AlgorithmInterface{

  @Override
  public double runBenchMark(int[] testArray){
    long startTime = System.nanoTime();
    mergeInsertionSort(testArray,0,testArray.length-1,10);
    long endTime =System.nanoTime();
    double benchmark =(endTime-startTime)*.000000009;
    //System.out.println("BenchMark For Test of "+testArray.length+" elements using MERGE INSERTION SORT was "+benchmark+" Seconds.");
    return benchmark;
  }

  public void mergeInsertionSort(int array[], int min, int max, int threshold){
      // prerequisite
      if ( (max - min + 1) <= threshold ){
          insertionSort(array, min, max);
      }else
      {
          // get the middle point
          int mid = (max+min) / 2;
          // apply merge sort to both parts of this
          mergeInsertionSort(array, min, mid, threshold);
          mergeInsertionSort(array, mid+1, max, threshold);

          // and finally merge all that sorted stuff
          merge(array, min, max, mid) ;
      }
  }

  public void insertionSort(int array[], int min, int max){
    int key ;
    // we loop through all elements in the original array from the min + 1 element
    for (int j = min + 1 ; j <= max ; j++)
    {
        // store the current element as the key
        key = array[j] ;
        // get the element just before the current element
        int i = j - 1 ;
        // loop through all elements from the key to the min element
        // check if the current element is smaller than the key
        while (i >= min && array[i] > key)
        {
            // we move the current element backward
            array[i+1] = array[i] ;
            i-- ;
        }
        // we finally move the key
        array[i+1] = key ;
    }
}

  void merge(int array[], int min, int max, int mid){
      int firstIndex = min;
      int secondIndex = mid + 1;
      int[] tempArray = new int [max + 1];


      // While there are elements in the left or right runs
      for (int index = min; index <= max; index++) {
          // If left run head exists and is <= existing right run head.
          if (firstIndex <= mid && (secondIndex > max || array[firstIndex] <= array[secondIndex]))
          {
              tempArray[index] = array[firstIndex];
              firstIndex = firstIndex + 1;
          }

          else
          {
              tempArray[index] = array[secondIndex];
              secondIndex = secondIndex + 1;
          }
        }
      // transfer to the initial array
      for (int index = min ; index <= max ; index++)
          array[index] = tempArray[index];
  }
}
