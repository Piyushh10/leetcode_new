class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int[] visited = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {

            if(visited[i] == 0){
                List<String> addition = new ArrayList<>();
                addition.add(strs[i]);
                visited[i] = 1;

                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(strs[i], strs[j])) {
                    addition.add(strs[j]);
                    visited[j] = 1;
                    }
                }

                ans.add(addition);
            }
            
        }
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}