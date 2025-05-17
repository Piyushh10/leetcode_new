class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> huihui = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while(i<n && (intervals[i][1] < newInterval[0])){
            huihui.add(intervals[i]);
            i += 1;
        }
        while(i<n && (intervals[i][0] <= newInterval[1])){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i+=1;
        }
        huihui.add(newInterval);
        while(i<n){
            huihui.add(intervals[i]);
            i+=1;
        }
        return huihui.toArray(new int[huihui.size()][]);
    }
}