package Tree;

import Tree.lib.Tree;

public class Q6 {
    public static void main(String args[]){
     //a função isHeap está no arquivo da Tree 
     Tree<Integer> Tree = new Tree <Integer>();
     Tree.insertBT(Tree.getRoot(), 30);
     Tree.insertBT(Tree.getRoot(), 20);
     Tree.insertBT(Tree.getRoot(), 50);
     System.out.println(Tree.isHeap(Tree.getRoot()));
    }
}
