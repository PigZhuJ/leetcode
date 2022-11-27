package lianxi20220818;

import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else if (i == 0 && matrix[i][j] == '1') {
                    height[i][j] = 1;
                } else if (i != 0 && matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else if (i != 0 && matrix[i][j] == '1') {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(height));
        //分别向左找到第一个比他矮的元素和向右找到第一个比他矮的元素
        return 0;
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution().maximalRectangle(array));
    }
}
