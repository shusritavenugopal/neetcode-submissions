class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // Approach using HashMap
        Map<Character, Integer> sfreq = new HashMap<>();
        Map<Character, Integer> tfreq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sfreq.put(s.charAt(i), sfreq.getOrDefault(s.charAt(i), 0) + 1);
            tfreq.put(t.charAt(i), tfreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sfreq.equals(tfreq);
    }
}
