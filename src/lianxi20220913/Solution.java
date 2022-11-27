package lianxi20220913;

import java.util.Arrays;

//岛屿，模板题，深度优先搜索
class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    res++;
                }
                dfs(grid, i, j, row, col);
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
        }
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i, j - 1, row, col);
        dfs(grid, i, j + 1, row, col);
    }

    public static void main(String[] args) {
        String str ="123\\d";
        System.out.println(str.replaceAll("\\d","456"));
         }
}