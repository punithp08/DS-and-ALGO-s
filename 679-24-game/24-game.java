class Solution {
    public boolean judgePoint24(int[] cards) {
      List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextNums.add(nums.get(k));
                    }
                }

                double a = nums.get(i);
                double b = nums.get(j);

                // Addition
                nextNums.add(a + b);
                if (solve(nextNums)) {
                    return true;
                }
                nextNums.remove(nextNums.size() - 1);

                // Multiplication
                nextNums.add(a * b);
                if (solve(nextNums)) {
                    return true;
                }
                nextNums.remove(nextNums.size() - 1);

                // Subtraction (a - b)
                nextNums.add(a - b);
                if (solve(nextNums)) {
                    return true;
                }
                nextNums.remove(nextNums.size() - 1);

                // Subtraction (b - a)
                nextNums.add(b - a);
                if (solve(nextNums)) {
                    return true;
                }
                nextNums.remove(nextNums.size() - 1);

                // Division (a / b)
                if (b != 0) {
                    nextNums.add(a / b);
                    if (solve(nextNums)) {
                        return true;
                    }
                    nextNums.remove(nextNums.size() - 1);
                }

                // Division (b / a)
                if (a != 0) {
                    nextNums.add(b / a);
                    if (solve(nextNums)) {
                        return true;
                    }
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        return false;  
    }
}