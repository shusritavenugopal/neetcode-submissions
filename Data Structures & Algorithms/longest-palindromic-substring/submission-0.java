class Solution {
    public String longestPalindrome(String s) {
        // brute force approach

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(i, j, s) && j - i > result.length()) {
                    result = s.substring(i, j);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
