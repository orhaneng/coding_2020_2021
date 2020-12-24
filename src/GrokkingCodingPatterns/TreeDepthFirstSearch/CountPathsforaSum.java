package GrokkingCodingPatterns.TreeDepthFirstSearch;

//https://leetcode.com/problems/path-sum-iii/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsforaSum {

    /*
    Problem Statement #
    Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
    Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
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
//
//    public int pathSum(TreeNode root, int sum) {
//        if(root==null) return 0;
//        return findPath(root,sum)+findPath(root.left,sum)+findPath(root.right,sum);
//    }

//    public int findPath(TreeNode node, int sum){
//        int res=0;
//        if(node == null) return res;
//        if(sum==node.val){
//            res++;
//        }
//        res+= findPath(node.left,sum-node.val);
//        res+= findPath(node.right,sum-node.val);
//        return res;
//    }
//

    public int pathSum(TreeNode root, int s) {
        List<Integer> res = new ArrayList<>();
        return countPathsRecursive(root,s, res );

    }

    public static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null) return 0;

        currentPath.add(currentNode.val);

        int pathCount = 0, pathSum = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size()-1);

        while (pathIterator.hasPrevious()){
            pathSum +=pathIterator.previous();
            if(pathSum == S) pathCount++;
        }

        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);

        currentPath.remove(currentPath.size()-1);
        return pathCount;

    }

}
