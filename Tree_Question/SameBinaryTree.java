package Tree_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;
public class SameBinaryTree {
    public  static boolean isSame(Node p , Node q){
          if(p == null && q == null) return true;
          if(p == null || q == null) return false;

          if(p.val != q.val) return false;

          return isSame(p.left , q.left) && isSame(p.right , q.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insertRoot(1);             // root = 1
        tree.insertLeft(tree.root, 2);
        tree.insertRight(tree.root, 3);
        tree.insertLeft(tree.root.left, 4);

        BinaryTree tree1 = new BinaryTree();

        tree1.insertRoot(1);             // root = 1
        tree1.insertLeft(tree1.root, 2);
        tree1.insertRight(tree1.root, 3);

        System.out.print(isSame(tree.root , tree1.root));
    }
}
