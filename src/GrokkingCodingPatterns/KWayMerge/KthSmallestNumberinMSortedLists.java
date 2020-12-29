package GrokkingCodingPatterns.KWayMerge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumberinMSortedLists {


    /*
    Problem Statement #
Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.

Example 1:

Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
Output: 4
Explanation: The 5th smallest number among all the arrays is 4, this can be verified from the merged
list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
Example 2:

Input: L1=[5, 8, 9], L2=[1, 7], K=3
Output: 7
Explanation: The 3rd smallest number among all the arrays is 7.

    Time complexity #
    Since we’ll be going through at most ‘K’ elements among all the arrays, and we will remove/add one element in the heap in each step,
    the time complexity of the above algorithm will be O(K*logM)O(K∗logM) where ‘M’ is the total number of input arrays.

    Space complexity #
    The space complexity will be O(M)O(M) because, at any time, our min-heap will be storing one number from all the ‘M’ input arrays.


     */
    static class Node {
        int elementIndex;
        int arrayIndex;

        Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public static void main(String[] args) {

        Integer[] l1= new Integer[]{2, 6, 8};
        Integer[] l2= new Integer[]{3, 6, 7};
        Integer[] l3= new Integer[]{1, 3, 4};

        List<Integer[]> lists = new ArrayList<>(Arrays.asList(l1,l2,l3));

        System.out.println(mergeKLists(lists,5));
    }

    public static int mergeKLists(List<Integer[]> lists, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) ->
                lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i)!=null){
                minHeap.add(new Node(0,i));
            }
        }

        int numberCount =0, result = 0;

        while (!minHeap.isEmpty()){
            Node node = minHeap.poll();
            result = lists.get(node.arrayIndex)[node.elementIndex];
            numberCount++;
            if(numberCount==k){
                break;
            }
            node.elementIndex++;
            if(lists.get(node.arrayIndex).length > node.elementIndex)
                minHeap.add(node);
        }
        return result;
    }

}
