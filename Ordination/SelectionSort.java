public class SelectionSort {
  public static void main(String[] args) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);

    System.out.println("Original Array: ");
    printArray(list);

    selectionSort(list);
    System.out.println("\nSelection descending sort:");
    printArray(list);

    Integer[] list1 = {34, 17, 23, 35, 45, 9, 1};
    System.out.println("Original Array: ");
    printArray(list1);

    selectionSort(list1);
    System.out.println("\nSelection sort:");
    printArray(list1);
  }

  // selection sort
  public static <T extends Comparable<T>> void selectionSort(T[] array) {
    int size = array.length;
    for (int index = 0; index < size - 1; index++) {
      int smallerIndex = index;
      for (int i = 0; i < size; i++) {
        if (array[i].compareTo(array[smallerIndex]) == -1) {
          smallerIndex = i;
        }
      }
      if (array[index].compareTo(array[smallerIndex]) == -1) {
        T aux = array[smallerIndex];
        array[smallerIndex] = array[index];
        array[index] = aux;
      }
    }
  }

  public static <T> void printArray(T[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
}
