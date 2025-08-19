class Solution {
    public int maxDifference(String s) {
      Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int maxOddFreq = Integer.MIN_VALUE;
        int minEvenFreq = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency % 2 != 0) {
                if (frequency > maxOddFreq) {
                    maxOddFreq = frequency;
                }
            } else {
                if (frequency < minEvenFreq) {
                    minEvenFreq = frequency;
                }
            }
        }

        return maxOddFreq - minEvenFreq;  
    }
}