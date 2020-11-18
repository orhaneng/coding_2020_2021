package LeetcodeExplore.BinaryTree;

public class _101SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {

        return help(root, root);
    }

    public static boolean help(TreeNode t1, TreeNode t2){
        if(t1 == null && t2== null) return true;
        if(t1 == null || t2 == null) return false;
        return t1 == t2 && help(t1.left,t2.right) && help(t1.right,t2.left);
    }
}
