class Solution {
    public boolean isPalindrome(int x) {
        int n = x;
        int nn = 0;
        if(x<0){
            return false;
        }
        while(n!=0){
            nn = nn*10 + (n%10);
            n = n/10;
        }
        if(nn==x){
            return true;
        }
        return false;
    }
}