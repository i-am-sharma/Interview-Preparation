// Given a Binary Tree, we need to print the bottom view from left to right.

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

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public static <U, V> Pair<U, V> of(U a, V b) {
        return new Pair<>(a, b);
    }
}



 class TopViewOfBinaryTree {

    public static void printTopView (TreeNode root, HashMap<Integer, Pair <Integer, Integer>> map, int dist, int height){
        if (root == null) return;

        if (!map.containsKey(dist) || height <= map.get(dist).second){
            map.put (dist, Pair.of(root.val, height));
        }

        printTopView(root.left, map, dist-1, height+1);
        printTopView(root.right, map, dist+1, height+1);
        
    }

    public static void printTop (TreeNode root) {
        HashMap<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        printTopView (root, map, 0, 0);

        for (Pair <Integer, Integer> itr : map.values()){
            System.out.println(itr.first);
        }
    }

    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		printTop (root);
	}
}

// Time Complexity : O(n)
// what if we want the output in order (left -> right) ?
// then we need to use TreeMap instead of Hashmap. TreeMap sorts the key when added - O(nlogn) time complexity