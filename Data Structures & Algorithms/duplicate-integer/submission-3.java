class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int n: nums) {
            if (!ht.containsKey(n)) {
                ht.put(n,1);
            } else {
                return true;
            }
        }
        return false;
    }
}