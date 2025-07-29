class Solution {
    public int reverse(int x) {
        int reversedX = 0;
        int maxInt = Integer.MAX_VALUE; 
        int minInt = Integer.MIN_VALUE; 

        while (x != 0) {
            int digit = x % 10;

      
            if (reversedX > maxInt / 10 || (reversedX == maxInt / 10 && digit > 7)) {
                return 0;
            }
            if (reversedX < minInt / 10 || (reversedX == minInt / 10 && digit < -8)) {
                return 0;
            }

            reversedX = reversedX * 10 + digit;
            x /= 10;
        }

        return reversedX; 
    }
}