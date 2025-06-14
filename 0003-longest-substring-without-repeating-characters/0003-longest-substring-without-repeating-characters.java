class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if(hm.containsKey(c)) {
                left = Math.max(1 + hm.get(c), left);
            }
            hm.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}