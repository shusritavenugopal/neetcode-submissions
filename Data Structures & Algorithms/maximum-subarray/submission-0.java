class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            currentSum = Math.max(n, currentSum + n);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
