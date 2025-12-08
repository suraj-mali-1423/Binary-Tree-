package Interview_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

public class SymmetricTree {
    public static boolean SameTree ( Node p  , Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;
        return SameTree(p.left , q.left) && SameTree(p.right , q.right);
    }
    public static  Node InvertTree( Node root){
        if(root == null) return root;

        Node l = root.left;
        Node r = root.right;

        root.left = InvertTree(r);
        root.right = InvertTree(l);

        return  root;
    }
    public static boolean isSymmetric ( Node root){
        if(root == null) return true;

         root.left = InvertTree(root.left);

         return SameTree(root.left, root.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insertRoot(1);             // root = 1
        tree.insertLeft(tree.root, 2);
        tree.insertRight(tree.root, 2);

        tree.insertLeft(tree.root.left, 4);
        tree.insertRight(tree.root.left, 5);
        tree.insertLeft(tree.root.right, 5);
        tree.insertRight(tree.root.right, 4);



        System.out.println(isSymmetric(tree.root));

    }
}
