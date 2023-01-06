package Queue.lib;

public class Queue<T> extends SinglyLinkedList<T> implements QueueI<T> {

  public Queue() {
    super();
  }

  @Override
  public void enQueue(T newElement) {
    super.insertAtEnd(newElement);
  }

  @Override
  public T deQueue() {
    return super.removeFromStart().getData();
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "Queue Is Empty";

    return "Queue: \n" + super.toString();
  }
}