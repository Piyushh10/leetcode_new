class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            while (hs.contains(c)) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}