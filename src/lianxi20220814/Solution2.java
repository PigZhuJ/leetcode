package lianxi20220814;

import java.util.Arrays;

public class Solution2 {
    public int minFallingPathSum(int[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        //declare the variable of dp
        int[][] dp = new int[grid.length][grid[0].length];
        //initial the dp array
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int j = 1; j < dp[0].length; j++) {
            for (int k = 0; k < dp.length; k++) {
                dp[j][k]=Integer.MAX_VALUE;
                for (int l = 0; l < dp.length; l++) {
                    if(l!=k){
                        dp[j][k]=Math.min(dp[j-1][l]+grid[j][k],dp[j][k]);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
           min = Math.min(min,dp[dp.length-1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
