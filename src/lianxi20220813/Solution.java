package lianxi20220813;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderArr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                remainderArr[(arr[i]%k+k)%k]++;
            }else {
                remainderArr[arr[i]%k]++;
            }
            System.out.println(Arrays.toString(remainderArr));
        }
        for (int i = 1; i < k-i; i++) {
            if (remainderArr[i]!=remainderArr[k-i]){
                return false;
            }
        }
        return remainderArr[0]%2==0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canArrange(new int[]{-1,-1,-1,-1,2,2,-2,-2}, 3));
    }
}