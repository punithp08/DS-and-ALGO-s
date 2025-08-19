class Solution {
    public String robotWithString(String s) {
      char[] minCharSuffix = new char[s.length()];
        minCharSuffix[s.length() - 1] = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >= 0; i--) {
            minCharSuffix[i] = (char) Math.min(s.charAt(i), minCharSuffix[i + 1]);
        }
        Deque<Character> t = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            t.push(currentChar);
            if (i < s.length() - 1) {
                while (!t.isEmpty() && t.peek() <= minCharSuffix[i + 1]) {
                    result.append(t.pop());
                }
            }
        }
        while (!t.isEmpty()) {
            result.append(t.pop());
        }
        return result.toString();  
    }
}