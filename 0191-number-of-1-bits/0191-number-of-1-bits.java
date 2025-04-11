class Solution {
    public int hammingWeight(int n) {
        String a = Integer.toBinaryString(n);
        int b = 0;
        for(char c : a.toCharArray()){
            if(c == '1'){
                b++;
            }
        }
        return b;
    }
}