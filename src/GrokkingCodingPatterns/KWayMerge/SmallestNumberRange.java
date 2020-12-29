package GrokkingCodingPatterns.KWayMerge;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestNumberRange {


    static class Node {
        int elementIndex;
        int arrayIndex;

        Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(7);
        l2.add(10);
        l2.add(16);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(12);
        List<List<Integer>> res = new ArrayList<>(Arrays.asList(l1,l2,l3));

        Arrays.stream(smallestRange(res)).forEach(System.out::println);

    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>
                ((n1, n2) -> nums.get(n1.arrayIndex).get(n1.elementIndex) - nums.get(n2.arrayIndex).get(n2.elementIndex));

        int rangestart = 0, rangeend = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != null) {
                minHeap.add(new Node(0, i));
                currentMaxNumber = Math.max(currentMaxNumber, nums.get(i).get(0));
            }
        }

        while (minHeap.size() == nums.size()) {
            Node node = minHeap.poll();
            if (rangeend - rangestart > currentMaxNumber - nums.get(node.arrayIndex).get(node.elementIndex)) {
                rangestart = nums.get(node.arrayIndex).get(node.elementIndex);
                rangeend = currentMaxNumber;
            }
            node.elementIndex++;

            if(nums.get(node.arrayIndex).size()> node.elementIndex){
                minHeap.add(node);
                currentMaxNumber = Math.max(currentMaxNumber, nums.get(node.arrayIndex).get(node.elementIndex));
            }
        }
        return new int[]{rangestart,rangeend};
    }
}
