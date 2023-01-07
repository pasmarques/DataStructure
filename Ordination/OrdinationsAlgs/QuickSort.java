package OrdinationsAlgs;

public class QuickSort {
  public static void main(String[] args) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);

    System.out.println("Original Array: ");
    System.out.println(java.util.Arrays.toString(list));

    System.out.println("\nQuick sort:");
    QuickSort.sort(list, 0, list.length - 1);
    System.out.println(java.util.Arrays.toString(list));
  }

  private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
    T pivot = array[right];
    int i = left;
    for (int j = left; j <= right - 1; j++) {
      if (array[j].compareTo(pivot) == 1) {// 1 pra ordenar crescente
        swap(array, i, j);
        i++;
      }
    }
    swap(array, i, right);
    return i;
  }

  public static <T extends Comparable<T>> void sort(T[] array, int left, int right) {
    if (left < right) {
      int tempPartition = partition(array, left, right);
      sort(array, left, tempPartition - 1);// quebrando os blocos
      sort(array, tempPartition + 1, right);
    }
  }

  private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
    T temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
