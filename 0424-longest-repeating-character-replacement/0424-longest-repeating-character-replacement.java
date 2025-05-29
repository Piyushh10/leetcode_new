class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxf = 0;
        int maxl = 0;
        int n = s.length();
        int freq[] = new int [26];
        while(r<n){
            freq[s.charAt(r)-'A']++;
            maxf = Math.max(maxf, freq[s.charAt(r)-'A']);
            if((r-l+1)-maxf > k){
                freq[s.charAt(l)-'A']--;
                maxf=0;
                l++;
            }
            if((r-l+1)-maxf <=k){
                maxl=Math.max(maxl, r-l+1);
            }
            r++;
        }
        return maxl;
    }
}