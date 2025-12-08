package Interview_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

public class InvertBinaryTree {
    public static Node inverTree(Node root){
           if(root == null) return root;

           Node l = root.left;
           Node r= root.right;

           root.left = inverTree(r);
           root.right = inverTree(l);

           return root;
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

        System.out.println("Before Inversion : ");
        tree.preOrder(tree.root);


        inverTree(tree.root);

        System.out.println("After Inversion : ");
        tree.preOrder(tree.root);
    }
}
