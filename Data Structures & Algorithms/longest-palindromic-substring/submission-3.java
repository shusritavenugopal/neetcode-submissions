class Solution {
    public String longestPalindrome(String s) {
        // Dynamic Programming approach
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int start = 0; start + length <= n; start++) {
                int end = start + length - 1;

                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    ans[0] = start;
                    ans[1] = end; 
                }
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }
}
