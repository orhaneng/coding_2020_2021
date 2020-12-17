package GrokkingCodingPatterns.SlidingWindow;

public class SmallestSubarraywithagivensum {
    public static void main(String[] args) {

        System.out.println(smallestSubarraywithagivensum(new int[]{3, 4, 1, 1, 6}, 8));

    }

    public static int smallestSubarraywithagivensum(int[] arr, int k) {
        /*
            The time complexity of the above algorithm will be O(N).
            The outer for loop runs for all elements and the inner while loop processes each element only once,
            therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).
            Space Complexity #
            The algorithm runs in constant space O(1).
         */
        int smallest = Integer.MAX_VALUE;
        int size = 0;
        int sum = 0;
        int begin = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            size++;
            while (sum >= k) {
                smallest = Math.min(smallest, size);
                sum -= arr[begin++];
                size--;
            }
        }
        return smallest == Integer.MAX_VALUE ? 0 : smallest;
    }
}
