/*Summary Of QuickSort Testing Algo:
*
*
*
*/
import java.util.Random;

public class QuickSortTester{

//-------RANDOM ARRAY GENERATOR HELPER---------//
  public static int[] randomArr(int n){
    int[] ans = new int[n];
    for(int i = 0; i<n;i++){
      ans[i] = new Random().nextInt(n);
    }
    return ans;
  }

//--------------MAIN METHOD--------------------//
  public static void main(String[] args) {
    double totalTime = 0;
    for(int i = 1000; i <= 10000; i+=100 ){
      for(int n = 0; n < 100;n++){
        int[] testArr = randomArr(i);
        double beginTime = System.nanoTime();
        QuickSort.qsort(testArr);
        double endTime = System.nanoTime();
        totalTime += endTime-beginTime;
      }
      System.out.println(i + " dim, " + totalTime/100);
      totalTime = 0;
    }

  }
}
