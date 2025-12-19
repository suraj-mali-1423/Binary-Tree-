package Interview_Question;
import Tree_Question.NthLevel;
import binaryTree.BinaryTree;
import binaryTree.Node;

public class PathSum1 {
    public static boolean Path(Node root , int target){
            if(root == null) return false;
            if(root != null && root.left == null && root.right == null){
                  return target == root.val ? true : false;
            }

           return Path(root.left, target - root.val) || Path(root.right , target - root.val);
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

        System.out.println(Path(tree.root , 10));

    }
}
