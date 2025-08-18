class Solution {
    public int minOperations(int[] nums, int k) {
    for (int num : nums) {
            if (num < k) {
                return -1;
            }
        }
        
        Set<Integer> uniqueValuesAboveK = new HashSet<>();
        for (int num : nums) {
            if (num > k) {
                uniqueValuesAboveK.add(num);
            }
        }
        
        return uniqueValuesAboveK.size();    
    }
}