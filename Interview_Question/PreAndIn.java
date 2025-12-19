package Interview_Question;
import Tree_Question.NthLevel;
import binaryTree.BinaryTree;
import binaryTree.Node;

public class PreAndIn {

    public static Node Helper(int [] preorder , int prelo , int prehi, int [] inorder , int inlo , int inhi){
          if(prelo > prehi) return null;

          Node root = new Node(preorder[prelo]);
          int i = inlo;
          while(inorder[i] != preorder[prelo]) i++;

          int leftsize = i - inlo;
          root.left = Helper(preorder , prelo+1 , prelo+leftsize , inorder , inlo , i-1);
          root.right = Helper(preorder , prelo+leftsize+1 , prehi , inorder , i+1 , inhi);

          return root;
    }

    public static Node buildTree ( int [] preorder , int [] inorder) {
        int n = preorder.length;

        return Helper(preorder , 0 , n-1, inorder , 0 , n-1);
    }

    public  static  void Display ( Node root ){
           if(root == null) return ;
        System.out.print(root.val + " ");

        Display(root.left);
        Display(root.right);
    }
    public static void main(String[] args) {
             int [] preorder = {1, 2, 4, 5, 3, 6};
             int [] inorder  = {4, 2, 5, 1, 3, 6};

             Node Ans = buildTree(preorder , inorder);
             Display(Ans);
    }
}
