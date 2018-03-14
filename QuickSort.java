//Fiona Cai
//APCS2 pd1
//HW18 -- QuickSort
//2018-03-13

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Sorts an array by choosing an element as a pivot and partitions the given array around the chosen pivot.
 * Then recursively sort on the two subsequent partitions of the array in a divide and conquer manner. For each run,
 * the element at the pivot is plaed at its correct position in the sorted version of the array.
 *
 * 2a. Worst pivot choice and associated runtime:
 * If the pivot chosen each time is the smallest or largest element
 * Runtime O(n^2): --> for each call, you split the array into 0 and n-1 sizes
 * 2b. Best pivot choice and associated runtime:
 * If the pivot chosen each time is the value that divides partitions the array into two equal pieces
 * Runtime: O(nlogn) --> for each call, you are cutting the array into halves.
 * 3. Approach to handling duplicate values in array:
 * I think the <= in parition() takes care of this? Not too sure...
 *****************************************************/
import java.util.Random;

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  //partition helper
  public static int partition( int[] arr, int left, int right, int pvtPos)
    {
      int pvtVal = arr[pvtPos]; //store pivot value, where you will split the array

      swap( pvtPos, right, arr); //move pivot to the last element
      int storPos = left;

      for( int i = left; i < right; i++ ) { //loop through while comparing to pivot value
  	    if ( arr[i] <= pvtVal) {
          swap( i, storPos, arr ); // swap if less than pivot
          storPos++;} //increase stor pos is less than pivot
      }
      swap(storPos,right,arr); // swap back pivot to its sorted array position

      return storPos; // return final resting position of pivot value
    }

  //quicksort helper method
  public static void qsortH(int[] arr, int left, int right){
    if (left < right){
      //int randPvt = left + new Random().nextInt(right-left+1); //generate random pivot point
      int pvtPos = partition(arr, left, right, right); // partition array using the random pivot
      qsortH(arr, left, pvtPos-1); //recursively partition elements to the left of the resting place of the random pivot
      qsortH(arr, pvtPos+1, right); //recursively partition elemnts to the right of the resting place of the random pivot
    }

  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
    qsortH(d, 0, d.length-1); //qsortH saves the day! Sorts d, left = 0, right = length-1
  }

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);

  }//end main

}//end class QuickSort
