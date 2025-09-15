class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxf=0;
        int l = 0;
        int res = 0;
        for(int r = 0; r<s.length(); r++){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
            maxf=Math.max(maxf, hm.get(s.charAt(r)));

            while((r-l + 1) - maxf > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            }
            res=Math.max(res, r-l+1);
        }
        return res;
    }
}