class Solution {
public:
    int longestSubarray(vector<int>& nums) {
int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int maxLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
            } else {
                maxLength = std::max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        maxLength = std::max(maxLength, currentLength);

        return maxLength;
    }
};