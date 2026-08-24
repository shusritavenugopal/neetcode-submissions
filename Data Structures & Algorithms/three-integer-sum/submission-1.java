class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(i, nums);
            }
        }
        return result;
    }

    public void twoSum(int current, int[] nums) {
        int left = current + 1;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[current] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right --;
            } else {
                result.add(Arrays.asList(nums[current], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]) left++;
            }
        }
    }
}


