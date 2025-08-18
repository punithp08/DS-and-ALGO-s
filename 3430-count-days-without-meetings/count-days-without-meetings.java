class Solution {
    public int countDays(int days, int[][] meetings) {
     Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int mergedDays = 0;
        if (meetings.length == 0) {
            return days;
        }

        int currentStart = meetings[0][0];
        int currentEnd = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int nextStart = meetings[i][0];
            int nextEnd = meetings[i][1];
            if (nextStart <= currentEnd + 1) {
                currentEnd = Math.max(currentEnd, nextEnd);
            } else {
                mergedDays += currentEnd - currentStart + 1;
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }
        mergedDays += currentEnd - currentStart + 1;

        return days - mergedDays;   
    }
}