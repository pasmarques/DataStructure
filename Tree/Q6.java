package Tree;

import Tree.lib.Tree;

public class Q6 {
  public static void main(String args[]) {
    // a função isHeap está no arquivo da Tree
    Tree<Integer> Tree = new Tree<Integer>();
    Tree.insertBT(Tree.getRoot(), 1);
    Tree.insertRight(Tree.getRoot(), 0);
    Tree.insertLeft(Tree.getRoot(), -1);

    System.out.println(Tree.getRoot().getKey());
    System.out.println(Tree.getRoot().getLeft().getKey());
    System.out.println(Tree.getRoot().getRight().getKey());

    System.out.println(Tree.isHeap());
  }
}
