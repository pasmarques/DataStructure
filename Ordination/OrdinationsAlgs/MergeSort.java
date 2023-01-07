package OrdinationsAlgs;

import javax.lang.model.util.ElementScanner14;

public class MergeSort {
  public static void main(String[] args) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);
    Person[] list2 = new Person[5];

    System.out.println("Original Array: ");
    System.out.println(java.util.Arrays.toString(list));

    System.out.println("\nMerge sort:");
    MergeSort.mergeSort(list, list2,0, list.length - 1);
    System.out.println(java.util.Arrays.toString(list));
  }

  private static <T extends Comparable<T>> void mergeSort(T[] array1, T[] array2, int init, int end) {
    if(init<end)
    {
      int middle =(init+end)/2;
      mergeSort(array1, array2, init, middle);
      mergeSort(array1, array2,middle+1, end);
      intercalate(array1, array2, init,middle,end);
    }
  }

  public static <T extends Comparable<T>> void intercalate(T[] array1, T[] array2,int init, int middle, int end) {
   for(int k = init;k<=end;k++){
      array2[k]=array1[k];
   }
   int i= init;
   int j = middle +1;
   for(int k =init;k<=end;k++){
      if(i>middle){
        array1[k]=array2[j++];
      }
      else if(j>end){
        array1[k]=array2[i++];
      }
      else if(array2[i].compareTo(array2[j])==1){//1 pra ficar crescente;
        array1[k]=array2[i++];
      }
      else 
      {
        array1[k]=array2[j++];
      }
   }
  }

}
