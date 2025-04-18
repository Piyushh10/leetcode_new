public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i<32; i++){
            int lsb = n & 1;
            int reverseLsb = lsb << (31-i);
            res = res | reverseLsb;
            n = n >> 1;
        }
        return res;
    }
}