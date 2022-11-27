package lianxi20200905;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int rightIndex = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=rightIndex){
                rightIndex=intervals[i][1];
                res++;
            }
        }
        return intervals.length-res;
    }
}