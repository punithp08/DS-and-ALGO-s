class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
        if (n < 2) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            
            int[] result1 = expandAroundCenter(s, i, i);
            int currentLen1 = result1[1] - result1[0] + 1;
            
    
            int[] result2 = expandAroundCenter(s, i, i + 1);
            int currentLen2 = result2[1] - result2[0] + 1;

            if (currentLen1 > maxLength) {
                maxLength = currentLen1;
                start = result1[0];
            }
            
            if (currentLen2 > maxLength) {
                maxLength = currentLen2;
                start = result2[0];
            }
        }
        
        return s.substring(start, start + maxLength);
    }

    private int[] expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};  
    }
}