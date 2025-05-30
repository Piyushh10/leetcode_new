class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==1) return 1;
        if(n==0) return 1;
        int count = 0;
        for(int i = 0; i<n;i++){
            count += beechMeinSeExpand(s,i,i);
            count += beechMeinSeExpand(s,i,i+1);
        }
        return count;
    }
    private int beechMeinSeExpand(String s, int l, int r){
        int count = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
}