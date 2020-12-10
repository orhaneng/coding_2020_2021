package LeetcodeExplore.BinarySearch;
//https://leetcode.com/problems/first-bad-version/

public class _278FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

    public static int firstBadVersion(int n) {
        if(n==1 && isBadVersion(n)) return n;
        int begin =1;
        int end =n;
        while(begin<end){
            int mid = begin+(end-begin)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                begin = mid+1;
            }
        }
        return begin;
    }
    public static boolean isBadVersion(int n){
        if(n== 2) return true;
        return false;
    }
}
