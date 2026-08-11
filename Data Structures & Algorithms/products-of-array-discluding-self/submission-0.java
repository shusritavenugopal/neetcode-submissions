class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result[i] *= curr;
            curr *= nums[i];
        }

        //[1,1,1,1] -> [1, 1, 2, 8]
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= curr; // [48,24,12,8]
            curr *= nums[i]; // 48
        }

        return result;

    }
}  
