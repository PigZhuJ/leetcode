package lianxi20221211;

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        int max = nums[0];
        if (nums.length == 1) return res;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + 1, nums[i]);
            res += max - nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{1, 1, 1}));
    }
}