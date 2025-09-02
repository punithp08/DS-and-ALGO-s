class Solution {
    Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n >= 5000) {
            return 1.0;
        }
        return prob(n, n);
    }

    private double prob(int a, int b) {
        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }

        double result = 0.25 * (prob(a - 100, b) +
                                prob(a - 75, b - 25) +
                                prob(a - 50, b - 50) +
                                prob(a - 25, b - 75));
        
        memo.put(key, result);
        return result;   
    }
}