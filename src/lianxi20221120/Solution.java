package lianxi20221120;

class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        if (gain.length == 1) return Math.max(maxHeight, gain[0]);
        for (int i = 1; i < gain.length; i++) {
            gain[i] = gain[i - 1] + gain[i];
            maxHeight = Math.max(Math.max(maxHeight, gain[0]), gain[i]);
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(new Solution().largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}