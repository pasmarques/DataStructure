package OrdinationsAlgs;

public class SelectionSort {
  public static void main(String[] args) {
    Person[] list = new Person[5];
    list[0] = new Person("pedro", "202121143", 8.5f);
    list[1] = new Person("flavia", "202111000", 7.5f);
    list[2] = new Person("bruno", "202121120", 9.5f);
    list[3] = new Person("anna", "202121120", 9.5f);
    list[4] = new Person("ana", "202121120", 9.5f);

    String[] arrayOfStrings = { "Pedro", "Vitor", "Mariana", "Flavia", "Luiz" };

    System.out.println("Original Array: ");
    System.out.println(java.util.Arrays.toString(list));

    selectionSort(arrayOfStrings);
    System.out.println("\nSelection sort:");
    System.out.println(java.util.Arrays.toString(list));
  
  }

  public static <T extends Comparable<T>> void selectionSort(T[] array) {
    int size = array.length;
    for (int index = 0; index < size - 1; index++) {
      int smallerIndex = index;
      for (int i= index+1; i < size; i++) {
        if (array[i].compareTo(array[smallerIndex]) == 1) {
          smallerIndex = i;
        }
      }
      T aux = array[smallerIndex];
      array[smallerIndex] = array[index];
      array[index] = aux;
    }
  }
  
  public static <T> void printArray(T[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
}
