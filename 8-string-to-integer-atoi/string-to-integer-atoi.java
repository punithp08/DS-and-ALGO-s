class Solution {
    public int myAtoi(String s) {
      int index = 0;
        int sign = 1;
        long total = 0;

        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n) {
            char firstChar = s.charAt(index);
            if (firstChar == '-') {
                sign = -1;
                index++;
            } else if (firstChar == '+') {
                index++;
            }
        }

        while (index < n) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            if (sign == 1) {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 8)) {
                    return Integer.MIN_VALUE;
                }
            }

            total = total * 10 + digit;
            index++;
        }

        return (int) (total * sign);   
    }
}