class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
     int n = fruits.length;
        boolean[] basketUsed = new boolean[n];
        int unplacedCount = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!basketUsed[j] && baskets[j] >= fruits[i]) {
                    basketUsed[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplacedCount++;
            }
        }
        return unplacedCount;   
    }
}