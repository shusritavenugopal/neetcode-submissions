class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> unique_nums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (unique_nums.contains(nums[i])) {
                return true;
            }
            unique_nums.add(nums[i]);
        }
        return false;
    }
}