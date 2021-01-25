package LeetcodeAmazon;

import java.util.*;

/*
937. Reorder Data in Log Files
Easy

944

2684

Add to List

Share
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class _937ReorderDatainLogFiles {

    public static void main(String[] args) {
        String[] items = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        Arrays.stream(reorderLogFiles2(items)).forEach(System.out::println);

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3, 1, 4}));
//        list.sort((a, b) -> {
//            if (a == b) return 0;
//            else if (a < b) return -1;
//            else return 1;
//        });
        //list.sort((a, b) -> a - b);
        //list.forEach(System.out::println);


    }

    static class log {
        String id;
        String firstLetter;
        String text;

        public log(String id, String text, String firstLetter) {
            this.id = id;
            this.text = text;
            this.firstLetter = firstLetter;
        }
    }

    public static String[] reorderLogFiles(String[] logs) {

        String[] res = new String[logs.length];
        LinkedList<String> digits = new LinkedList<>();
        PriorityQueue<log> minheapLetter = new PriorityQueue<log>((a, b) -> {

            if (a.firstLetter.equals(b.firstLetter)) {
                return a.id.compareTo(b.id);
            } else {
                return a.firstLetter.compareTo(b.firstLetter);
            }
        });

        for (String log : logs) {
            String idS = log.split(" ")[0];
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                String firstLetter = log.substring(log.indexOf(" ") + 1);
                minheapLetter.add(new log(idS, log, firstLetter));
            }
        }
        int index = 0;
        while (!minheapLetter.isEmpty()) {
            res[index] = minheapLetter.poll().text;
            index++;
        }
        while (!digits.isEmpty()) {
            res[index] = digits.poll();
            index++;
        }

        return res;

    }

    public static String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            boolean isDigits1 = Character.isDigit(a.split(" ")[1].charAt(0));
            boolean isDigits2 = Character.isDigit(b.split(" ")[1].charAt(0));

            if(!isDigits1&& !isDigits2){
                if(!a.substring(a.indexOf(" ")).equals(b.substring(b.indexOf(" ")))){
                    return a.substring(a.indexOf(" ")).compareTo(b.substring(b.indexOf(" ")));
                }else{
                    return a.split(" ")[0].compareTo(b.split(" ")[0]);
                }
            }else if(isDigits1 && isDigits2){
                return 0;
            } else if(isDigits1 && !isDigits2){
                return 1;
            }else{
                return -1;
            }
        });
        return logs;
    }

}
