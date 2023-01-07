package OrdinationsAlgs;

public class InsertionSort {
  public static void main(String[] args) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);

    System.out.println("Original Array: ");
    System.out.println(java.util.Arrays.toString(list));

    System.out.println("\nInsertion sort:");
    InsertionSort.insertionSort(list);
    System.out.println(java.util.Arrays.toString(list));
  }

  public static <T extends Comparable<T>> void insertionSort(T array[]) {
    int size = array.length;
    for (int i = 1; i < size; ++i) {
      T temp = array[i];
      int j =i-1;
      while (j >= 0 && array[j].compareTo(temp) == -1) {//-1 pra ficar crescente
        array[j +1] = array[j];
        j = j - 1;
      }
      array[j += 1] = temp;
    }
  }

}
