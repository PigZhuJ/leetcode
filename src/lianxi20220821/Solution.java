package lianxi20220821;

import java.util.Arrays;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //航班号是从1开始的
        int[] numberOfSeats = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            numberOfSeats[bookings[i][0]-1] += bookings[i][2];
            if(bookings[i][1]<n){
                //最后一位数字不用参与到具体的运算之中
                numberOfSeats[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < numberOfSeats.length; i++) {
            numberOfSeats[i] += numberOfSeats[i - 1];
        }
//        System.out.println(Arrays.toString(numberOfSeats));
        return numberOfSeats;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5));
    }
}