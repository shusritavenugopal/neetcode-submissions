class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (set.contains(current)) {
                char toRemove = s.charAt(left);
                set.remove(toRemove);
                left++;
            }

            set.add(current);
            result = Math.max(result, right - left + 1);
        } 
        return result;
    }
}
