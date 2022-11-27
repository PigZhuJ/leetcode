package lianxi20220821;

import java.util.Arrays;

public class Solution2 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] stringArr = sentence.split(" ");
        System.out.println(Arrays.toString(stringArr));
        for (int i = 0; i < stringArr.length; i++) {
            if (stringArr[i].trim().startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().isPrefixOfWord("i love eating burger", "burg"));
    }
}
