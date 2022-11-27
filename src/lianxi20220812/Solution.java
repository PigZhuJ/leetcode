package lianxi20220812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int[][] tempArray = new int[2][groupSizes.length];
        for (int i = 0; i < groupSizes.length; i++) {
            tempArray[0][i] = groupSizes[i];
            tempArray[1][i] = i;
        }
        System.out.println(Arrays.deepToString(tempArray));

        List<List<Integer>> list = new ArrayList<>();
        //写个冒泡排序，记住排序开始是i=1,第二个是j=0
        for (int i = 1; i < groupSizes.length ; i++) {
            for (int j = 0; j < groupSizes.length - i ; j++) {
                if (tempArray[0][j] > tempArray[0][j + 1]) {
                    int var1 = tempArray[0][j];
                    int var2 = tempArray[1][j];
                    tempArray[0][j] = tempArray[0][j+1];
                    tempArray[1][j] = tempArray[1][j+1];
                    tempArray[0][j+1] = var1;
                    tempArray[1][j+1] = var2;
                }
            }
        }
        System.out.println(Arrays.deepToString(tempArray));

        for (int i = 0; i < tempArray[0].length; i+=tempArray[0][i]) {
           ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < tempArray[0][i]; j++) {
                subList.add(tempArray[1][i+j]);
            }
            list.add(subList);
            System.out.println(subList);
        }

        return list;
    }

    public static void main(String[] args) {
        new Solution().groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
    }
}