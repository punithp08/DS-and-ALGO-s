class Solution {
    public int minimumOperations(int[] nums) {
     int n = nums.length;

        if (isDistinct(nums, 0, n - 1)) {
            return 0;
        }

        for (int i = 0; i < n - 1; i++) {
            if (isDistinct(nums, i + 1, n - 1)) {
                return (i + 1 + 2) / 3;
            }
        }

        return (n + 2) / 3;
    }

    private boolean isDistinct(int[] nums, int start, int end) {
        if (start > end) {
            return true;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (seen.contains(nums[i])) {
                return false;
            }
            seen.add(nums[i]);
        }
        return true;   
    }
}