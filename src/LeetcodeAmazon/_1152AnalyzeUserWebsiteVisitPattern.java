package LeetcodeAmazon;

//https://leetcode.com/problems/analyze-user-website-visit-pattern/

import java.util.*;

public class _1152AnalyzeUserWebsiteVisitPattern {

    public static void main(String[] args) {
        String[] username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};

        mostVisitedPattern(username,timestamp,website).forEach(System.out::println);

    }

    static class Pair {
        int time;
        String website;

        public Pair(int time, String website) {
            this.time = time;
            this.website = website;
        }
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        HashMap<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> count = new HashMap<String, Integer>();
        String res = "";

        for (String key : map.keySet()) {
            HashSet<String> set = new HashSet<>();
            List<Pair> list = map.get(key);

            Collections.sort(list, (a, b) -> (a.time - b.time));

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i).website + " " +
                                list.get(j).website + " " + list.get(k).website;

                        if (!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            res = str;
                        }

                    }
                }
            }

        }
        String[] r = res.split(" ");
        List<String> result = new ArrayList<>();
        for (String str : r) {
            result.add(str);
        }
        return result;
    }

}
