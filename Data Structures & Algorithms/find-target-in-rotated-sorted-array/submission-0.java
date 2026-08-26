class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        // first find the index of the smallest element in the array
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > nums[n-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int rotationPoint = left;
        int answer = binarySearch(nums, 0, rotationPoint - 1, target);
        if (answer != -1) {
            return answer;
        }
        return binarySearch(nums, rotationPoint, n - 1, target);
    }

    private int binarySearch (int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
