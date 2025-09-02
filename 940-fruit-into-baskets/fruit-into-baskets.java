class Solution {
    public int totalFruit(int[] fruits) {
     int n = fruits.length;
        if (n <= 2) {
            return n;
        }

        Map<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int currentFruit = fruits[right];
            fruitCount.put(currentFruit, fruitCount.getOrDefault(currentFruit, 0) + 1);

            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;   
    }
}