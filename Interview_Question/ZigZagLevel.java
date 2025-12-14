package Interview_Question;
import Tree_Question.NthLevel;
import binaryTree.BinaryTree;
import binaryTree.Node;
public class ZigZagLevel {
    public static void NthLevel(Node root , int n ){
        if(root == null) return;
           if(n == 1){
               System.out.print(root.val+" ");
               return ;
           }

        NthLevel(root.left , n-1);
        NthLevel(root.right  , n-1);
    }

    public static void NthLevel2(Node root , int n){
        if(root == null) return;
        if(n == 1){
            System.out.print(root.val+" ");
            return ;
        }
        NthLevel2(root.right  , n-1);
        NthLevel2(root.left , n-1);
    }
    public static int  height(Node root){
           if(root == null) return 0;

           return 1 + Math.max(height(root.left) , height(root.right));
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
        System.out.println(size);
         for(int i = 1; i <= size ; i++){
             if(i % 2 != 0) NthLevel(tree.root , i);
             else NthLevel2(tree.root , i);

             System.out.println();
         }


    }
}
