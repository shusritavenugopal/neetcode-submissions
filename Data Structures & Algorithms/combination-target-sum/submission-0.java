class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();

        backtrack(nums, target, new ArrayList<>(), 0, 0);

        return result;
    }

    private void backtrack(int[] nums, int target, List<Integer> current, int currentSum, int start) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            currentSum += nums[i];

            backtrack(nums, target, current, currentSum, i);

            currentSum -= nums[i];
            current.remove(current.size() - 1);
        }
    }
}
