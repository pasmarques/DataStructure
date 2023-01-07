package OrdinationsAlgs;

public class HeapSort {
  public static void main(String args[]) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);

    HeapSort.heapify(list, 2);//1 ordenadecrescente, 2 ordena crescente por nome
    System.out.println(java.util.Arrays.toString(list));

  }
  public static <T extends Comparable<T>> void heapify(T[] array, int option) {
    if (option == 1) {
      for (int i = array.length / 2 - 1; i >= 0; i--)
        buildMinHeap(array, array.length, i);

      for (int i = array.length - 1; i >= 0; i--) {
        swap(array, 0, i);
        buildMinHeap(array, i, 0);
      }
    } else if (option == 2) {
      for (int i = array.length / 2 - 1; i >= 0; i--)
        buildMaxHeap(array, array.length, i);

      for (int i = array.length - 1; i >= 0; i--) {
        swap(array, 0, i);
        buildMaxHeap(array, i, 0);
      }
    }
  }
  
  public static <T extends Comparable<T>> void buildMaxHeap(T[] array, int size, int i) {
    int root = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && array[left].compareTo(array[root]) < 0)
      root = left;

    if (right < size && array[right].compareTo(array[root]) < 0)
      root = right;

    if (root != i) {
      swap(array, i, root);
      buildMaxHeap(array, size, root);
    }
  }

  public static <T extends Comparable<T>> void buildMinHeap(T[] array, int size, int i) {
    int root = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && array[left].compareTo(array[root]) > 0)
      root = left;

    if (right < size && array[right].compareTo(array[root]) > 0)
      root = right;

    if (root != i) {
      swap(array, i, root);
      buildMinHeap(array, size, root);
    }
  }

  private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
    T temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}
