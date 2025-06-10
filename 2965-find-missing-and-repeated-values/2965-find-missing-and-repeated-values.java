class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long totalNumbers = (long) n * n;
        long sn = totalNumbers * (totalNumbers + 1) / 2;
        long s2n = totalNumbers * (totalNumbers + 1) * (2 * totalNumbers + 1) / 6;
        long s = 0, s2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                s += num;
                s2 += (long) num * num;
            }
        }

        long val1 = s - sn; // repeated - missing
        long val2 = s2 - s2n; // repeated² - missing²
        long sum = val2 / val1; // repeated + missing

        int repeated = (int) ((val1 + sum) / 2);
        int missing = (int) ((sum - val1) / 2);

        return new int[]{repeated, missing};
    }
}