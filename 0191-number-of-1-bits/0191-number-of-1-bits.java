class Solution {
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int ans = 0;
        for(char c : binary.toCharArray()){
            if(c == '1'){
                ans++;
            }
        }
        return ans;
    }
}