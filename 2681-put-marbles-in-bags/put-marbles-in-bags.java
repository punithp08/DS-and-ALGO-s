class Solution {
    public long putMarbles(int[] weights, int k) {
     int n = weights.length;
        if (k == 1) {
            return 0;
        }

        long[] adjacentSums = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            adjacentSums[i] = (long) weights[i] + weights[i + 1];
        }

        Arrays.sort(adjacentSums);

        long minSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += adjacentSums[i];
        }

        long maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            maxSum += adjacentSums[n - 2 - i];
        }

        return maxSum - minSum;   
    }
}