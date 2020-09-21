/* Print Left View of a Binary Tree */
// Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.

// Code by @shivshar
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode () {}
    TreeNode (int val) {this.val = val;}
    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LeftViewOfBinaryTree {
    public void findBottomLeftValue(TreeNode root) {
        // You may assume the tree (i.e., the given root node) is not NULL.
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int n = q.size();
            for (int i=0; i<n; i++){
                TreeNode curr = q.poll();
                if (i==0) System.out.println(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right); 
            }
        }
    }
}

// Time Complexity : O(n)
// Space complexity : O(n)

// follow up : Question can also be asked to return the leftmost value in the last row of the tree