import java.util.Arrays;

public  class ThreadedMergeSort implements AlgorithmInterface{

  @Override
  public double runBenchMark(int[] testArray){
    long startTime = System.nanoTime();
    parallelMergeSort(testArray);
    long endTime =System.nanoTime();
    double benchmark =(endTime-startTime)*.000000009;
  //  System.out.println("BenchMark For Test of "+testArray.length+" elements using MERGE SORT was "+benchmark+" Seconds.");
    return benchmark;
   }



   public static void parallelMergeSort(int[] a) {
     // int cores = Runtime.getRuntime().availableProcessors();
     int cores = 2;
     parallelMergeSort(a, cores);
    }

    private static class Sorter implements Runnable {
    	private int[] a;
    	private int threadCount;

    	public Sorter(int[] a, int threadCount) {
    		this.a = a;
    		this.threadCount = threadCount;
    	}

    	public void run() {
    	 parallelMergeSort(a, threadCount);
    	}
    }


 public static void parallelMergeSort(int[] a, int threadCount) {
   if (threadCount <= 1) {
     mergeSort(a);
   } else if (a.length >= 2) {
     // split array in half
     int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
     int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

     // sort the halves
     // mergeSort(left);
     // mergeSort(right);
     Thread lThread = new Thread(new  Sorter(left,  threadCount / 2));
     Thread rThread = new Thread(new Sorter(right, threadCount / 2));
     //calls the run method
     lThread.start();
     //calls the run method
     rThread.start();

     try {
       lThread.join();
       rThread.join();
     } catch (InterruptedException ie) {
       throw new RuntimeException("dam");
     }

     // merge them back together
     merge(left, right, a);
   }
 }


 // Combines the contents of sorted left/right arrays into output array a.
	// Assumes that left.length + right.length == a.length.
	public static void merge(int[] left, int[] right, int[] a) {
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
				a[i] = left[i1];
				i1++;
			} else {
				a[i] = right[i2];
				i2++;
			}
		}
	}

  public static void mergeSort(int[] a) {
  		if (a.length >= 2) {
  			// split array in half
  			int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
  			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

  			// sort the halves
  			mergeSort(left);
  			mergeSort(right);

  			// merge them back together
  			merge(left, right, a);
  		}
  	}






}
