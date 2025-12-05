package Tree_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public  static void Helper( Node root , List<String> ans  , String s){
          if(root == null) return;
          if(root.left == null && root.right == null){
                 s += root.val;
                 ans.add(s);
                 return;
          }

          Helper(root.left , ans , s+root.val+"->");
          Helper(root.right , ans , s+root.val+"->");
    }
    public static List<String> Path ( Node root){
        List<String> ans = new ArrayList<>();
        Helper(root , ans , "");

        return ans;
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

        List<String> Ans = Path(tree.root);

        for(int i = 0 ; i < Ans.size(); i++){
            System.out.print(Ans.get(i));
            System.out.println();
        }
    }
}
