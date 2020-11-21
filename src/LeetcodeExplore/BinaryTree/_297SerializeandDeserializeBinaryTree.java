package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeandDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        _297SerializeandDeserializeBinaryTree ser = new _297SerializeandDeserializeBinaryTree();
        _297SerializeandDeserializeBinaryTree deser = new _297SerializeandDeserializeBinaryTree();
        TreeNode ans = deser.deserialize(ser.serialize(root));
    }

    public static String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    // Generate preorder string
    private static StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    public static TreeNode deserialize(String data) {
        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    // Use queue to simplify position move
    private static TreeNode deserial(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}
