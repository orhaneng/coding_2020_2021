package LeetcodeExplore.NaryTree;

public class _559MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max =0;
        for(Node node : root.children){
            max = Math.max(maxDepth(node),max);
        }
        return max+1;
    }
}
