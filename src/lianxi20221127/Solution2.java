package lianxi20221127;

public class Solution2 {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isFirstEqualstoLastLetters(newString);
    }

    private boolean isFirstEqualstoLastLetters(String newString) {
        if (newString.equals("")) return true;
        if (newString.length() == 1) return true;
        if (newString.charAt(0) == newString.charAt(newString.length() - 1)) {
            return isFirstEqualstoLastLetters(newString.substring(1, newString.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome("race a car"));
    }
}
