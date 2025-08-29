class Solution {
       private List<String> result;
    private String s;
    private int n;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        this.s = s;
        this.n = s.length();
        if (n < 4 || n > 12) {
            return result;
        }
        backtrack(0, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, List<String> current) {
        if (start == n && current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }
        if (start == n || current.size() == 4) {
            return;
        }

        for (int i = start; i < n; i++) {
            String segment = s.substring(start, i + 1);
            if (isValid(segment)) {
                current.add(segment);
                backtrack(i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        if (segment.length() > 3) {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255; 
    }
}