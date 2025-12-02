package Tree_Question;
import binaryTree.BinaryTree;
import binaryTree.Node;

import javax.swing.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public static int height(Node root){
           if(root == null) return 0;
           return 1 + Math.max(height(root.left) , height(root.right));
    }

    public static void NthLevel(Node root , int i , int n , List<List<Integer>> ans){
          if(root == null) return;
          if(n == 1) {
              ans.get(i).add(root.val);
              return;
          }
          NthLevel(root.left , i , n-1 , ans);
          NthLevel(root.right , i , n-1 , ans);
    }

    public static void Print(List<List<Integer>> ans){
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();  // next line after each level
        }
    }


    public static List<List<Integer>> LevelTraversal(Node root){
          List<List<Integer>> ans = new ArrayList<>();
           int n = height(root);

           if(root == null) return ans;
           for(int i = 1 ; i <= n; i++){
                 ans.add(new ArrayList<>());
                 NthLevel(root , i-1 , i , ans);
           }
           Print(ans);
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

         LevelTraversal(tree.root);

    }
}
