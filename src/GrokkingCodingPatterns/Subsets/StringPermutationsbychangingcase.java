package GrokkingCodingPatterns.Subsets;

//https://leetcode.com/problems/letter-case-permutation/discuss/115508/Java-solution-using-recursion

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsbychangingcase {

    public static void main(String[] args) {

    }

    /*
    Time complexity #
        Since we can have 2^N2
        ​N
        ​​  permutations at the most and while processing each permutation
        we convert it into a character array, the overall time complexity of the algorithm will be O(N*2^N)O(N∗2
        ​N
        ​​ ).

        Space complexity #
        All the additional space used by our algorithm is for the output list.
        Since we can have a total of O(2^N)O(2
        ​N
        ​​ ) permutations, the space complexity of our algorithm is O(N*2^N)O(N∗2
        ​N
        ​​ ).

     */
    public List<String> letterCasePermutation(String S) {
        List<String> permuts = new ArrayList<>();

        if (S == null) return permuts;
        permuts.add(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                int n = permuts.size();
                for (int j = 0; j < n; j++) {
                    char[] chr = permuts.get(j).toCharArray();
                    if (Character.isLowerCase(chr[i])) {
                        chr[i] = Character.toUpperCase(chr[i]);
                    } else if (Character.isUpperCase(chr[i])) {
                        chr[i] = Character.toLowerCase(chr[i]);
                    }
                    permuts.add(String.valueOf(chr));
                }
            }
        }
        return permuts;
    }
}
