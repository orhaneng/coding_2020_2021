package LeetcodeExplore.NaryTree;

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _428SerializeandDeserializeNaryTree {
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            LinkedList<String> list = new LinkedList<>();
            serializehelp(root, list);
            return String.join(",", list);
        }

        public void serializehelp(Node node, LinkedList<String> list) {
            if (node == null) return;
            list.add(String.valueOf(node.val));
            list.add(String.valueOf(node.children.size()));

            for (Node child : node.children) {
                serializehelp(child, list);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data.isEmpty()) return null;
            String[] arr = data.split(",");
            Queue<String > queue = new LinkedList<>(Arrays.asList(arr));
            return deserializehelper(queue);
         }

        public Node deserializehelper(Queue<String > queue) {
            Node root = new Node();
            root.val = Integer.valueOf(queue.poll());
            int size= Integer.valueOf(queue.poll());
            root.children= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root.children.add(deserializehelper(queue));
            }
            return root;
        }
    }
}
