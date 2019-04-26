public class ThreadedQuickSort implements Runnable{
  int[] data;
  int start,end;

  public double runBenchMark(int[] testArray){
    long startTime = System.nanoTime();
    go(testArray);
    long endTime =System.nanoTime();
    double benchmark =(endTime-startTime)*.000000009;
  //  System.out.println("BenchMark For Test of "+testArray.length+" elements using MERGE SORT was "+benchmark+" Seconds.");
    return benchmark;
   }
//DEFAULT CONSTRUCTOR
        ThreadedQuickSort(){

        }
        ThreadedQuickSort(int[] data,int start,int end) {
            this.data=data;
            this.start=start;
            this.end=end;
        }
        public void run(){
            quickSort(this.data,this.start,this.end);
        }
        static void swap(int[] data, int i, int j){
            int tmp=data[i];
            data[i]=data[j];
            data[j]=tmp;
        }
        static int partition(int[] data, int start, int end) {
            if(start==end)
                return start;
            int pivot=data[end];
            int s=start-1;
            for(int i=start;i<end;i++)
                if(data[i]<=pivot)
                    swap(data,++s,i);
            swap(data,++s,end);
            return s;
        }
        static void quickSort(int[] data, int start, int end) {
            if (end<=start)
                return;
            int s=partition(data,start,end);
            quickSort(data,start,s-1);
            quickSort(data,s+1,end);
        }

        public static void go(int[] data) {

            int s=partition(data,0,data.length-1);
            Thread t1=new Thread(new ThreadedQuickSort(data,0,s-1));
            Thread t2=new Thread(new ThreadedQuickSort(data,s+1,data.length-1));
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
