package LeetcodeExplore.ArrayAndString;

public class _557ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            builder.append(reverse(arr[i]));
            if(i!=arr.length-1)
                builder.append(" ");
        }
        return builder.toString();
    }

    public String reverse (String text){
        if(text.length()<1) return text;
        char[] arr= text.toCharArray();
        int start=0;
        int end=arr.length-1;
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
}
