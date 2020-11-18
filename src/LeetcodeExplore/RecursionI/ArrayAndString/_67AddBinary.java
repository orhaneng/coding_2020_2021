package LeetcodeExplore.RecursionI.ArrayAndString;

public class _67AddBinary {

    public String addBinary(String a, String b) {
        char[] a_arr = a.toCharArray(); //['1','0','1','0']
        char[] b_arr = b.toCharArray();//['1','0','1','1']
        int indexa=a_arr.length-1; //3
        int indexb=b_arr.length-1;//3
        String result= "";
        int remain=0;

        while(indexa>=0 || indexb>=0){
            if(indexa>=0  && indexb>=0){
                int sum = remain+Character.getNumericValue(a_arr[indexa])+Character.getNumericValue(b_arr[indexb]);
                //sum 1,2,1,2
                remain=sum/2; //0,1,0,1
                result= String.valueOf(sum%2)+result;//0101
                indexa--; //2,1,0,-1
                indexb--; //2,1,0,-1
            }
            if(indexa>=0  && indexb<0){
                int sum =                              remain+Character.getNumericValue(a_arr[indexa]);
                remain=sum/2;
                result= String.valueOf(sum%2)+result;//0101
                indexa--;
            }
            if(indexa<0  && indexb>=0){
                int sum =remain+Character.getNumericValue(b_arr[indexb]);
                remain=sum/2;
                result= String.valueOf(sum%2)+result;//0101
                indexb--;
            }
        }
        if(remain>0){
            result = "1"+result;
        }

        return result;
    }
}
