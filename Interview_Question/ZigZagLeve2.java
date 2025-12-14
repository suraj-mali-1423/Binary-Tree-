package Interview_Question;
import Tree_Question.NthLevel;
import binaryTree.BinaryTree;
import binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

import static Tree_Question.LevelOrderTraversal.height;

public class ZigZagLeve2 {
//     Nth Level 1
    public static void NthLevel1 ( Node root , int i , int n , List<List<Integer>>ans ){
        if(root == null )return;

        if(n == 1){
            ans.get(i).add(root.val);
            return;
        }

        NthLevel1(root.right , i , n-1 , ans);
        NthLevel1(root.left , i , n-1, ans);
    }

//    Nth Level 2
    public static void NthLevel2 ( Node root , int i , int n , List<List<Integer>>ans){
            if(root == null )return;

            if(n == 1){
                 ans.get(i).add(root.val);
                 return;
            }

        NthLevel2(root.right , i , n-1 , ans);
        NthLevel2(root.left , i , n-1, ans);

    }
    public static List<List<Integer>>ZigZag(Node root ){
           int n = height(root);
        List<List<Integer>>ans = new ArrayList<>();
           for(int i = 1 ; i <= n ; i++ ){
                  ans.add(new ArrayList<>());
                  if(i % 2 != 0) NthLevel1(root , i-1, i , ans);
                  else  NthLevel2(root , i-1, i , ans);
           }

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
        int size = height(tree.root);

        List<List<Integer>> ans = ZigZag(tree.root);

        for(int i = 0 ; i < ans.size() ; i++){
            System.out.print(ans.get(i));
        }
    }
}
