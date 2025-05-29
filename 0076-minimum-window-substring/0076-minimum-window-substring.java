class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int l = 0;
        int r = 0;
        int count = 0;
        int minl = Integer.MAX_VALUE;
        int index = -1;
        int[] freq = new int[256];

        for(int i = 0; i<n;i++){
            freq[t.charAt(i)]++;
        }

        while(r<m){
            if(freq[s.charAt(r)]>0){
                count++;
            } 
            freq[s.charAt(r)]--;
            while(count == n){
                if(r-l+1 < minl){
                    minl = r-l+1;
                    index = l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] >0){
                    count--;
                } 
                l++;
            }
            r++;
        }
        return index == -1 ? "" : s.substring(index, index+minl);

    }
}