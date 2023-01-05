package Stack.lib;

public class Stack<T> extends SinglyLinkedList<T> implements StackI<T> {
  private int maxSize;
  private int currentSize = 0;

  public Stack(int maxSize) {
    super();
    this.maxSize = maxSize;
  }

  public Stack() {
    this(-1);
  }

  public boolean isFull() {
    if (maxSize == -1)
      return false;
    return this.currentSize == maxSize;
  }

  @Override
  public void push(T newElement) {
    if (isFull())
      return;

    super.insertAtStart(newElement);
    this.currentSize++;
  }

  @Override
  public T pop() {
    if (isEmpty())
      return null;
    this.currentSize--;
    return super.removeFromStart().getData();
  }

  @Override
  public T peek() {
    Node<T> temp = super.removeFromStart();
    push(temp.getData());
    return temp.getData();
  }

  @Override
  public boolean contains(T ref) {
    return super.contains(ref);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}