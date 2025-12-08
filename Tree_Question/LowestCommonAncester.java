package Tree_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

public class LowestCommonAncester {
    public  static Node lowestcommon ( Node root , Node p , Node q){
            if(root == null || root == p | root == q) return root;

            Node leftLCA = lowestcommon(root.left , p , q);
            Node rightLCA = lowestcommon(root.right , p , q);

            if(rightLCA != null && leftLCA != null) return root;
            if(leftLCA == null) return rightLCA;
            if(rightLCA == null) return leftLCA;

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

        Node p = tree.root.left.left ;
        Node q = tree.root.left.right;

        Node Ans = lowestcommon(tree.root ,p ,q );
        if(Ans != null )System.out.println(Ans.val);
    }
}
