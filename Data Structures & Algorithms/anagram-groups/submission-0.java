class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] sArray = s.toCharArray(); // [a,c,t]
            Arrays.sort(sArray); // [a,c,t]
            String ssorted = String.valueOf(sArray); //act

            if (!map.containsKey(ssorted)) {
                map.put(ssorted, new ArrayList<>());
            }

            map.get(ssorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
