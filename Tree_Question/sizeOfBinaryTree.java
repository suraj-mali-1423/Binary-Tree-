package Tree_Question;

import binaryTree.BinaryTree;
import binaryTree.Node;

public class sizeOfBinaryTree {
    static int Count = 0;
    public static int sizeOfTree(Node root ){
         if(root == null ) return 0;
         int l = sizeOfTree(root.left);
         int r = sizeOfTree(root.right);

         return l + r + 1;
    }
    public static void SIZEOFTREE(Node root){
         if(root == null) return;
         Count++;
         SIZEOFTREE(root.left);
         SIZEOFTREE(root.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insertRoot(1);             // root = 1
        tree.insertLeft(tree.root, 2);
        tree.insertRight(tree.root, 3);
        tree.insertLeft(tree.root.left, 4);
        tree.insertRight(tree.root.left, 5);
        tree.insertLeft(tree.root.right, 6);
        tree.insertRight(tree.root.right, 7);
        tree.insertLeft(tree.root.left.left , 8);
        tree.insertRight(tree.root.left.left , 9);


    }
}
