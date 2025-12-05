package Tree_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

import static Tree_Question.HeightOfTree.heightOfTree;

public class DiameterOfBinaryTre {
    public static  int Diameter(Node root){
            if(root == null || (root.left == null && root.right == null)) return 0;
            int leftAns = Diameter(root.left);
            int rightAns = Diameter(root.right);

            int mid = heightOfTree(root.left) + heightOfTree(root.right);
            if(root.left != null) mid++;
            if(root.right != null) mid++;

        return Math.max(leftAns , Math.max(rightAns , mid));
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

        System.out.println(Diameter(tree.root));
    }
}
