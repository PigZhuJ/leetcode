package lianxi20221127;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean check(int[] nums) {
        //遍历x的大小
        int[] tempArr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(tempArr);
        System.out.println(Arrays.toString(tempArr));
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            //对每一个A中的元素进行判断
            for (int j = 0; j < tempArr.length; j++) {
                if (tempArr[j] == nums[(j + i) % nums.length]) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().check(new int[]{1,1,1}));
    }
}