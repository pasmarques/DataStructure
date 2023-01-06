package Tree.lib;

import Queue.lib.Queue;

public class Tree<T extends Comparable<T>> {
  private Node<T> root;

  public Tree() {
    this.root = null;
  }

  public Tree(T value) {
    insertBT(this.root, value);
  }

  public Node<T> getRoot() {
    return root;
  }
  public Node<T> insertRight(Node<T> currentNode, T value){
    if(currentNode == null) return new Node<T>(value);
      if(currentNode.getRight() == null)
        currentNode.setRight(new Node<T>(value));
      else
        return insertRight(currentNode.getRight(), value);

    return currentNode;
  }
  public Node<T> insertLeft(Node<T> currentNode, T value){
    if(currentNode == null) return new Node<T>(value);
      if(currentNode.getLeft() == null)
        currentNode.setLeft(new Node<T>(value));
      else
        return insertLeft(currentNode.getLeft(), value);
        
    return currentNode;
  }

  public void insertBT(Node<T> currentNode, T value) {
    if (this.root == null)
      root = new Node<T>(value);
    else if (currentNode.getKey().compareTo(value)==1) {
      if (currentNode.getLeft() == null) {
        Node<T> newNode = new Node<T>(value);
        currentNode.setLeft(newNode);
      } else {
        insertBT(currentNode.getLeft(), value);
      }
    } else {
      if (currentNode.getRight() == null) {
        Node<T> newNode = new Node<T>(value);
        currentNode.setRight(newNode);
      } else {
        insertBT(currentNode.getRight(), value);
      }
    }
  }

  public void printPreOrder(Node<T> currentNode) {
    System.out.println(" " + currentNode.getKey());

    if (currentNode.getLeft() != null) {
      printPreOrder(currentNode.getLeft());
    }

    if (currentNode.getRight() != null) {
      printPreOrder(currentNode.getRight());
    }
  }

  public void printInOrder(Node<T> currentNode) {
    if (currentNode.getLeft() != null) {
      printInOrder(currentNode.getLeft());
    }

    System.out.println(" " + currentNode.getKey());

    if (currentNode.getRight() != null) {
      printInOrder(currentNode.getRight());
    }
  }

  public void printPosOrder(Node<T> currentNode) {
    if (currentNode.getLeft() != null) {
      printPosOrder(currentNode.getLeft());
    }
    if (currentNode.getRight() != null) {
      printPosOrder(currentNode.getRight());
    }
    System.out.println(" " + currentNode.getKey());
  }

  protected Node<T> findNode(Node<T> currentNode, T value) {
    if (currentNode == null) {
      return null;
    }
    if (currentNode.getKey().compareTo(value) == 0) {
      return currentNode;
    }

    Node<T> nodeAux = new Node<T>();
    nodeAux = findNode(currentNode.getLeft(), value);
    if (nodeAux != null) {
      return nodeAux;
    }
    return findNode(currentNode.getRight(), value);
  }

  public boolean contains(Node<T> currentNode, T value) {
    return !(findNode(currentNode, value) == null);
  }

  private boolean hasTwoChild(Node<T> currentNode) {
    return (currentNode.getLeft() != null && currentNode.getRight() != null);
  }

  private boolean hasOneChild(Node<T> currentNode) {
    return (currentNode.getLeft() != null || currentNode.getRight() != null);
  }

  private boolean isLeaf(Node<T> currentNode) {
    return (currentNode.getLeft() == null && currentNode.getRight() == null);
  }

  public int size(Node<T> currentNode) {
    if (currentNode == null) {
      return 0;
    } else {
      return 1 + size(currentNode.getLeft()) + size(currentNode.getRight());
    }
  }

  private T valueSubstitute(Node<T> currentNode) {
    if (currentNode.getRight() != null) {
      return (valueSubstitute(currentNode.getRight()));
    }
    return currentNode.getKey();
  }

  public void removeBT(T value) {
    removeNode(this.root, value);
  }

  private Node<T> removeNode(Node<T> currentNode, T value) {
    if (contains(currentNode, value)) {
      if (currentNode.getKey().compareTo(value) == 1) {
        currentNode.setLeft(removeNode(currentNode.getLeft(), value));
      } else if (currentNode.getKey().compareTo(value) == -1) {
        currentNode.setRight(removeNode(currentNode.getRight(), value));
      } else {
        if (isLeaf(currentNode)) {
          currentNode = null;
          return currentNode;
        } else if (hasTwoChild(currentNode)) {
          T substituteValue = valueSubstitute(currentNode.getLeft());
          currentNode.setKey(substituteValue);
          currentNode.setLeft(removeNode(currentNode.getLeft(), substituteValue));
        } else if (hasOneChild(currentNode)) {
          if (currentNode.getLeft() == null) {
            return currentNode.getRight();
          } else if (currentNode.getRight() == null) {
            return currentNode.getLeft();
          }
        }
      }
      return currentNode;
    }
    return null;
  }

  public int findHeight(Node<T> currentNode){
    if(currentNode==null){
      return -1;
    }
    
     int leftHeight=0;
     int rightHeight=0;

     if(root.getLeft()!=null){
      leftHeight=findHeight(currentNode.getLeft())+1;
     }
     if(root.getRight()!=null){
      rightHeight=findHeight(currentNode.getRight())+1;
     }
     return Math.max(leftHeight,rightHeight);
  }
  private boolean isMaxHeap(Node<T> currentNode, int numberOfNodes, int index){

    if(currentNode==null){
      return true;
    }
    if(index>=numberOfNodes){//garante que a arvore esteja completa
      return false;
    }
    
    if(currentNode.getLeft()!=null&&currentNode.getKey().compareTo(currentNode.getLeft().getKey())==-1||currentNode.getRight()!=null&&currentNode.getKey().compareTo(currentNode.getRight().getKey())==-1){
      return false;
    }
    return isMaxHeap(currentNode.getLeft(), numberOfNodes, index*2+1)&& isMaxHeap(currentNode.getRight(), numberOfNodes, index*2+2);
  }

  private boolean isMinHeap(Node<T> currentNode, int numberOfNodes, int index){
    if(index>=numberOfNodes){//garante que a arvore esteja completa
      return false;
    }
    
    if(currentNode.getLeft()!=null&&currentNode.getKey().compareTo(currentNode.getLeft().getKey())==1||currentNode.getRight()!=null&&currentNode.getKey().compareTo(currentNode.getRight().getKey())==1){
      return false;
    }
    return isMinHeap(currentNode.getLeft(), numberOfNodes, index*2+1)&& isMinHeap(currentNode.getRight(), numberOfNodes, index*2+2);
  }

  private int isHeap(Node <T> currentNode){

    int numberOfNodes=size(currentNode);
    int index=0;
    if(isMaxHeap(currentNode,numberOfNodes,index)){
      return 1;
    }
    if(isMinHeap(currentNode,numberOfNodes,index)){
      return -1;
    }
    return 0;//não é heap
  }

  public int isHeap(){
    return isHeap(this.root);
  }
 
}
