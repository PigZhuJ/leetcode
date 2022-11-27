package lianxi20220814;

class Solution {
    public int maxScore(String s) {
        int max = 0;
        int zeroNumber = 0;
        int oneNumber = s.length()-s.replaceAll("1","").length();
//        System.out.println(oneNumber);
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)=='0'){
                zeroNumber++;
            }else {
                oneNumber--;
            }
            System.out.println(zeroNumber);
            System.out.println(oneNumber);

            if(zeroNumber+oneNumber>max){
                max=zeroNumber+oneNumber;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("00"));
    }
}