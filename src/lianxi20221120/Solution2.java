package lianxi20221120;

public class Solution2 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] volume = new double[query_row + 10][query_row + 10];
        volume[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (volume[i][j] <= 1) continue;
                volume[i + 1][j] += (double)(volume[i][j] - 1) / 2;
                volume[i + 1][j + 1] += (double)(volume[i][j] - 1) / 2;
            }
        }
        return Math.min(volume[query_row][query_glass], 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().champagneTower(25, 6, 1));
    }
}
