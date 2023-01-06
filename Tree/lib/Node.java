package Tree.lib;

public class Node<T extends Comparable<T>> {
  private T key;
  private Node<T> right;
  private Node<T> left;

  public Node(T key) {
    this.key = key;
    this.right = null;
    this.left = null;
  }

  public Node() {
    this.right = null;
    this.left = null;
  }

  public T getKey() {
    return key;
  }

  public Node<T> getRight() {
    return right;
  }

  public Node<T> getLeft() {
    return left;
  }

  protected void setKey(T value) {
    this.key = value;
  }

  protected void setRight(Node<T> nodeReference) {
    this.right = nodeReference;
  }

  protected void setLeft(Node<T> nodeReference) {
    this.left = nodeReference;
  }

  protected void setRight(Node<T> nodeReference, T value) {
    this.right = nodeReference;
    this.right.setKey(value);
  }

  protected void setLeft(Node<T> nodeReference, T value) {
    this.left = nodeReference;
    this.left.setKey(value);
  }

  protected Node<T> createNode() {
    Node<T> tempNode = new Node<T>();
    return tempNode;
  }

}
