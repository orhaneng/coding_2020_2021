package GrokkingCodingPatterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class UniqueGeneralizedAbbreviations {

    public static void main(String[] args) {
        generateAbbreviations("word").forEach(System.out::println);
    }
    public static List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, new StringBuilder(), word, 0 ,0);
        return ans;
    }

    private static void backtracking(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length();

        if (i == word.length()) {
            if (k != 0) builder.append(k);
            ans.add(builder.toString());
        } else {
            backtracking(ans, builder, word, i + 1, k + 1);
            if (k != 0) builder.append(k);

            builder.append(word.charAt(i));
            backtracking(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len);
    }
}
