package Tree;
import Tree.lib.Tree;
public class Q3{
    public static void main(String args[]){
        //a fun��o findHeight est� no arquivo da Tree 
        Tree<Integer> Tree = new Tree <Integer>();
        Tree.insertBT(Tree.getRoot(), 30);
        Tree.insertBT(Tree.getRoot(), 20);
        Tree.insertBT(Tree.getRoot(), 50);
        System.out.println(Tree.findHeight(Tree.getRoot()));

    }
}
