class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(s==null || n<1) return "";
        int l = 0;
        int r = 0;
        for(int i = 0; i<n;i++){
            int l1 = donoTarafSeExpand(s,i,i); //for odd length
            int l2 = donoTarafSeExpand(s,i,i+1); //for even length
            int len = Math.max(l1,l2);
            if(len > r-l){
                l = i - (len-1)/2;
                r = i+len/2;
            }
        }
        return s.substring(l,r+1);
    }
    private int donoTarafSeExpand(String x, int l, int r){
        while(l>=0 && r<x.length() && x.charAt(l) == x.charAt(r)){
            l--;
            r++;
        } 
        return r-l-1;
    }
}