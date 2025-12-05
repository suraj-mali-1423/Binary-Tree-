package Tree_Question;

import binaryTree.BinaryTree;
import binaryTree.Node;

import static Tree_Question.HeightOfTree.heightOfTree;

public class BalancedTree {
    public static boolean Balance (Node root){
        if(root == null) return true;

        int lh = heightOfTree(root.left);
        if(root.left != null) lh++;
        int rh = heightOfTree(root.right);
        if(root.right != null) rh++;

        int d = lh - rh;
        if(d < 0 ) d = -d;
        if(d > 1) return false;

        return Balance(root.left) && Balance(root.right);
    }
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insertRoot(1);             // root = 1
        tree.insertLeft(tree.root, 2);
        tree.insertRight(tree.root.left, 5);
        System.out.println(Balance(tree.root));
    }
}
