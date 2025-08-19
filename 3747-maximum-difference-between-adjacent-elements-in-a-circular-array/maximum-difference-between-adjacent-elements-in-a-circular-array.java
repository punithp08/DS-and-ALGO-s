class Solution {
    public int maxAdjacentDistance(int[] nums) {
       if (nums.length < 2) {
            return 0;
        }
        int maxDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int currentDiff = Math.abs(nums[i] - nums[i + 1]);
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        int circularDiff = Math.abs(nums[nums.length - 1] - nums[0]);
        if (circularDiff > maxDiff) {
            maxDiff = circularDiff;
        }
        return maxDiff;  
    }
}