class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hashmap with String and List<String>
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorteds = String.valueOf(arr);

            if (!map.containsKey(sorteds)) {
                map.put(sorteds, new ArrayList<>());
            }
            map.get(sorteds).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
