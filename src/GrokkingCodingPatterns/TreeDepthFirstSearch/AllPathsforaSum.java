package GrokkingCodingPatterns.TreeDepthFirstSearch;

//https://leetcode.com/problems/path-sum-ii/


import java.util.ArrayList;
import java.util.List;

public class AllPathsforaSum {

    /*
    Problem Statement #
Given a binary tree and a number ‘S’,
`find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.


Time complexity #
The time complexity of the above algorithm is O(N^2)O(N
​2
​​ ), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once (which will take O(N)O(N)), and for every leaf node we might have to store its path which will take O(N)O(N).

We can calculate a tighter time complexity of O(NlogN)O(NlogN) from the space complexity discussion below.

Space complexity #
If we ignore the space required for the allPaths list, the space complexity of the above algorithm will be O(N)O(N) in the worst case. This space will be used to store the recursion stack. The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

How can we estimate the space used for the allPaths array? Take the example of the following balanced tree:



  1


leetcode explanation
Time Complexity: O(N^2)O(N
2
 ) where NN are the number of nodes in a tree. In the worst case, we could have a complete binary
  tree and if that is the case, then there would be N/2N/2 leafs. For every leaf, we perform a potential O(N)O(N)
  operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. Hence, the complexity
   in the worst case could be O(N^2)O(N
2
 ).

     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)  return res;
        helper(res, root, sum, new ArrayList<>());
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode node, int sum, List<Integer> sublist) {
        if(node==null) return;
        sublist.add(node.val);

        if(node.left==null && node.right ==null && sum - node.val == 0){
            res.add(new ArrayList<>(sublist));
        }

        helper(res, node.left, sum-node.val, sublist );
        helper(res, node.right, sum-node.val, sublist );

        sublist.remove(sublist.size()-1);
    }
}
