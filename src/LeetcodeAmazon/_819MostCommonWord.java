package LeetcodeAmazon;

import java.util.Arrays;
import java.util.HashMap;

public class _819MostCommonWord {

    public static void main(String[] args) {
        String paragraph ="Bob. hIt, baLl";

        String[] banned = {"bob", "hit"};

        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        //!?',;.
        paragraph = paragraph.replace("!", " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace("'", " ");
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace(".", " ");

        int maxcount=0;
        String res="";
        for (String item : paragraph.split(" ")) {
            if (!Arrays.asList(banned).contains(item) && !item.equals("")) {
                item = item.toLowerCase();
                map.put(item, map.getOrDefault(item, 0) + 1);

                if(map.get(item)>maxcount){
                    res=item;
                    maxcount = map.get(item);
                }
            }
        }
        return res;
    }

}
