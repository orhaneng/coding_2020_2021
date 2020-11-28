package LeetcodeExplore.ArrayAndString;

public class _28ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0 ){
            return 0;
        }

        char[] h = haystack.toCharArray();//5
        char[] n = needle.toCharArray();//2
        int count=0;
        for(int i=0;i<h.length;i++){  //0,1,2,
            count=0;
            if(h[i]== n[0]){//F,F,T,
                while(count+i<h.length && count<n.length){
                    if(h[count+i] == n[count]){ //T,
                        count++; //
                        if(count == n.length){
                            return i;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
