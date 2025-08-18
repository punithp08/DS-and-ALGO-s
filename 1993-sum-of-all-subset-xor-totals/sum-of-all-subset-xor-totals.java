class Solution {
    int totalSum = 0;
    public int subsetXORSum(int[] nums) {
       totalSum = 0;
        findSubsets(nums, 0, 0);
        return totalSum;
    }

    private void findSubsets(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            totalSum += currentXOR;
            return;
        }

        findSubsets(nums, index + 1, currentXOR);

        findSubsets(nums, index + 1, currentXOR ^ nums[index]); 
    }
}