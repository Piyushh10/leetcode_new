class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = 0;
        int b = 0;
        int n = s.length;
        int m = g.length;
        int cnt =0;
        while(a < n && b < m){
            if(s[a] >= g[b]){
                cnt++;
                a++;
                b++;
            }else{
                a++;
            }
        }
        return cnt;
    }
}