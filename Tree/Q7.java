package Tree;
public class Q7 {

  public static void main (String args[]){
    String[]arrayOfStrings = {"Pedro", "Vitor", "Mariana", "Flavia", "Luiz"};
    Integer[]arrayOfInt = {10,100,50,1,7};

        Q7.heapify(arrayOfStrings,1);
        System.out.println(java.util.Arrays.toString(arrayOfStrings));//função pra printar vetor do java
        Q7.heapify(arrayOfInt,2);
        System.out.println(java.util.Arrays.toString(arrayOfInt));//função pra printar vetor do java

  }
  
  public static <T extends Comparable<T>> void heapify(T[] array, int option) {

    if(option==1){
      for (int i = array.length/ 2 - 1; i >= 0; i--)
        buildMinHeap(array, array.length, i);

      for (int i = array.length - 1; i >= 0; i--) {
        swap(array,0,i);
        buildMinHeap(array, i, 0);
    }
    }
    else if(option==2){
      for (int i = array.length / 2 - 1; i >= 0; i--)
        buildMaxHeap(array, array.length, i);

    for (int i = array.length - 1; i >= 0; i--) {
        swap(array,0,i);
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
      swap(array,i,root);
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
      swap(array,i,root);
      buildMinHeap(array, size, root);
    }
  }
  private static <T extends Comparable<T>> void swap(T[]array, int index1, int index2){
    T temp = array[index1];
      array[index1] = array[index2];
      array[index2] = temp;
  }

}